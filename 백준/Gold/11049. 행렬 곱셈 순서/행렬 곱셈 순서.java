import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static long dp[][];
	static long matrix[][];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		dp = new long [N + 1][N + 1];

		matrix = new long[N+1][2];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(dp[i],  1000000000);
			st = new StringTokenizer(br.readLine());	
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}
		// 1부터 N 까지 최솟값 구해보자
		System.out.println(go(1,N));
		
	}

	static long go(int start, int finish) {
		
		if(start == finish) return 0;
		if(dp[start][finish] != 1000000000) return dp[start][finish];
		
		for(int i= start; i < finish; i++) {
			dp[start][finish] = Math.min(dp[start][finish]
					, go(start,i) + go(i+1, finish) + (matrix[start][0] *matrix[i][1]*matrix[finish][1]));
		}

		
		return dp[start][finish];
	}
}
