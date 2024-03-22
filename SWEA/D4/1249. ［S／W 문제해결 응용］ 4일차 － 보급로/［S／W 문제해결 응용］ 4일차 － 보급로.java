import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Move implements Comparable<Move> {
	int x;
	int y;
	int time;
	int wait;

	public Move(int x, int y, int time, int wait) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.wait = wait;
	}

	@Override
	public int compareTo(Move o) {
		return this.time - o.time;
	}
	
	
}

public class Solution {
	static int N;
	static int r_map[][];
	static int lev;
	static boolean check[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static PriorityQueue<Move> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String s;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			r_map = new int[N][N];

			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < N; j++) {
					r_map[i][j] = Integer.parseInt(s.charAt(j) + "");
				}
			}

			// lev , check, q 초기화
			lev = Integer.MAX_VALUE;
			check = new boolean[N][N];
			q = new PriorityQueue<Move>();

			// 시작점은 0,0 도착점은 N-1, N-1
			q.add(new Move(0, 0, 0, 0));

			// 도착했을때 종료
			while (!q.isEmpty() && !check[N - 1][N - 1]) {

				Move p = q.poll();

				if (p.wait > 0) {
					q.add(new Move(p.x, p.y, p.time + 1, p.wait - 1));
					continue;
				}

				if (!check[p.x][p.y]) {
					check[p.x][p.y] = true;

					if (p.x == N - 1 && p.y == N - 1) {
						lev = p.time;
						break;
					}

					for (int j = 0; j < 4; j++) {
						int x = p.x + dx[j];
						int y = p.y + dy[j];

						if (x >= 0 && y >= 0 && x < N && y < N) {
							if (!check[x][y]) q.add(new Move(x, y, p.time, r_map[x][y]));
						}
					}
				}

			}

			System.out.println("#" + t + " " + lev);
		}

	}

}
