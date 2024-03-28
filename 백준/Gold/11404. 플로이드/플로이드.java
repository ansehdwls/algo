import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {


	static int city[][];
	static boolean check[][];
	static int N, M;

	// 연결 최단 경로
	static int matrix[][];
	
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	// p 배열
	static int p[];
	
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// City
		city = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				city[i][j] = 100000000;
			}
			city[i][i] = 0;
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int finish = Integer.parseInt(st.nextToken())-1;
			int dis = Integer.parseInt(st.nextToken());
			city[start][finish] = Math.min(city[start][finish], dis);
		}

		for(int k= 0 ; k < N; k++) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N; j++) {
					city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				if(city[i][j] >= 100000000 ) System.out.print("0 "); 
				else System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}