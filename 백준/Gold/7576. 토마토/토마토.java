import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int tomato[][];
	static boolean visit[][];
	static int min = Integer.MAX_VALUE;
	static Queue<Point> q = new LinkedList<Point>();
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = { 1, -1, 0 , 0};
	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 토마토와 방문체크 배열 초기화
		tomato = new int [M][N];
		visit = new boolean [M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				// 익어있는 토마토를 넣어준다. ( 익기 시작할 점)
				if(tomato[i][j] == 1) q.add(new Point(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			
			// 현재 크기 저장
			int size = q.size();
			
			// 토마토 익기 시작
			for(int i = 0 ; i < size; i++) {
				Point p = q.poll();
				// 방문하지 않았다면 체크
				if(!visit[p.x][p.y]) {
					visit[p.x][p.y] = true;
					// 4방향 탐색 시작 만약 토마토가 있다면 -> 다음 익어야할 토마토! -> q에 넣어주자
					for(int dir = 0 ; dir < 4; dir++) {
						int x = p.x + dx[dir];
						int y = p.y + dy[dir];
						if(x >= 0 && x < M && y >= 0 && y < N) {
							if(tomato[x][y] == 0) {
								// 토마토 익음
								tomato[x][y] = 1;
								q.add(new Point(x,y));
							}
						}
						
					}
				}
			}
			
			// 하루 지남
			day++;
			
		}
		
		// 다 익었는지 판단할 flag
		boolean isAllGood = true;
	
		for(int i = 0; i < M; i++) {
			for(int j = 0 ; j < N; j++) {
				// 익지 않은 토마토가 있다면 나가자
				if(tomato[i][j] == 0) {
					isAllGood = false;
					break;
				}
			}
			if(!isAllGood) break;
		}
		
		if(isAllGood) System.out.println(day-1);
		else System.out.println(-1);
	}


}
