
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

	static int N;
	static int M;
	
	static int[][] board;
	static boolean[][] check;
	static StringTokenizer st;

	static int dx[] = {0, 0 ,-1, 1};
	static int dy[] = {1, -1, 0, 0};
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board= new int [N][M];
		check = new boolean [N][M];
		for(int i = 0 ; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0 ; i< N; i++) {
			for(int j = 0 ; j< M; j++) {
				check[i][j] = true;
				go(i,j,0,board[i][j],5);
				check[i][j] = false;
			}
		}
		
		int sc[] = new int[4];
		int base = 0;
		// 오 왼 상 하
		for(int i = 0 ; i< N; i++) {
			for(int j = 0 ; j< M; j++) {
				base = board[i][j];
				for(int k = 0 ; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >=0 && ny >=0 && nx < N && ny < M) {
						sc[k] = board[nx][ny];
					}
					else sc[k] = 0;
				}
				Arrays.sort(sc);
				for(int k = 1; k < 4; k++) {
					base += sc[k];
				}
				if(max < base) max = base;
			}
		}
		
		System.out.println(max);
	}
	
	static void go(int x, int y,int idx, int score, int dir) {
		if(idx == 3) {
			max = Math.max(max, score);
			return ;
		}
		
		for(int i = 0 ; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && ny >=0 && nx < N && ny < M) {
				if(!check[nx][ny]) {
					check[nx][ny] = true;
					score += board[nx][ny];
					go(nx, ny, idx+1, score,i);
					score -= board[nx][ny];	
					check[nx][ny] = false;
				}
			}
		}
	}
}
