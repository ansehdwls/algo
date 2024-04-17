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
	static int N, K;
	static StringTokenizer st;
	static int num[];
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		dp = new int[50001];
		for(int i = 0 ; i <= 50000; i++) {
			dp[i] = 50000;
		}
		dp[0] = 0;
		for(int i = N-1; i >= 0; i--) {
			for(int j = 50000 ; j >= num[i] ; j--) {
				dp[j] = Math.min(dp[j] , dp[j- num[i]] + 1 );
			}
//			for(int j = 0 ; j< 23; j++) {
//				System.out.println(j+" " + dp[j] + " ");
//			}
//			System.out.println();
		}
		int sum = 0;
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 1 ; i<= 50000; i++) {
			if(dp[i] <= K ) {
				l.add(i);
			}
		}
		System.out.println(l.size());
		for(int i = 0 ; i< l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		
	}

}