import java.util.*;
import java.io.*;

class Main {

	static int N;
	static int M;
	static int C;
	static int matrix[][];
	static int a[];
	static int b[];
	static long dp[][];
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        matrix = new int[C+1][C+1];
        a = new int[N+1];
        b = new int[M+1];
        dp = new long[N+1][M+1];
        
        for(int i = 1 ; i <= C; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1 ; j <= C; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M; i++) {
        	b[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i = 1 ; i <= N; i++) {
        	for(int j = 1 ; j<= M; j++) { 
        		dp[i][j] = dp[i-1][j-1] + matrix[a[i]][b[j]];
        		
        		dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        	}
        }
        
        System.out.println(dp[N][M]);
        
    }
    



}