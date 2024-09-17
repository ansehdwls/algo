import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {

	static int N;
	static Queue<Integer> tree[];
	static int v[];
	static int visit[];
	static long dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		tree = new LinkedList[N + 1];
		dp = new long[N + 1][2];
		v = new int[N+1];
		visit = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new LinkedList<Integer>();
			Arrays.fill(dp[i], -1);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			v[i] = Integer.parseInt(st.nextToken());;
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		visit[1] = 1;
		System.out.println(go(1));


	}

	static long go(int a) {

		dp[a][0] = 0;
		dp[a][1] = v[a];
		while (!tree[a].isEmpty()) {
			int child = tree[a].poll();
			if (visit[child] != 1) {
				visit[child] = 1;
				go(child);

				// 내가 우수마을이라면 모두가 일반 마을
				dp[a][1] += dp[child][0];

				// 일반 마을 이라면. 적어도 한개의 우수마을 과연결
				dp[a][0] += Math.max(dp[child][0], dp[child][1]);

			}
		}
		return Math.max(dp[a][0], dp[a][1]);
	}

}