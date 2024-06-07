import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int T,N;
	static long dp[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		dp = new long [1000001][4];
		dp[0][0] = 1; // 기본 1
		dp[1][1] = 1; // 1
		dp[1][0] = 1;
		dp[2][1] = 1; // 1 + 1 , 2
		dp[2][2] = 1; 
		dp[2][0] = 2;
		dp[3][1] = 1; // 1 + 1 + 1, 3
		dp[3][3] = 1;
		dp[3][0] = 2;
		for(int i = 4; i <= 1000000; i++ ) {
			// 끝자리 1
			dp[i][1] += dp[i-2][0];

			// 끝자리 2
			if(i - 4 >= 0)
				dp[i][2] += dp[i-4][0];
			// 끝자리 3
			if(i-6 >= 0)
				dp[i][3] += dp[i-6][0];
			dp[i][0] = (dp[i][1] + dp[i][2] + dp[i][3])%1000000009;
		}
		for(int i = 0 ; i< T; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())][0]);
		}
	}

}
