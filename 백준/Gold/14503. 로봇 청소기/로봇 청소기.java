import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// N: 벨트의 길이, K: 내구도가 0인 칸의 갯수
	static int N, M;
	static Point robot;
	static int map[][];
	// 북 동 남 서
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	// 후진 배열
	static int udx[] = {1,0,-1,0};
	static int udy[] = {0,-1,0,1};
	
	static int dir = 0;
	static int sum = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		robot = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N; i ++) {
			st =  new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			int x = robot.x;
			int y = robot.y;
			// 1. 청소되지 않았다면 청소한다
			if( map[x][y] == 0) {
				sum++;
				map[x][y] = 2;
			}
			
			// 청소할곳이있는지
			boolean isExist = false;
			
			// 2. 4방향 탐색
			for(int i = 0 ; i < 4; i++) {
				int idx = x + dx[i];
				int idy = y + dy[i];
				if(idx >= 0 && idx < N && idy >= 0 && idy < M) {
					if(map[idx][idy] == 0) {
						isExist = true;
						break;
					}
				}
			}
			
			// 3. 청소할곳이있다면
			if(isExist) {
				// 반시계90도 회전한다.
				dir = dir-1;
				if(dir < 0) dir = 3;
				int idx = x + dx[dir];
				int idy = y + dy[dir];
				// 만약 앞에 청소해야한다면 전진한다.
				if(idx >= 0 && idx < N && idy >= 0 && idy < M) {
					if(map[idx][idy] == 0) {
						robot = new Point(idx, idy);
					}
				}
				
			}
			// 2. 청소할 곳이 없다면
			else
			{
				int idx = x + udx[dir];
				int idy = y + udy[dir];
				// 벽이 아니라면 후진 1번으로
				if(idx >= 0 && idx < N && idy >= 0 && idy < M && map[idx][idy] != 1) {
					robot = new Point(idx, idy);
					continue;
				}
				else break;
			}
			
		}
		
		System.out.println(sum);
	}
		

}