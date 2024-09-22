
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static StringTokenizer st;
	static String s;
	static Point red;
	static Point blue;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int box[][];
	
	static int visit[][][][];
	
	static int min = 11;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		visit = new int[11][11][11][11];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '#') {
					box[i][j] = 0;
				} else if (s.charAt(j) == '.')
					box[i][j] = 1;
				else if (s.charAt(j) == 'R') {
					box[i][j] = 1;
					red = new Point(i, j);
				} else if (s.charAt(j) == 'B') {
					box[i][j] = 1;
					blue = new Point(i, j);
				} else if (s.charAt(j) == 'O') {
					box[i][j] = 2;
				}
			}
		}
		// 처음상태는 저장.
		visit[red.x][red.y][blue.x][blue.y] = 1;
		
		bfs();
		
		if(min == 11) System.out.println(-1);
		else System.out.println(min);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {red.x,red.y,blue.x,blue.y, 1});
		
		while(!q.isEmpty()) {
			int p[] = q.poll();
			
			// 10 넘어가면 더 할필요 x
			if(p[4] == 11) {
				return ;
			}
			
			// 4방향 싹 이동
			for(int i = 0 ; i < 4; i++) {
				
				int idxR = p[0];
				int idyR = p[1];
				int idxB = p[2];
				int idyB = p[3];
				
				// 파란 구슬 이동
				while(box[idxB][idyB] == 1) {	
					idxB += dx[i];
					idyB += dy[i];
					
					// 벽이라면 벽 이전까지 이동해야함. or 구멍이 아니면서 빨간 구슬이면 안됨.
					if(box[idxB][idyB] == 0 || (box[idxB][idyB] != 2 && (idxR == idxB && idyR == idyB)) ) {
						idxB -= dx[i];
						idyB -= dy[i];
						break;
					}
				}
				
				// 파란구슬이 구멍에 빠지면  아웃
				if(box[idxB][idyB] == 2 ) continue ;
				
				// 빨간 구슬 이동
				while(box[idxR][idyR] == 1) {	
					idxR += dx[i];
					idyR += dy[i];
					// 벽이라면 벽 이전까지 이동해야함. or 구멍이 아니면서 파란구슬이라면 
					if(box[idxR][idyR] == 0 || (box[idxR][idyR] != 2 && (idxR == idxB && idyR == idyB)) ) {
						idxR -= dx[i];
						idyR -= dy[i];
						break;
					}
				}
				
				// 파란 구슬 이동
				while(box[idxB][idyB] == 1) {	
					idxB += dx[i];
					idyB += dy[i];
					
					// 벽이라면 벽 이전까지 이동해야함. or 구멍이 아니면서 빨간 구슬이면 안됨.
					if(box[idxB][idyB] == 0 || (box[idxB][idyB] != 2 && (idxR == idxB && idyR == idyB)) ) {
						idxB -= dx[i];
						idyB -= dy[i];
						break;
					}
				}
				
				// 파란구슬이 구멍에 빠지면  아웃
				if(box[idxB][idyB] == 2 ) continue ;
				
				// 빨간 구슬 이동
				while(box[idxR][idyR] == 1) {	
					idxR += dx[i];
					idyR += dy[i];
					// 벽이라면 벽 이전까지 이동해야함. or 구멍이 아니면서 파란구슬이라면 
					if(box[idxR][idyR] == 0 || (box[idxR][idyR] != 2 && (idxR == idxB && idyR == idyB)) ) {
						idxR -= dx[i];
						idyR -= dy[i];
						break;
					}
				}
				// 빨간 구슬이 빠지면 굳
				if(box[idxR][idyR] == 2 ) {
					min = visit[p[0]][p[1]][p[2]][p[3]];
					return ;
				}
				
				
				if(visit[idxR][idyR][idxB][idyB] == 0) {
					visit[idxR][idyR][idxB][idyB] = visit[p[0]][p[1]][p[2]][p[3]] + 1;
					q.add(new int [] {idxR,idyR,idxB,idyB,visit[idxR][idyR][idxB][idyB]});
				}
			}
		}
		
	}

}
