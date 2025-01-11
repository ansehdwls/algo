import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N, M, K;

    static int p[];
    static int num[];
    static int temp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        num = new int[M];
        p = new int [M+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M; i++) {
        	num[i-1] = Integer.parseInt(st.nextToken());
        	p[i] = i;
        }
        Arrays.sort(num);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++){
        	
            temp = Integer.parseInt(st.nextToken());
            
            int left = 0;
            int right = M - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (temp >= num[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            int index = find(left);
            sb.append(num[index] + "\n");
            union(index, index + 1);
        }
        System.out.print(sb);
        
    }
    static boolean union(int x, int y){
        int a = find(x);
        int b = find(y);
        if (a == b) return false;
        else if (a > b)
            p[b] = a;
        else
            p[a] = b;
        return true;
    }

    static int find(int x){
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
        
    }    
}
