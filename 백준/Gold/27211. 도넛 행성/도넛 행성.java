import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	
	static int dx[] = {0, 0 ,1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int visit[][];
	static StringTokenizer st;
	static Queue<Point> q = new LinkedList<Point>();
	static int count = 0;
	static Queue<Point> l = new LinkedList<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new int [N][M];
		
		for(int i = 0  ;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< M; j++) {
				visit[i][j] = Integer.parseInt(st.nextToken());
				if(visit[i][j] == 0) l.add(new Point(i,j));
			}
		}
		if(!l.isEmpty()) q.add(l.poll());
		
		// 하나 찾았으면 스타트
		while(!q.isEmpty()) {
			count++;
			// bfs
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(visit[p.x][p.y] == 0) {
					visit[p.x][p.y] = 1;
					
					for(int i = 0 ; i < 4; i++) {
						int idx = p.x + dx[i];
						int idy = p.y + dy[i];
						if(idx < 0 ) idx = N-1;
						if(idy < 0) idy = M-1;
						if(idx >= N) idx = 0;
						if(idy >= M) idy = 0;
						
						if(visit[idx][idy] == 0) q.add(new Point(idx, idy));
					}
					
				}
			}
			
			while(!l.isEmpty()) {
				Point p = l.poll();
				if(visit[p.x][p.y] == 0) {
					q.add(p);
					break;
				}
			}
			
		}
		
		System.out.println(count);
	}
}
