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
	static int T ;
	static StringTokenizer st;
	static int dp[];
	static int num[] = {1,2,3};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		dp = new int [10001];
		
		for(int i = 0; i < 3; i++) {
			dp[0] = 1;
			for(int j = num[i]; j <= 10000; j++) {
				dp[j] = dp[j] + dp[j-num[i]];
			}
		}

		for(int i = 0 ; i< T; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
		

	}
}