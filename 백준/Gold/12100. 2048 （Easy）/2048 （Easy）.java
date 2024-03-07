import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int board[][];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(board[i][j], max);
			}
		}

		go(0);
		System.out.println(max);

	}

	static void go(int idx) {
		// 5번 움직였으면 max값 찾아보자.
		if (idx == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(board[i][j], max);
				}
			}
			return;
		} else {
			int temp[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = board[i][j];
				}
			}

			// 4방향을 돌면서 max를 찾자.
			for (int k = 0; k < 4; k++) {
				move(k); // 움직임
//				System.out.println(k +" 움직임 ");
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(board[i][j] + " ") ;
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				// 다음 움직임으로
				go(idx + 1);
				
				// 다시 원상 복귀
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						board[i][j] = temp[i][j];
					}
				}
//				System.out.println(k  + " 움직인 후 복귀 ");
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(board[i][j] + " ") ;
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		}
	}

	static void move(int k) {
		List<Integer> l = new ArrayList<Integer>();
		// 업 위로 합치기
		if (k == 0) {
			// 열 별로 수행
			for (int j = 0; j < N; j++) {
				
				// 0 제외하고 다 넣자
				for (int i = 0; i < N; i++) {
					if (board[i][j] != 0)
						l.add(board[i][j]);
				}
				int idx = 0;
				// ㅣ의 배열 같은 값 합치기
				for (int i = 0; i < l.size(); i++) {
					
					if(i == l.size()-1) board[idx++][j] = l.get(i);
					// 뒤에랑 같으면 합친값 넣고 한칸 뛰기
					else if (l.get(i).equals(l.get(i + 1))) {
						board[idx++][j] = l.get(i) * 2;
						i++;
					}
					// 다르면 본인 값 집어넣기
					else {
						board[idx++][j] = l.get(i);
					}
				}
				// 나머지 값 0으로 맞춰주기.
				for (int i = idx; i < N; i++) {
					board[i][j] = 0;
				}
				// 리스트 전체 제거
				l.removeAll(l);
			}
		}
		// 아래
		else if (k == 1) {
			// 열 별로 수행
			for (int j = 0; j < N; j++) {
				// 0 제외하고 다 넣자
				for (int i = N - 1; i >= 0; i--) {
					if (board[i][j] != 0)
						l.add(board[i][j]);
				}
				int idx = N - 1;
				// ㅣ의 배열 같은 값 합치기
				for (int i = 0; i < l.size(); i++) {
					// 뒤에랑 같으면 합친값 넣고 한칸 뛰기
					if(i == l.size()-1) board[idx--][j] = l.get(i);
					else if (l.get(i).equals(l.get(i + 1))) {
						board[idx--][j] = l.get(i) * 2;
						i++;
					}
					// 다르면 본인 값 집어넣기
					else {
						board[idx--][j] = l.get(i);
					}
				}
				// 나머지 값 0으로 맞춰주기.
				for (int i = idx; i >= 0; i--) {
					board[i][j] = 0;
				}
				// 리스트 전체 제거
				l.removeAll(l);
			}
		}
		// 오른쪽
		else if (k == 2) {
			// 행 별로 수행
			for (int j = 0; j < N; j++) {
				// 0 제외하고 다 넣자
				for (int i = N - 1; i >= 0; i--) {
					if (board[j][i] != 0)
						l.add(board[j][i]);
				}
				int idx = N - 1;
				// ㅣ의 배열 같은 값 합치기
				for (int i = 0; i < l.size(); i++) {
					if(i == l.size()-1) board[j][idx--] = l.get(i);
					// 뒤에랑 같으면 합친값 넣고 한칸 뛰기
					else if (l.get(i).equals(l.get(i + 1))) {
						board[j][idx--] = l.get(i) * 2;
						i++;
					}
					// 다르면 본인 값 집어넣기
					else {
						board[j][idx--] = l.get(i);
					}
				}
				// 나머지 값 0으로 맞춰주기.
				for (int i = idx; i >= 0; i--) {
					board[j][i] = 0;
				}
				// 리스트 전체 제거
				l.removeAll(l);
			}
		}
		// 횐쪽
		else {
			// 열 별로 수행
			for (int j = 0; j < N; j++) {
				// 0 제외하고 다 넣자
				for (int i = 0; i < N; i++) {
					if (board[j][i] != 0)
						l.add(board[j][i]);
				}
				int idx = 0;
				// ㅣ의 배열 같은 값 합치기
				for (int i = 0; i < l.size(); i++) {
					if(i == l.size()-1) board[j][idx++] = l.get(i);
					// 뒤에랑 같으면 합친값 넣고 한칸 뛰기
					else if (l.get(i).equals(l.get(i + 1))) {
						board[j][idx++] = l.get(i) * 2;
						i++;
					}
					// 다르면 본인 값 집어넣기
					else {
						board[j][idx++] = l.get(i);
					}
				}
				// 나머지 값 0으로 맞춰주기.
				for (int i = idx; i < N; i++) {
					board[j][i] = 0;
				}
				// 리스트 전체 제거
				l.removeAll(l);
			}
		}
	}

}
