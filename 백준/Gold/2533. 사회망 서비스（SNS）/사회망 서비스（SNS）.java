import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {

	static int N;
	static int R;
	static int Q;
	static Queue<Integer> tree[];
	static int visit[];
	static int dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		tree = new LinkedList[N + 1];
		dp = new int[N + 1][2];
		visit = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new LinkedList<Integer>();
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		visit[1] = 1;
		System.out.println(go(1));

	}

	static int go(int v) {

		dp[v][0] = 0;
		dp[v][1] = 1;
		while (!tree[v].isEmpty()) {
			int child = tree[v].poll();
			if (visit[child] != 1) {
				visit[child] = 1;
				go(child);

				// 내가 얼리어답터가 아니라면? 모두가 얼리어답터여야함
				dp[v][0] += dp[child][1];

				// 얼리어답터라면? 얼리어답터이거나, 아니거나 최소값.
				dp[v][1] += Math.min(dp[child][0], dp[child][1]);

			}
		}
		return Math.min(dp[v][0], dp[v][1]);
	}

}