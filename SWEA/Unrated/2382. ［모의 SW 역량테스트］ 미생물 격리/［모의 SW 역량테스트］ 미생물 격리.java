import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Cell {

	int x;
	int y;
	int dir;
	int num;

	public Cell(int x, int y, int num, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.num = num;
	}
}

public class Solution {
	static int N, M, K;
	static StringTokenizer st;
	static Deque<Cell> q;

	static int dx[] = { 0, -1, 1, 0, 0 };
	static int dy[] = { -1, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());


		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			q = new LinkedList<Cell>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				q.add(new Cell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			// M 시간 만큼 이동
			for (int m = 1; m <= M; m++) {

				// cell들의 상태를 저장할 맵
				int cell_map[][][] = new int[3][N][N];

				// 미생물 움직이기
				while (!q.isEmpty()) {
					Cell temp = q.poll();
					int idx = temp.x + dx[temp.dir];
					int idy = temp.y + dy[temp.dir];
					// 이미 미생물이 도착했다면 최대값 비교 후 방향 설정
					if (cell_map[0][idx][idy] > 0) {
						if (cell_map[0][idx][idy] < temp.num) {
							cell_map[0][idx][idy] = temp.num;
							cell_map[1][idx][idy] = temp.dir;
						}
						cell_map[2][idx][idy] += temp.num;
					}
					// 아무것도 없다면 세포값 저장
					else {
						cell_map[0][idx][idy] = temp.num;
						cell_map[1][idx][idy] = temp.dir;
						cell_map[2][idx][idy] += temp.num;
					}
				}

				// 미생물 합치기 or 절반 죽음 , 미생물 넣기
				for(int i = 0 ; i < N; i++) {
					for(int j = 0 ; j < N; j++) {
						// 값이 있다면 확인
						if(cell_map[0][i][j] > 0) {
							//만약 가장 자리라면 절반 없애고 방향 반대로
							if(i == 0 || j == 0 || i == N-1 || j == N-1) {
								// 만약 세포가 1개라면 사라짐
								if(cell_map[2][i][j] > 1) {
									switch(cell_map[1][i][j]) {
										case 1 : q.add(new Cell(i,j,cell_map[2][i][j]/2,2)); break;
										case 2 : q.add(new Cell(i,j,cell_map[2][i][j]/2,1)); break;
										case 3 : q.add(new Cell(i,j,cell_map[2][i][j]/2,4)); break;
										case 4 : q.add(new Cell(i,j,cell_map[2][i][j]/2,3)); break;
							
									}
								}
							}
							// 미생물 바로 넣기
							else {
								q.add(new Cell(i,j,cell_map[2][i][j],cell_map[1][i][j]));
							}
						}
					}
				}
			}
			
			// 미생물 수 구하기
			int sum = 0;
			
			while(!q.isEmpty()) {
				sum += q.poll().num;
			}
			
			System.out.println("#"+t+" "+sum);

		}
	}

}
