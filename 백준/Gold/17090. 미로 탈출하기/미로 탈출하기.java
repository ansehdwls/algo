import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int M;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
 	static StringTokenizer st;
	static int check[][];
	static int check2[][];
	static int maze[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		check = new int[N][M];
		check2 = new int[N][M];	
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < M; j++ ) {
				switch(s.charAt(j)) {
					case 'U': maze[i][j] = 0 ; break;
					case 'R': maze[i][j] = 1 ; break;
					case 'D': maze[i][j] = 2 ; break;
					case 'L': maze[i][j] = 3 ;
				}	
			}
		}
		
		int count = 0 ;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M; j++ ) {
				if(check2[i][j] == 0) {
					go(i,j);
				}
				if(check[i][j] == -1) count++;
			}
		}
		System.out.println(count);
		
	}
	static int go(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return -1;
		
		if(check[x][y] != 0) return check[x][y]; 
		
		if(check2[x][y] == 1) return 1;
		
		check2[x][y] = 1;
		check[x][y] = go(x +dx[maze[x][y]], y + dy[maze[x][y]]);
		
		return check[x][y];
	}

}
