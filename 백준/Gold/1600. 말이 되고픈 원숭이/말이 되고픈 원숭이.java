
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


class KNIGHT implements Comparable<KNIGHT>{
	int x;
	int y;
	int c;
	int k;
	public KNIGHT(int x, int y, int k, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.k = k;
	}
	@Override
	public int compareTo(KNIGHT o) {
		return this.c - o.c;
	}
	
	
}

public class Main {

	static int N, M, K;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int map[][];
	static boolean visit[][][];

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static int dnx[] = {-1, 1, 2, 2, -2, -2, -1, 1};
	static int dny[] = {-2, -2, -1, 1, -1, 1, 2, 2};
	
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			K = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M][K+1];
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();
			if(N == 1 && M == 1) {
				if(map[0][0] == 0) System.out.println(count);
				else System.out.println(-1);
			}
			else {
				if(count == 0 )	System.out.println(-1);
				else System.out.println(count);	
			}
			
		}
		static void bfs() {
			
			PriorityQueue<KNIGHT> pq = new PriorityQueue<KNIGHT>();
			
			pq.add(new KNIGHT(0,0,0,0 ));
			
			visit[0][0][0] = true;
			
			while(!pq.isEmpty()) {
				KNIGHT temp = pq.poll();
				
				if(temp.x == N-1 && temp.y == M-1) {
					count = temp.c;
					break;
				}
				
				
				
				for(int i = 0 ; i < 4; i ++) {
					
					int idx = dx[i] + temp.x;
					int idy = dy[i] + temp.y;
					
					if(idx >= 0 && idy >= 0 && idx < N && idy < M) {

						if(!visit[idx][idy][temp.k] && map[idx][idy] != 1) {
							visit[idx][idy][temp.k] = true;
							pq.add(new KNIGHT(idx,idy,temp.k,temp.c+1));
						}
					}
									
				}

				
				if(temp.k < K) {
					for(int i = 0 ; i < 8; i ++) {
						
						int idx = dnx[i] + temp.x;
						int idy = dny[i] + temp.y;
						
						if(idx >= 0 && idy >= 0 && idx < N && idy < M) {
							if(!visit[idx][idy][temp.k+1] && map[idx][idy] != 1) {
								visit[idx][idy][temp.k+1] = true;
								pq.add(new KNIGHT(idx,idy,temp.k+1,temp.c+1));
							}
						}
										
					}	
				}
				
			}
		}
	

}
