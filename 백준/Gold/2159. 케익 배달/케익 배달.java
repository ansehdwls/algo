import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int N;
	static long dp[][];
	static boolean check[];
	static Point start;
	static int dx[] = { 0, 0, 1, -1, 0 };
	static int dy[] = { 1, -1, 0, 0, 0 };
	static List<Point> l = new ArrayList<Point>();
	static StringTokenizer st;

	static long result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new long[N + 1][5];

		check = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());

		start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			l.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

		}
		for (int j = 0; j < 5; j++) {
			dp[0][j] = distance(start.x, start.y, l.get(0).x + dx[j], l.get(0).y + dy[j]);
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				if (l.get(i).x + dx[j] >= 0 && l.get(i).y + dy[j] >= 0 && l.get(i).y + dy[j] < 100001
						&& l.get(i).x + dx[j] < 100001) {

					start = new Point(l.get(i).x + dx[j], l.get(i).y + dy[j]);
					for (int dir = 0; dir < 5; dir++) {
						if (l.get(i - 1).x + dx[dir] >= 0 && l.get(i - 1).x + dx[dir] < 100001
								&& l.get(i - 1).y + dy[dir] >= 0 && l.get(i - 1).y + dy[dir] < 100001) {
							
							if(dp[i][j] == -1) dp[i][j] = dp[i - 1][dir]
									+ distance(start.x, start.y, l.get(i - 1).x + dx[dir], l.get(i - 1).y + dy[dir]);
							else {
							dp[i][j] = Math.min(dp[i][j], dp[i - 1][dir]
									+ distance(start.x, start.y, l.get(i - 1).x + dx[dir], l.get(i - 1).y + dy[dir]));
							}
						}
					}
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println();
//			for (int j = 0; j < 5; j++) {
//				System.out.println("dp[" + i + "][" + j + "]  = " + dp[i][j]);
//			}
//		}

		result = dp[N-1][0];
		for (int j = 0; j < 5; j++) {
			result = Math.min(result, dp[N-1][j]);
		}

		
		System.out.println(result);
	}

	static long distance(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}
}
