import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int N, M, K;
	static long dp[][];
	static int max = 0;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		/* 개수 dp */
		dp = new long [101][101];
		for(int i = 0 ; i<= 100; i++) Arrays.fill(dp[i], -1);
		
		for(int i = 1 ; i<= 100; i++) {
			dp[0][i] = 1;
			dp[i][0] = 1;
		}
		
	
		while(N * M > 800) {
			System.out.print("a");
			N--;
		}
		go(N,M,K);

				
	}

	static void go(int N, int M, int K) {
		long sum = dr(N, M);
		if(K > sum) {
			System.out.println("-1");
		}
		else {
			while(N != 0 || M != 0) {
				if(N == 1 ) {
					while(--K > 0) {
						System.out.print("z");
						M--;
					}
					System.out.print("a");
					while(M != 0) {
						System.out.print("z");
						M--;
					}
					break;
				}
				if(M == 1) {
					while(N >= K) {
						System.out.print("a");
						N--;
					}
					System.out.print("z");
					while(N > 0) {
						System.out.print("a");
						N--;
					}
					break;
				}
//				System.out.println(K + " " + dr(N-1,M) + " " + dr(N, M-1));
				if(K <= dr(N-1,M) ) {
					System.out.print("a");
//					if(K > dr(N, M-1)) K -= dr(N, M-1);
					N--;
				}
				else {
					System.out.print("z");
					K -= dr(N-1,M);
					M--;
				}
				
			}
		}
	}
	
	static long dr(int i, int j){
		if(dp[i][j] != -1) return dp[i][j];
		
		return dp[i][j] = dr(i-1,j) + dr(i,j-1);
	}

}
