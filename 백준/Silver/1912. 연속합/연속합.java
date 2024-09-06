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
	static int M;
	
	static int dp[];
	static int num[];
	static StringTokenizer st;
	static int max = -1000000001;
	static Queue<Point> l = new LinkedList<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		dp= new int[N+1];
		num = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = num[0];
		
		for(int i = 1 ; i< N; i++) {
			dp[i] = Math.max(num[i], dp[i-1] + num[i]);
		}
		for(int i = 0 ; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
}
