import java.util.Scanner;

public class Main {
    static int num[];
    static int cache[];
    public static void main(String ars[]){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        num = new int [n];

        int j = 0;
        for(int i = 0 ; i < n ; i++) 
        {
            int a = sc.nextInt();
            
            if(i == 0) {
                num[j] = a;
                j++;
            }
            else{
                if(num[j-1] < 0) 
                {
                        num[j] = a;
                        j++;
                }
                else
                {
                    if(a >= 0) num[j-1] += a;
                    else{
                        num[j] = a;
                        j++;
                    }
                }
            }
        }
        cache = new int [n];
        for(int i = 0 ; i < n ; i++) cache[i] = -1001; 

        cache[0] = num[0];
        maxNum(n-1);

        int max = -1001;
        for(int i = 0 ; i < n; i++){
            max = Math.max(max, cache[i]);
        }
        
        System.out.println(max);
    }

    public static int maxNum(int n)
    {
        if(cache[n] != -1001 );
        else {
            cache[n] = Math.max(maxNum(n-1) + num[n], num[n]);
        }
        return cache[n];
    }
}
