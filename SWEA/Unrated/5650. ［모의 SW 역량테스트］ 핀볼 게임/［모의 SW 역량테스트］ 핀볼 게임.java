import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static StringTokenizer st;
	static int pin_map[][];
	
	static List<Point> wam[];
	static List<Point> ball;
	static int max = 0;
	
	
	// 벽의 dir 상 우 하 좌
	static int box[][] = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

	// 공의 방향
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			pin_map = new int[N][N];
			max = 0;
			
			// 6~10은 웜홀
			wam = new ArrayList[5];
			for(int i = 0; i< 5; i++) {
				wam[i] = new ArrayList<Point>();
			}
			
			// 공을 놓을때 최대 위치
			ball = new ArrayList<Point>();

			
			// map을 받는다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					pin_map[i][j] = sc.nextInt();
					// 6부터는 웜홀 저장
					if(pin_map[i][j] >= 6 ) wam[pin_map[i][j]-6].add(new Point(i,j));
					if(pin_map[i][j] == 0) ball.add(new Point(i,j));
				}
			}

//			// 방향 별 공의 위치를 뽑자
//			for(int i = 0; i < 4; i++) {
//				chooseBall(i);
//			}
			
			for(int j = 0 ; j< ball.size(); j++) {
				for(int i = 0 ; i< 4; i++) {
					go(i,ball.get(j));
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

	static void go(int dir, Point finish ) {
		int sum = 0;
		int x = finish.x;
		int y = finish.y;
		while(true) {
			
			
			// fin볼 바로 이동
			x += dx[dir];
			y += dy[dir];
			// 가장 자리 면 되돌아감 점수 * 2
			if(x < 0 || y < 0 || x >= N || y >= N) {
				sum++;
				max = Math.max(max, sum*2 -1);
				break;
			}
			// 처음 자리 break
			if(x == finish.x && y == finish.y) {
				max = Math.max(max, sum);
				break;
			}
			
			// 벽이 아니라면 전진
			if(pin_map[x][y] == 0) {
				continue;
			}
			
			// 웜홀이라면 
			if(pin_map[x][y] >= 6) {
				for(int i = 0; i< 2; i++) {
					int idx = wam[pin_map[x][y]-6].get(i).x;
					int idy = wam[pin_map[x][y]-6].get(i).y;
					if(idx != x || idy != y) {
						x = idx;
						y = idy;
						break;
					}
				}
			}
			if(pin_map[x][y] >= 6) continue;
			
			// 벽이라면 해당 방향 이동 , 점수 + 1
			if(pin_map[x][y] > 0) {
				sum++;
				int d = pin_map[x][y]-1;
				// 반대 벽이면 되돌아감 점수 *2
				if(box[pin_map[x][y]-1][dir] == 1) {
					max = Math.max(max, sum*2 -1);
					break;
				}
				// 0이면 다른 방향을 변경
				else {
					 dir = changeDir(pin_map[x][y],dir);
				}
				continue;
			}
			
			// 블랙홀이면 break
			if(pin_map[x][y] == -1) {
				max = Math.max(max, sum);
				break;
			}

		}
		
		
	}
	
	static int changeDir(int i, int d) {
		switch(i) {
			// 1번 하 -> 우 , 좌 -> 상
			case 1: return (d == 2) ? 1: 0;
			// 2번 상 -> 우 , 좌 -> 하
			case 2: return (d == 0) ? 1: 2;
			// 3번 상 -> 좌 , 좌 -> 하
			case 3: return (d == 0) ? 3: 2;
			// 4번 하 -> 좌 , 우 -> 상
			case 4: return (d == 2) ? 3: 0;
		}
		return 0;
	}
	
//	static void chooseBall(int dir) {
//		int x = 0;
//		int y = 0;
//		boolean isGood = false;
//		for(int i = 0; i< N; i++) {
//			
//			x = 0;
//			isGood = true;
//			// 상
//			if(dir == 0) {
//				while(x < N) {
//					if(pin_map[x][i] == 0 && isGood) {
//						ball[dir].add(new Point(x,i));
//						isGood = false;
//					}
//					// 장애물을 만나면 다시 최고 위치라고 생각
//					else if(pin_map[x][i] != 0) {
//						isGood = true;
//					}
//					x++;
//				}
//				continue;
//			}
//			// 우
//			if(dir == 2) {
//				while(x < N) {
//					if(pin_map[i][x] == 0 && isGood) {
//						ball[dir].add(new Point(x,i));
//						isGood = false;
//					}
//					// 장애물을 만나면 다시 최고 위치라고 생각
//					else if(pin_map[i][x] != 0) {
//						isGood = true;
//					}
//					x++;
//				}
//				continue;
//			}
//			
//			x = N-1;
//			// 하
//			if(dir == 1) {
//				while(x >= 0) {
//					if(pin_map[x][i] == 0 && isGood) {
//						ball[dir].add(new Point(x,i));
//						isGood = false;
//					}
//					// 장애물을 만나면 다시 최고 위치라고 생각
//					else if(pin_map[x][i] != 0) {
//						isGood = true;
//					}
//					x--;
//				}
//				continue;
//			}
//			// 좌
//			if(dir == 3) {
//				while(x >= 0) {
//					if(pin_map[i][x] == 0 && isGood) {
//						ball[dir].add(new Point(x,i));
//						isGood = false;
//					}
//					// 장애물을 만나면 다시 최고 위치라고 생각
//					else if(pin_map[i][x] != 0) {
//						isGood = true;
//					}
//					x--;
//				}
//				continue;
//			}
//			
//		}
//	}
	
}
