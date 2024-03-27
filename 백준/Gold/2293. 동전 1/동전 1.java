import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
	static int N,K;
	static int dp[];
	static int coin[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			coin = new int[N];
			dp = new int[K+1];
			dp[0] = 1;
			
			for(int i = 0; i< N; i++) {
				coin[i] = Integer.parseInt(br.readLine());
				for(int j = coin[i] ; j <= K; j++) {
					dp[j] += dp[j-coin[i]];
				}
			}
			System.out.println(dp[K]);
	}

}
