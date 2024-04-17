import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	static StringTokenizer st;
	static int num1[];
	static int num2[];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			num1 = new int [N];
			num2 = new int [N];

			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< N; i++) {
				num1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< N; i++) {
				num2[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[3][N];
			
			dp[1][0] = num1[0];
			dp[2][0] = num2[0];
			
			for(int i = 1 ; i< N; i++) {
				
				dp[1][i] = Math.max(dp[1][i-1], num1[i] + dp[2][i-1]);
				dp[2][i] = Math.max(dp[2][i-1], num2[i] + dp[1][i-1]);
				
			}
			System.out.println(Math.max(dp[1][N-1], dp[2][N-1]));
		}
		
		
	}

}