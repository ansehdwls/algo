import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {

	static int N;
	static int R;
	static int Q;
	static Queue<Integer> tree[];
	static int visit[];
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		tree = new LinkedList[N+1];
		dp = new int[N+1];
		visit = new int[N+1];
		Arrays.fill(dp, -1);
		for(int i = 0 ; i<= N; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		int a = 0;
		int b = 0;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		visit[R] = 1;
		go(R);
		for(int i =0  ; i< Q; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}

	}
	static int go(int v) {
		if(dp[v] != -1) return dp[v];
		else {
			dp[v] = 1;
			while(!tree[v].isEmpty()) {
				int child = tree[v].poll();
				if(visit[child] == 0) {
					visit[child] = 1;
					dp[v] += go(child);
					visit[child] = 0;
				}
			}
			
			return dp[v];
		}
	}


}