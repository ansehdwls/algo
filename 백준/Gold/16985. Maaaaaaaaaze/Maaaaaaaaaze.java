import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXYZ{
	
	int x;
	int y;
	int z;
	public PointXYZ(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int maze[][][];
	// 시작점
	static PointXYZ s_p = new PointXYZ(0,0,0);
	static int tmaze[][][];
	static int dx[] = {1, -1, 0, 0, 0, 0};
	static int dy[] = {0, 0, 1, -1, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
	
//	static List<int[][]> l = new ArrayList<int[][]>();
	static int check[] = new int[5];
	static int min = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		maze = new int[5][5][5];
		tmaze = new int[5][5][5];
		StringTokenizer st;
		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j < 5; j++) {
				 st = new StringTokenizer(br.readLine());
				for(int k = 0  ; k < 5;  k++) {
					maze[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// maze 만들기
		go(0);

		System.out.println(min);
		
		
		br.close();
	}
	
	static void go (int idx) {
		
		if( idx == 5) {
			
			// 시작이나 끝이 못간다면 시도 x
			if(tmaze[0][0][0] == 0 || tmaze[4][4][4] == 0);
			else {
				bfs();
			}
		}
		else {
			for(int i = 0 ; i < 5; i++) {
				if(check[i] == 0) {
					check[i] = 1;
					// 4방향
					for(int j = 0 ; j < 4; j++) {
						makeMaze(idx,j,i);
						go(idx +1);
					}
					check[i] = 0;
				}
			}
		}
	}
	static void makeMaze(int idx, int  dir, int z){
		// 90도 회전
		if(dir == 1) {
			for(int i = 0; i < 5; i++) {
				for(int j =  0 ; j < 5; j++) {
					tmaze[i][j][idx] = maze[4-j][i][z]; 
				}
			}
		}
		// 180도 회전
		else if(dir ==  2 )
		{
			for(int i = 0; i < 5; i++) {
				for(int j =  0 ; j < 5; j++) {
					tmaze[i][j][idx] = maze[4-i][4-j][z]; 
				}
			}
			
		}
		
		// 270도 회전
		else if( dir == 3) {
			for(int i = 0; i < 5; i++) {
				for(int j =  0 ; j < 5; j++) {
					tmaze[i][j][idx] = maze[j][4-i][z]; 
				}
			}
		}
		
		// dir == 4는 360도 본인
		else {
			for(int i = 0; i < 5; i++) {
				for(int j =  0 ; j < 5; j++) {
					tmaze[i][j][idx] = maze[i][j][z]; 
				}
			}
		}
	}
	static void bfs() {
		int visit[][][] = new int[5][5][5];
		Queue<PointXYZ> q = new LinkedList<PointXYZ>();
		q.add(s_p);
		
		
		int lev = 0;
		
		while(!q.isEmpty()) {
			lev++;
			int qsize = q.size();
			for(int j = 0 ; j < qsize ; j++) {
				PointXYZ p = q.poll();
				if(visit[p.x][p.y][p.z] == 0) {
					visit[p.x][p.y][p.z] = 1;
					
					if(p.x == 4 && p.y == 4 && p.z == 4) {
						q.removeAll(q);
						lev--;
						break;
					}
					
					for(int i = 0 ; i < 6; i++) {
						int x = p.x+ dx[i];
						int y = p.y + dy[i];
						int z = p.z + dz[i];
						
						if(x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5) {
							if(visit[x][y][z] == 0 && tmaze[x][y][z] == 1) {
								q.add(new PointXYZ(x,y,z));
							}
						}
					}
				}
			}
		}
		
		if(visit[4][4][4] == 1) {
			if(min == -1) min = lev;
			else min = Math.min(min, lev);
		}
	}
}
