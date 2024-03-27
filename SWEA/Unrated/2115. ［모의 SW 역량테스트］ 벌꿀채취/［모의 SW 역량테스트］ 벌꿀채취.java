import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Solution {
	static int N, M ,C;
	static int honey[][];
	static int max[][];
	static StringTokenizer st;
	static List<Point> l;
	static int sum = 0;
	static int temp =0;
	static int ans = 0;
	static boolean check[][];
	static Point worker[] = new Point[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			check = new boolean[N][N];
			honey = new int[N][N];
			max = new int [N][N-M+1];
			ans = 0 ;
			l = new ArrayList<Point>();
			for(int i = 0 ;i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
					// 체취가능한 벌통
					if(j + M <= N) l.add(new Point(i,j));
				}
			}
			for(int i = 0 ; i< N; i++) {
				for(int j = 0 ; j < N-M+1; j++) {
					sum = 0;
					temp =0;
					maxNum(0,i,j,i,j);
				}
			}

			go(0,0);
			System.out.println("#"+t+" "+ans);
			
		}
		

	}
	
	static void maxNum(int idx, int x, int y, int dx, int dy) {
		if(idx == M) {
			max[x][y] = Math.max(max[x][y], temp);
			return ;
		}
		else {
			maxNum(idx+1, x, y, dx, dy+1);
			if(sum + honey[dx][dy] <= C) {
				sum += honey[dx][dy];
				temp += honey[dx][dy]*honey[dx][dy];
				maxNum(idx+1, x, y, dx, dy+1);
				sum -= honey[dx][dy];
				temp -= honey[dx][dy]*honey[dx][dy];
			}
		}
	}
	
	static void go(int idx, int start) {
		if(idx == 2) {
			int a = 0;
			for(int i = 0; i < 2; i++) {
				a += max[worker[i].x][worker[i].y];
			}
			ans = Math.max(a, ans);
			return;
		}
		for(int i = start ; i < l.size(); i++) {
			Point p = l.get(i);
			if(!check[p.x][p.y]) {
				worker[idx] =p;
				for(int j = 0 ; j < M; j++) {
					check[p.x][p.y+j] = true;
				}
				go(idx+1,i+1);
				for(int j = 0 ; j < M; j++) {
					check[p.x][p.y+j] = false;
				}
			}
		}
	}

}
