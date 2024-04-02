import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B;
	static StringTokenizer st;
	static int dp[];
	static int key[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			key = new int[N];
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< N; i++) {
				key[i] = Integer.parseInt(st.nextToken());
				sum += key[i]; 
			}
			
			dp = new int[sum+1];
			for(int i = 0 ; i<= sum; i++) {
				dp[i] = 100000;
			}
			dp[0] = 0;
			for(int i = 0 ; i< N; i++) {
				for(int j = sum ; j >= key[i] ; j--) {
					dp[j] = Math.min(dp[j], dp[j-key[i]] + 1);
				}
			}

			for(int i = B; i<= sum; i++) {
				if(dp[i] != 100000) {
					System.out.println("#"+t+" "+ (i- B));
					break;
				}
			}
		}
	}
	
}
