import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int Dummy[][];
	static int time[];
	static int cmd[];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static LinkedList<Point> snake = new LinkedList<Point>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		Dummy = new int[N][N];
		for(int i = 0 ; i< K; i++) {
			st = new StringTokenizer(br.readLine());
			Dummy[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;

		}
		K = Integer.parseInt(br.readLine());
		snake.add(new Point(0,0));
		Dummy[0][0] = 2;
		time = new int [K];
		cmd = new int [K];
		for(int i = 0 ; i < K; i++ ) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			if(c == 'D') cmd[i] = 1;
			else cmd[i] = -1;
		}
		int t = 0;
		int idx = 0;
		int dir = 0;
		boolean isDone = false;
		while(!isDone) {
			if(idx < K && t == time[idx]) {
				dir += cmd[idx];
				if(dir < 0) dir = 3;
				else dir %= 4;
				idx++;
			}
			
			// 뱀은 1초에 한번 이동한다.
			// 머리가 안박으면 몸통도 박을일이 없음.
			Point p = snake.poll();
			if(p.x + dx[dir] >= 0 
					&& p.y + dy[dir] >= 0 
					&& p.x + dx[dir] < N 
					&& p.y + dy[dir] < N
					&& Dummy[p.x + dx[dir]][p.y + dy[dir]] != 2) {
				// 사과가 있다면 머리만 추가
				if(Dummy[p.x + dx[dir]][p.y + dy[dir]] == 1) {
					Dummy[p.x + dx[dir]][p.y + dy[dir]] = 2;
					// 머리 복구 후 추가
					snake.add(0, new Point(p.x,p.y));
					snake.add(0, new Point(p.x + dx[dir],p.y + dy[dir]));
				}
				else {
					Dummy[p.x + dx[dir]][p.y + dy[dir]] = 2;
					snake.add(0, new Point(p.x,p.y));
					snake.add(0, new Point(p.x + dx[dir],p.y + dy[dir]));
					// 꼬리 삭제
					p = snake.pollLast();
					Dummy[p.x][p.y] = 0;
				}
			}
			else {
				isDone = true;
			}
			t++;
			
//			for(int i = 0 ; i< N; i++) {
//				for(int j = 0 ; j< N; j++) {
//					System.out.print(Dummy[i][j] +" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(t);
	}

}