import java.util.*;
import java.io.*;

class Main {

	static int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] W;
	static boolean check[];
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
        
        
        System.out.println(go(0,1));
    }
    
    static long go(int idx, int visit) {
    	if(visit == (1<<N) -1 ) {
    		if(W[idx][0] == 0) return INF;
            return W[idx][0];
    	}
    	
    	if(dp[idx][visit] != -1) return dp[idx][visit];
    	
    	dp[idx][visit] = INF;
    	
    	for(int i = 0 ; i < N; i++) {
        	
    		if( ( visit & (1<<i)) != 0 || W[idx][i] == 0) continue;
    		
    		dp[idx][visit] = Math.min(dp[idx][visit], go(i, visit | (1 << i) ) + W[idx][i]);
    	}
    	
    	
    	return dp[idx][visit];
    	
    }


}