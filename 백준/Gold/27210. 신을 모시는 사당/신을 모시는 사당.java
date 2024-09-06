import java.util.*;
import java.io.*;

class Main {

	static int N;
	static int idx[];
	static int idy[];
	static int dp[];
	static int dp1[];
	static int max = 1;
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        idx = new int[N];
        idy = new int[N];
        dp = new int[N];
        dp1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N;i++) {
        	if(Integer.parseInt(st.nextToken()) == 1) {
        		idx[i] = 1;
        		idy[i] = -1;
        	}
        	else {
        		idx[i] = -1;
        		idy[i] = 1;
        	}
        }
        
        dp[0] = idx[0];
        dp1[0] = idy[0];
        
        for(int i = 1; i< N; i++) {
        	dp[i] = Math.max(idx[i], dp[i-1]+idx[i]);
        	dp1[i] = Math.max(idy[i], dp1[i-1]+idy[i]);
        	max = Math.max(max, dp[i]);
        	max = Math.max(dp1[i], max);
        }
        System.out.println(max);
    }
    



}