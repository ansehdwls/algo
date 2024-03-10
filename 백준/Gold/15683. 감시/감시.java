import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cam {
	int x;
	int y;
	char type;

	public Cam(int x, int y, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Main {
	static int N;
	static int M;
	static char map[][];
	static char tmap[][];
	static int min = Integer.MAX_VALUE;
	static List<Cam> l = new ArrayList<Cam>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		tmap = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] != '0' && map[i][j] != '6')
					l.add(new Cam(i, j, map[i][j]));
				tmap[i][j] = map[i][j];
			}
		}
		
		go(0);

		System.out.println(min);
	}

	static void go(int start) {
		if (start == l.size()) {
			
			// 사각지대 갯수
			countSafetyArea();
			return;
		} else {
			char temp[][] = new char[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = tmap[i][j];
				}
			}
			int x = l.get(start).x;
			int y = l.get(start).y;
			int type = l.get(start).type;

			// 4방향
			if (type == '1') {
				// 왼쪽일때
				camOn(0,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);

				// 오른쪽일때
				camOn(1,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				// 위쪽일때
				camOn(2,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);

				// 아래쪽 일때
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);

			}
			// 2방향
			else if (type == '2') {
				// 위아래 일때
				camOn(2,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				// 좌우 일때
				camOn(0,x,y);
				camOn(1,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
			}
			// 4방향
			else if (type == '3') {

				// 위 오른쪽일때
				camOn(1,x,y);
				camOn(2,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				// 오른쪽 아래 일때
				camOn(1,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				//아래 왼쪽일때
				camOn(0,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				//왼쪽 위일때
				camOn(0,x,y);
				camOn(2,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
			}
			// 4방향
			else if (type == '4') {

				// 위 좌우일때
				camOn(0,x,y);
				camOn(1,x,y);
				camOn(2,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				// 오른쪽 상하일때
				camOn(1,x,y);
				camOn(2,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				//아래 좌우일때
				camOn(0,x,y);
				camOn(1,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
				//왼쪽 상하일때
				camOn(0,x,y);
				camOn(2,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
				
			}
			// 1번
			else if (type == '5') {
				// 상하좌우
				camOn(0,x,y);
				camOn(1,x,y);
				camOn(2,x,y);
				camOn(3,x,y);
				go(start + 1);
				// 원상 복귀
				makeInit(temp);
			}

		}

	}
	static void makeInit(char temp[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmap[i][j] = temp[i][j];
			}
		}
	}
	static void camOn(int dir, int x, int y) {
		// 왼쪽일때
		if(dir == 0) {
			while (y >= 0) {
				if (map[x][y] == '6')
					break;
				else {
					if (map[x][y] == '0')
						tmap[x][y] = '#';
				}
				y--;
			}
		}
		// 오른쪽일때
		else if(dir == 1) {
			while (y < M) {
				if (map[x][y] == '6')
					break;
				else {
					if (map[x][y] == '0')
						tmap[x][y] = '#';
				}
				y++;
			}
		}
		// 위쪽일때
		else if(dir == 2) {
			while (x >= 0) {
				if (map[x][y] == '6')
					break;
				else {
					if (map[x][y] == '0')
						tmap[x][y] = '#';
				}
				x--;
			}
		}
		// 아래쪽 일때
		else {
			while (x < N) {
				if (map[x][y] == '6')
					break;
				else {
					if (map[x][y] == '0')
						tmap[x][y] = '#';
				}
				x++;
			}
		}
	}
	static void countSafetyArea() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmap[i][j] == '0')
					sum++;
			}
		}

		min = Math.min(sum, min);

	}

}
