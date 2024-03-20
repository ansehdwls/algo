import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class MovePoint{
	int x;
	int y;
	int z;
	public MovePoint(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class Main {
	static int N, M;
	static int max;
	static int map[][][];
	static boolean check[][][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	static Queue<MovePoint> q = new LinkedList<MovePoint>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map= new int[N][M][2];
		
		
		for(int i = 0; i <N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j][0] = s.charAt(j) - '0';
				map[i][j][1] = map[i][j][0];
			}
		}
		
		System.out.println(bfs(new Point(0,0)));
		
		br.close();
	}

	static int bfs(Point p) {
		q.add(new MovePoint(p.x,p.y,0));
		check = new boolean[N][M][2];
		
		// 본인 시작
		int num = 1;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int k = 0 ; k < size; k++) {
				MovePoint s = q.poll();
				if(s.x == N-1 && s.y == M-1) return num;
				
				if(!check[s.x][s.y][s.z]) {
					check[s.x][s.y][s.z] = true;
					
					for(int i = 0 ; i < 4; i++) {
						int x = s.x+dx[i];
						int y = s.y+dy[i];
						if(x >=0 && x < N && y >= 0 && y < M) {
							// 0 이면 벽 안부셔도 됨.
							if(map[x][y][0] == 0) q.add(new MovePoint(x,y,s.z));
							// 1 이고 벽을 부순횟수가 0라면 벽 부수고 이동
							if(map[x][y][0] == 1) {
								if(s.z == 0) {
									q.add(new MovePoint(x,y,1));
								}
							}
						}
					}
				}
			}
			num++;
		}
		return -1;
	}

}
