import java.util.*;
import java.io.*;

class Main {

	static int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] W;
	static long[][] dp;
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    
        W = new int [N][N];
        dp = new long [N][(1<<N)];
        
        for(int i = 0 ; i < N; i++)
        	Arrays.fill(dp[i], -1);
        
        for(int i = 0 ; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		W[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        System.out.println(go(0,0));
    }
    
    static long go(int idx, int visit) {
    	if(idx == N || visit == (1<<N)-1  ) {
            return 0;
    	}
    	
    	if(dp[idx][visit] != -1) return dp[idx][visit];
    	
    	dp[idx][visit] = INF;
    	
    	for(int i = 0 ; i < N; i++) {

    		if( ( visit & (1<<i)) != 0 ) continue;
    		
    		dp[idx][visit] = Math.min(dp[idx][visit], go(idx+1, (visit | (1 << i)) ) + W[idx][i]);
    	}
    	
    	
    	return dp[idx][visit];
    	
    }


}