import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int N, K;
	static int mag[][];

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 복구할 자석
			int temp[][] = new int[4][8];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					temp[i][j] = mag[i][j];
				}
			}

			
			for(int i = 0 ; i < K; i++) {
				st= new StringTokenizer(br.readLine());
				rotateCmd(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));

			}
			int sum = 0;
			if (mag[0][0] == 1)
				sum += 1;
			if (mag[1][0] == 1)
				sum += 2;
			if (mag[2][0] == 1)
				sum += 4;
			if (mag[3][0] == 1)
				sum += 8;
			System.out.println("#" + t + " " + sum);

		}
	}

	static void rotateCmd(int n , int type) {
		
		// 왼쪽으로 4개
		if(n -1 >= 0 && mag[n-1][2] != mag[n][6]) {
			if(n-2 >= 0 && mag[n-2][2] != mag[n-1][6]) {
				if(n-3 >= 0 && mag[n-3][2] != mag[n-2][6]) {
					rotate(n-3,type * -1);
				}
				rotate(n-2,type);
			}
			rotate(n-1,type * -1);
		}
		// 오른쪽으로 4개
		if(n + 1 < 4 && mag[n+1][6] != mag[n][2]) {
			if(n + 2 < 4 && mag[n+2][6] != mag[n+1][2]) {
				if(n + 3 < 4 && mag[n+3][6] != mag[n+2][2]) {
					rotate(n+3,type * -1);
				}
				rotate(n+2,type);
			}
			rotate(n+1,type * -1);
		}
		
		rotate(n,type);

	}
	
	// type 0 : 반시계, type : 1 시계
	// n 은 자석 번호
	static void rotate(int n, int type) {
		if( type == 1) {
			int temp = mag[n][7];
			for(int i = 7 ; i>= 1; i--) {
				mag[n][i] = mag[n][i-1];
			}
			mag[n][0] = temp;
		}
		else {
			
			int temp = mag[n][0];
			for(int i = 0 ; i< 7; i++) {
				mag[n][i] = mag[n][i+1];
			}
			mag[n][7] = temp;
		}
	}
	
}