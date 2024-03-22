
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] a = new int[101][101];
	static final int INF = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer sk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(sk.nextToken());
		int m = Integer.parseInt(sk.nextToken());

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = INF;
			}
			a[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			sk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(sk.nextToken());
			int y = Integer.parseInt(sk.nextToken());

			a[x][y] = 1;
			a[y][x] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
				}
			}
		}
		
		int ans = 100000, idx = -1;
		for (int i = n; i >= 1; i--) {
			int tsum = 0;
			for (int j = 1; j <= n; j++) {
				tsum += a[i][j];
			}
			if (ans >= tsum) {
				ans = Math.min(ans, tsum);
				idx=i;
			}
		}
		bw.write(idx+"\n");

		bw.flush();
		br.close();
		bw.close();

	}
}