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
	static int dp[];

	static int min = 11;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new int [1001];
		dp[1] = 1;
		dp[2] = 2;
		go(N);
		System.out.println(dp[N]);
	}
	static int go(int n) {
		
		if(n <= 0) return 0;
		
		if(dp[n] != 0) return dp[n];
		
		dp[n] = (go(n-1) + go(n-2)) % 10007;
		
		
		return dp[n];
	}

}
