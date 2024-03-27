import java.util.Scanner;

public class Main {
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		if(N%2 == 1) System.out.println(0);
		else {
			dp = new int [N/2 +1];
			dp[0] = 1;
			dp[1] = 3;
			for(int i = 2; i <= N/2; i++) {
				dp[i] += 3 * dp[i-1];
				for(int j = 2; j <= i; j++) {
					dp[i] += 2 * dp[i-j];
				}
			}
			System.out.println(dp[N/2]);
		}
	}

}