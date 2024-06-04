import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int count;
	static int dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10];
		for(int i = 1 ; i <= N; i++) {
			dp[i][9] = 1;
			for(int j = 1 ; j < 10; j++) {
				dp[i][9-j] = (dp[i][10-j] + dp[i-1][9-j]) % 10007;
			}
		}
		
		int sum = 0;
		for(int i = 0; i <= 9; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum % 10007);
	}


}
