
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int N, M, K, T;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int dp[][];
	static int rgb[][];
	static int time[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
	
		dp = new int[N][3];
		rgb = new int [N][3];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 10000001;
	
		for(int start = 0 ; start < 3; start++) {

			for(int i = 0 ; i < 3; i++) {
				dp[0][i] = 1001;
			}
			
			dp[0][start] = rgb[0][start];
			
			
			for(int i = 1; i < N; i++) {
				dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = rgb[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
			for(int i = 0 ; i < 3; i++) {
				if(i != start) result = Math.min(result, dp[N-1][i]);
			}
		}
		
		System.out.println(result);
		
	}

}
