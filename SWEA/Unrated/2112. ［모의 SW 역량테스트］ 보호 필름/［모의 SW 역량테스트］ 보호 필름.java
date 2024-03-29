import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	static int D, W, K;
	static StringTokenizer st;
	static int film[][];
	static int size;
	static int min = 100000;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min = -1;
			film = new int[D][W];
			
			for(int i = 0 ; i < D ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j< W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 두깨만큼 약 투여 가능
			for(int i = 0; i< D; i++) {
				go(0,i,0);
				if(min != -1) break;
			}
			
			System.out.println("#"+t+" "+min);
		}
	}
	
	static void go(int idx, int f,int start) {
		// f 만큼 투여 하면 뽑기
		if(idx == f) {
			if(isGood()) min = f;
			return ;
		}
		else {
			// 복구용
			int temp[][] = new int [1][W];
			// 조합
			for(int i = start; i < D; i++) {
				for(int j = 0 ; j< W; j++) {
				 temp[0][j] = film[i][j];
				}
				change(i,0);
				go(idx+1,f,i+1);
				change(i,1);
				go(idx+1,f,i+1);
				for(int k = 0 ; k< W; k++) {
					film[i][k] = temp[0][k] ;
				}
				
			}
		}
	}
	
	// film 액체 투여
	static void change(int d, int type) {
		for(int i = 0; i < W; i++) {
			film[d][i] = type;
		}
	}
	
	static boolean isGood() {
		
		int start;
		int k;
		// 맨 위부터 시작
		for(int j = 0; j< W; j++) {
			start = film[0][j];
			k = 1;
			for(int i = 1; i < D; i++) {
				if(film[i][j] == start) k++;
				else {
					k = 1;
					start = film[i][j];
				}
				if(k == K) break;
			}
			if(k != K) return false;
		}
		
		return true;
	}
}
