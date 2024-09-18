import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {

	static int N;
	static Queue<Integer> tree[];
	static int v[];
	static int visit[];
	static long dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		tree = new LinkedList[N + 1];
		dp = new long[N + 1];
		
		v = new int[N+1];
		visit = new int[N + 1];
		
		for(int i = 0; i < N+1; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0 ; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<= N-1; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		visit[0] = 1;
		go(0);
		System.out.println(dp[0]);
		
	}
	
	static void go(int r) {
		dp[r] = v[r];
		
		while(!tree[r].isEmpty()) {
			int child = tree[r].poll();
			
			if(visit[child] == 1) continue;
			visit[child] = 1;
			go(child);
			
			dp[r] = Math.max(dp[r], dp[r]+dp[child]);
		}
		
	}
	
	
}