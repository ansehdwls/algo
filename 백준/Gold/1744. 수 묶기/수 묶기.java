import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N, M;

    static int num[];
    static int pnum[];
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int [N];
        pnum = new int [N];
        int n = 0;
        int up = 0;
        int down = 0;
        for(int i = 0 ; i < N; i++) {
            n = Integer.parseInt(br.readLine());
            if(n > 0) {
            	up++;
            	num[i] = n;
            }
            else {
            	down++;
            	pnum[i] = n;
            }
        }

        Arrays.sort(num);
        Arrays.sort(pnum);       

        for(int i = N-1; i >= N-up; i--) {
        	if(i-1 >= 0 ) {
        		if(num[i] * num[i-1] > num[i] + num[i-1]) {
        			sum += num[i] * num[i-1];
        			i--;
        		}
        		else {
        			sum += num[i];
        		}
        	}
        	else {
        		sum += num[i];
        	}
        }
        for(int i = 0; i < down; i++) {
        	if(i+1 < down ) {
        		if(pnum[i] * pnum[i+1] > pnum[i] + pnum[i+1]) {
        			sum += pnum[i] * pnum[i+1];
        			i++;
        		}
        		else {
        			sum += pnum[i];
        		}
        	}
        	else {
        		sum += pnum[i];
        	}
        }
        
        System.out.println(sum);
    }


}
