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
	
	static char[][] board;
	static char[][] black;
	static char[][] white;
	
	static StringTokenizer st;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		black = new char[8][8];
		white = new char[8][8];
		int count = 1;
		for(int i = 0; i < 8; i++) {
			if(i %2 == 0) count = 1;
			else count = 2;
			for(int j = 0 ; j < 8; j++) {
				if(count % 2 == 1) {
					black[i][j] = 'B';
					white[i][j] = 'W';
				}
				else {
					black[i][j] = 'W';
					white[i][j] = 'B';
				}
				count++;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char [N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		// 8 * 8로 자른다
		for(int i = 0 ; i <= N - 8; i++) {
			for(int j = 0 ; j <= M - 8; j++) {
				min = Math.min(min,go(i,j));
 			}
		}
		System.out.println(min);
	}
	
	static int go(int x, int y) {
		int countB = 0;
		int countW = 0;
		
		for(int i = x ; i < x+8; i++ ) {
			for(int j = y; j < y+8; j++) {
				if(black[i-x][j-y] != board[i][j]) countB++;
				if(white[i-x][j-y] != board[i][j]) countW++;
			}
		}
		
		return Math.min(countB, countW);
	}
}
