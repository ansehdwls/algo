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
		dp = new long [1001][1001];
		dp[1][1] = 1; // 1
		
		dp[2][1] = 1; // 1 + 1 , 2
		dp[2][2] = 1; 
		
		dp[3][1] = 1; // 1 + 1 + 1, 1 + 2, 2 + 1,  3
		dp[3][2] = 2;
		dp[3][3] = 1;
		for(int i = 4; i <= 1000; i++ ) {
			dp[i][i] = 1;
			for(int k = 2; k < i; k++) {
				dp[i][k] += (dp[i-1][k-1] + dp[i-2][k-1] + dp[i-3][k-1])% 1000000009;
			}

		}
		for(int i = 0 ; i< T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(dp[n][m]);
		}
	}

}
