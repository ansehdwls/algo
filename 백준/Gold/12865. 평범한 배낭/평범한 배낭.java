import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static StringTokenizer st;
	static String s;
	static int bag[];
	static int v[];
	static int dp[];

	static int min = 11;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bag = new int [N];
		v = new int [N];
		dp = new int[K+1];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		
		for(int i = 0 ; i < N; i++) {
			for(int j = K; j >=0 ; j--) {
				if(j-bag[i] >= 0) {
					dp[j] = Math.max(dp[j], dp[j-bag[i]] + v[i]);
				}
			}
		}
		
		System.out.println(dp[K]);
		
	}


}
