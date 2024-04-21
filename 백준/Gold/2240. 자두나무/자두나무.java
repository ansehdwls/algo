import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int T, W ;
	static StringTokenizer st;
	
	static int num[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		num = new int[T];
		for (int i = 0; i < T; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		int[][][] dp = new int[T + 1][W + 2][3];
		
		int max = 0;

		for (int t = 1; t <= T; t++) {
			for (int w = 1; w <= W+1; w++) {
				 if (num[t-1] == 1) {
	                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]) + 1;
	                    dp[t][w][2] = Math.max(dp[t - 1][w][2], dp[t - 1][w - 1][1]);
	                } else {
	                    if (t == 1 && w == 1) continue;
	                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]);
	                    dp[t][w][2] = Math.max(dp[t - 1][w][2], dp[t - 1][w - 1][1]) + 1;
	                }
				 max = Math.max(max, Math.max(dp[t][w][1], dp[t][w][2]));
			}
			
		}

		
		System.out.println(max);
	}
}