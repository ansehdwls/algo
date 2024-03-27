import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N,K;
	static int dp[];
	static int coin[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			coin = new int[N];
			dp = new int[K+1];
			
			for(int i = 0; i < K+1; i++) {
				dp[i] = 100000;
			}
			for(int i = 0 ; i < N; i++ ) {
				coin[i] = Integer.parseInt(br.readLine());
				if(coin[i] <= K) {
					dp[coin[i]] = 1;
					for(int j = coin[i]; j <= K ; j++) {
						dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
					}
				}
			}
			
			if(dp[K] == 100000) System.out.println("-1"); 
			else System.out.println(dp[K]);
			
	}
//	static int minNum(int k) {
//		if(k < 0) return 100000;
//		if(dp[k] != 100000) {
//			return dp[k];
//		}
//		for(int i = 0 ; i< N; i++) {
//			dp[k] = Math.min(dp[k], minNum(k-coin[i])+1);
//		}
//		return dp[k];
//	}
}
