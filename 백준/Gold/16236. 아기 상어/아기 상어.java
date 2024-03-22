import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int sea[][];
	static boolean check[][];
	static Queue<Point> q;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int time = 0;

	// 상어 정보
	static Point shark;
	static int size = 2;

	// 물고기 정보
	static List<Point> l[] = new ArrayList[7];

	static int max = 0;
	// 집 list
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		sea = new int[N][N];
		for (int i = 1; i < 7; i++)
			l[i] = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 0)
					continue;
				else if (sea[i][j] < 9) {
					l[sea[i][j]].add(new Point(i, j));
				}
				else {
					shark = new Point(i, j);
					sea[i][j] = 0;
				}
			}
		}

		int lev = 0;

		while (true) {

			// 먹을 수 있는 물고기가 있는지 찾아보자.

			int dis = 0; // 물고기와의 거리
			int min = Integer.MAX_VALUE; // 거리의 최소 값
			int fx = 0; // 물고기의 x 좌표
			int fy = 0; // 물고기의 y 좌표
			int idx = 0;
			int idy = 0;

			// 먹을 수 있는 size
			int fsize = (size < 7) ? size : 7;
			for (int i = 1; i < fsize; i++) {
				for (int j = 0; j < l[i].size(); j++) {
					dis = SharkToFish(shark, l[i].get(j));
					// 가장 가까운 물고기 정보 저장
					if (min > dis) {
						min = dis;
						idx = i;
						idy = j;
						fx = l[i].get(j).x;
						fy = l[i].get(j).y;
					}
					// 거리가 같다면 가장 위
					else if (min == dis) {
						if (fx > l[i].get(j).x) {
							min = dis;
							idx = i;
							idy = j;
							fx = l[i].get(j).x;
							fy = l[i].get(j).y;
						}
						// 그것도 같다면 가장 왼쪽
						else if (fx == l[i].get(j).x) {
							if (fy > l[i].get(j).y) {
								min = dis;
								idx = i;
								idy = j;
								fx = l[i].get(j).x;
								fy = l[i].get(j).y;
							}

						}
					}
				}
			}
//			System.out.println("shark : " + shark.x + " " + shark.y + " " + time);
//			System.out.println("fish : " + fx + " " + fy + " " +min);
			
			// 먹을 수 있는 물고기가 없다면, 갈 수 없다면
			if (dis == 0 || min == 999999) {
				break;
			}

			// 물고기를 먹는다
			shark = new Point(fx, fy);
			sea[fx][fy] = 0;
			time += min;
			l[idx].remove(idy);
			// 상어의 size 증가
			lev++;
			if (lev == size) {
				size++;
				lev = 0;
			}

		}
		System.out.println(time);

	}

	static int SharkToFish(Point s, Point f) {

		int dis = 0;
		check = new boolean[N][N];
		q = new LinkedList<Point>();
		q.add(s);

		while (!q.isEmpty() && !check[f.x][f.y]) {

			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				Point p = q.poll();
				
				if (!check[p.x][p.y]) {
					check[p.x][p.y] = true;

					for (int j = 0; j < 4; j++) {
						int x = p.x + dx[j];
						int y = p.y + dy[j];
						if (x >= 0 && y >= 0 && x < N && y < N) {
							if (size >= sea[x][y] && !check[x][y])
								q.add(new Point(x, y));
						}
					}
				}
			}
			
			dis++;
		}
		if(check[f.x][f.y]) return dis-1;
		else return 999999;
	}
}
