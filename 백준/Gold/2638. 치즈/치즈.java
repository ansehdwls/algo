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

	static int N, M, K, T;

	static int map[][];
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static Queue<Point> cheese = new LinkedList<Point>();
	static Queue<Point> melt = new LinkedList<Point>();
	
	static int dx[] = { 0, 0, 1, -1};
	static int dy[] = { 1, -1, 0, 0};
	
	static int idx;
	static int idy;
	static boolean check[][];
	static Point p;
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese.add(new Point(i,j));
				}

			}
		}
		
		// 공기 조사
		bfs();
		int time = 0;
		
		int airWall = 0;
		
		while(!cheese.isEmpty()) {
			time++;
			
			//치즈 녹이기
			int cheeseSize = cheese.size();
			
			if(cheeseSize == 0) break;
			
			for(int i = 0 ; i < cheeseSize ; i++) {
				p = cheese.poll();
				airWall = 0;
				for(int j = 0 ; j < 4; j++) {
					idx = dx[j] + p.x;
					idy = dy[j] + p.y;
					if(idx >= 0 && idy >= 0 && idx < N && idy < M) {
						if(map[idx][idy] == 2) {
							airWall++;
						}
					}
				}
				
				if(airWall >= 2) {
					melt.add(p);
				}
				else
					cheese.add(p);
			}
			
			while(!melt.isEmpty()) {
				p = melt.poll();
				map[p.x][p.y] = 2;
			}
			
			//공기 확인
			bfs();
			
		}	
		System.out.println(time);
		
	}
	
	static void bfs() {
		q = new LinkedList<Point>();
		
		q.add(new Point(0,0));
		check = new boolean [N][M];
		
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			p = q.poll();
			
			map[p.x][p.y] = 2;
			
			for(int i = 0 ; i < 4; i++) {
				idx = dx[i] + p.x;
				idy = dy[i] + p.y;
				
				if(idx >= 0 && idy >= 0 && idx < N && idy < M) {
					if(!check[idx][idy] && map[idx][idy] != 1 ) {
						check[idx][idy] = true;
						q.add(new Point(idx,idy));
					}
				}
			}
			
		}
	}
}
