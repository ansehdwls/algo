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

	static int dp[];
	static int score[];
	static int time[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		dp = new int[T+1];
		score = new int [N];
		time = new int[N];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 0 ; j < N; j++) {
			for(int i = T ; i >= 0; i--) {
				if(i-time[j] >= 0) {
					dp[i] = Math.max(dp[i], dp[i-time[j]] + score[j]);
				}
			}	
		}
		
		System.out.println(dp[T]);
		
	}

}
