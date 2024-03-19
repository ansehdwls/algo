import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Oper{
	int x;
	int y;
	int siz;
	Oper(int x, int y, int siz){
		this.x = x;
		this.y = y;
		this.siz = siz;
	}
}

public class Main {
	static int N, M, K;
	static int map[][];
	static Oper op[];
	static int res = Integer.MAX_VALUE;
	static boolean check[];
	static List<Integer> l = new ArrayList<Integer>();
	static List<Integer> ans = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new boolean [K];
		for(int i = 0 ;i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		op = new Oper[K];
		for(int i = 0 ; i < K;i++) {
			st = new StringTokenizer(br.readLine());
			op[i] = new Oper(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		}
		
		go(0);
		System.out.println(res);
		br.close();
	}
	
	static void go(int idx) {
		if(idx == K) {
			// 최소값 구하기
			for(int j = 0 ; j < N; j++) {
				int sum = 0;
				for(int k = 0 ; k < M; k++) {
					sum += map[j][k];
				}
				res = Math.min(sum, res);
			}
			return ;
		}
		else {
			// 이전 배열 저장
			int temp[][] = new int[N][M];
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			
			for(int i = 0 ; i< K; i++) {
				// 사용하지 않은 연산에 대해 수행
				if(!check[i]) {
					check[i] = true;
					
					rotate(op[i]);
					go(idx+1);
					
					// 원상복구
					for(int j = 0 ; j < N; j++) {
						for(int k = 0 ; k < M; k++) {
							map[j][k] = temp[j][k];
						}
					}
					
					check[i] = false;
				}

			}
		}
	}
	static void rotate(Oper p) {
		
		
		for(int s  = 1 ; s <= p.siz; s++) {
			// 대각선 위에서 시작
			// 시작점 
			int x = p.x-s;
			int y = p.y-s;
			
			// 크기마다 움직여야하는 것 2씩 증가
			int move = 2 * s;
			
			// 시작 초기값 저장
			int temp = map[x][y];
			
			// 위로 옮김
			for(int i = 0 ; i < move; i++) {
				map[x][y] = map[x+1][y];
				x += 1; 
			}
			// 좌로 옮김
			for(int i = 0 ; i < move; i++) {
				map[x][y] = map[x][y+1];
				y += 1; 
			}
			// 아래로 옮김
			for(int i = 0 ; i < move; i++) {
				map[x][y] = map[x-1][y];
				x -= 1; 
			}
			//우로 옮김
			for(int i = 0 ; i < move-1; i++) {
				map[x][y] = map[x][y-1];
				y -= 1; 
			}
			// 마지막 이동은 시작점
			map[x][y] = temp;
		}
	}
}
