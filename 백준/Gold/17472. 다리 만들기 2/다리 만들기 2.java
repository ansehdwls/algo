import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Island implements Comparable<Island>{
	int start;
	int finsh;
	int dis;
	public Island(int start, int finish, int dis) {
		this.start = start;
		this.finsh = finish;
		this.dis = dis;
	}
	@Override
	public int compareTo(Island o) {
		// TODO Auto-generated method stub
		return this.dis - o.dis;
	}
}

public class Main {

	static Set<Integer> set;
	static Deque<Point> q = new LinkedList<Point>();
	static Deque<Point> dq = new LinkedList<Point>();
	static List<Island> l = new ArrayList<Island>();
	static int world[][];
	static boolean check[][];
	static int N, M;

	// 연결 최단 경로
	static int matrix[][];
	
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	// p 배열
	static int p[];
	
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		world = new int[N][M];
		check = new boolean[N][M];
		for(int i = 0 ; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< M; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
				// 땅인 부분 미리 넣어두자
				if(world[i][j] == 1) q.add(new Point(i,j));
			}
		}
		
		// 섬의 이름
		int island_id = 0;
		
		// 하나씩 꺼내면서 섬 구분.
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(!check[p.x][p.y]) {
				island_id++;
				// BFS
				dq.add(p);
				
				while(!dq.isEmpty()) {
					p = dq.poll();
					if(!check[p.x][p.y]) {
						check[p.x][p.y] = true;
						world[p.x][p.y] = island_id;
						
						for(int i = 0 ; i< 4; i++) {
							int x = p.x + dx[i];
							int y = p.y + dy[i];
							
							if(x >=0 && y >=0 && x < N && y < M && world[x][y] > 0 && !check[x][y]) dq.add(new Point(x,y));
						}
					}
					
				}
			}
		}
		
		matrix = new int[island_id+1][island_id+1];
		// 초기화
		for(int i = 1 ; i <= island_id ; i++) {
			for(int j = 1 ; j <= island_id; j++) {
				matrix[i][j] = 10000;
			}
		}
		
		// 섬확인
//		System.out.println();
//		for(int i = 0 ; i< N ; i++) {
//			
//			for(int j = 0 ; j< M; j++) {
//				System.out.print(world[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		int idy = 0;
		int idx = 0;
		int start = 0;
		int len = 0;
		boolean isPos = false;
		
		// 섬끼리의 연결 경로 그려보자
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ; j< M; j++) {
				// 가로 확인
				if(world[i][j] > 0) {
					// 시작
					start = world[i][j];
					idy = j+1;
					len = 0;
					isPos = false;
					
					while(idy < M) {
						if(world[i][idy] == start) {
							break;
						}
						else if(world[i][idy] > 0){
							if(len > 1 ) {
								isPos = true;
							}
							break;
						}
						len++;
						idy++;
					}

					if(isPos) {
						matrix[start][world[i][idy]] = Math.min ( matrix[start][world[i][idy]],len);
						matrix[world[i][idy]][start] = matrix[start][world[i][idy]];
					}
					j = idy-1;
				}
			}
		}
		
		for(int i = 0 ; i< M; i++) {
			for(int j = 0 ; j< N; j++) {
			
				// 세로 확인
				if(world[j][i] > 0) {
					// 시작
					start = world[j][i];
					idx = j+1;
					len = 0;
					isPos = false;
					
					while(idx < N) {
						if(world[idx][i] == start) {
							break;
						}
						else if(world[idx][i] > 0){
							if(len > 1 ) {
								isPos = true;
							}
							break;
						}
						len++;
						idx++;
					}
					if(isPos) {
						matrix[start][world[idx][i]] = Math.min ( matrix[start][world[idx][i]],len);
						matrix[world[idx][i]][start] = matrix[start][world[idx][i]];
					}
					j = idx-1;
				}
			}
		}
		
		// 연결 경로 확인
//		System.out.println();
//		for(int i = 1 ; i <= island_id ; i++) {
//			for(int j = 1 ; j <= island_id; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		p = new int [island_id+1];
		// 처음 상태는 모두 떨어져 있음.
		for(int i = 1 ; i <= island_id; i++  ) p[i] = i;
		
		// 만약 하나도 연결 안되는 섬이 있다면 불가능
		for(int i = 1 ; i <= island_id ; i++) {
			for(int j = i ; j <= island_id; j++) {
				if(matrix[i][j] != 10000) {
					union(i,j);
				}
			}
		}
		
		int a = find(1);
		isPos = true;
		for(int i =2 ;i <= island_id; i++) {
			if(a != find(i)) {
				isPos = false;
				break;
			}
		}
		
		
		if(!isPos) System.out.println("-1");
		else {
			// 잇는게 가능하다면 
			// 모든 섬을 잇는 최단 경로 구하기
			
			for(int i = 1 ; i <= island_id ; i++) {
				for(int j = i ; j <= island_id; j++) {
					if(matrix[i][j] != 10000) {
						l.add(new Island(i,j,matrix[i][j]));
					}
				}
			}
			// 짧은 거리 순으로 정렬
			Collections.sort(l);
			
			// 크루스칼
			p = new int [island_id+1];
			// 처음 상태는 모두 떨어져 있음.
			for(int i = 1 ; i <= island_id; i++  ) p[i] = i;
			
			idx = 0;
			idy = 0;
			
			while(idy < island_id-1) {
				Island land = l.get(idx);
				if(find(land.start) != find(land.finsh)) {
					union(land.start, land.finsh);
					sum += land.dis;
					idy++;
				}
				idx++;
			}
			System.out.println(sum);
		}
		
	}
	static void union(int x, int y) {
		p[find(y)] = find(x);
	}
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}
}