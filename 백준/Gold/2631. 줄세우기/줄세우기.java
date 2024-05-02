import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N ;
	static StringTokenizer st;
	static int num[];
	static int dp[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		dp = new int [N];
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp, 1);
		int max = 0;

		for(int i = 1; i < N; i++) {
			for(int j = 0 ; j < i; j++) {
				if(num[j] < num[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(N-max);
		
	}

}