import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N, M, T;

    static long [][] dp;
    static long sum = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        T = Integer.parseInt(st.nextToken());
        dp = new long [11][4001];
        
        
        Arrays.fill(dp[1], 1);

        for(int i=2; i<11; i++){
            for(int j = 1; j < 4001 ;j++){
                if(dp[i-1][j] != 0){
                    for(int k =j*2; k<=4000; k++){
                        dp[i][k] += dp[i-1][j];
                    }
                }
            }
        }
        
        for(int i = 0 ; i < T ; i++) {
        
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        	
            sum =0;
            for(int j=1; j <= M; j++){
                sum +=dp[N][j];
            }
            System.out.println(sum);
        }

        
    }

}
