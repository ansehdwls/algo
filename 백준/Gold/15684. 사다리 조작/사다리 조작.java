import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int map[][];
	static int min = Integer.MAX_VALUE;
	static List<Point> l = new ArrayList<Point>();
	static int dy[] = { 1, -1};
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		// 사다리 판 생성
		map = new int[H+2][N+2];

		// 기존 사다리 배치
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		// 사다리 배치 된게 없다면 무조건 0
		if (M == 0) {
			System.out.println(0);
		} 
		// 배치할 수 있는 사다리 위치를 찾아보자.
		else {
			for (int i = 1; i < H+1; i++) {
				for (int j = 1; j < N; j++) {
					// 현재 사다리가 없을때
					if (map[i][j] != 1) {
						// 좌우에 사다리가 없어야한다. ( 연속 이나 겹침 x )
						boolean ispos = true;
						for(int dir = 0; dir < 2; dir++) {
							if(map[i][j + dy[dir]] == 1) {
								ispos =false;
								break;
							}
						}
						// 가능하다면 위치 저장
						if(ispos) {
							l.add(new Point(i,j));
						}
					}
				}
			}

			go(0, 0);
			// 값이 변하지 않았다면 -1
			if (min == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(min);
		}

	}

	static void go(int idx, int start) {
		if(idx > 3) {
			return ;
		}
		if (isPossible()) {
			min = Math.min(min, idx);
			return;
		}
		// 불가능하다면 사다리 놓기
		else {
			for (int i = start; i < l.size(); i++) {

				int x = l.get(i).x;
				int y = l.get(i).y;
				// 좌우 비교해서 사다리가 없다면 놓을 수 있음
				boolean ispos = true;
				for(int dir = 0; dir < 2; dir++) {
					if(map[x][y + dy[dir]] == 1) {
						ispos = false;
						break;
					}
				}
				if(ispos) {
					map[x][y] = 1;
					go(idx + 1, i + 1);
					map[x][y] = 0;
				}
			}
		}
	}

	// 사다리 타기 비교
	static boolean isPossible() {

		for (int start = 1; start <= N; start++) {
			int move = start;
			int dep = 1;
			while (dep != H+1) {
				if (map[dep][move] == 1) {
					move++;

				} else if (map[dep][move - 1] == 1) {
					move--;
				}
				dep++;
			}
			if (move != start)
				return false;
		}

		return true;
	}
}
