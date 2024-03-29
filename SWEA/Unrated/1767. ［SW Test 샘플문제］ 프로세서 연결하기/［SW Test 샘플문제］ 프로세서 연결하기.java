import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
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
	static int N,M;
	static StringTokenizer st;
	static int cell[][];
	static List<Point> l = new ArrayList<Point>();
	static int num = 0;
	static int min = 100000;
	static int sum = 0;
	static int dx[] = {-1,1, 0, 0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			cell = new int[N][N];
			l = new ArrayList<Point>();
			
			for(int i =0 ; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					// 끝에 있으면 전선 필요없음.
					if(cell[i][j] == 1 && !(i == 0 || j ==0 || i == N-1 || j == N-1)) 
						l.add(new Point(i,j));
				}
			}
			min = 100000;
			num = l.size();
			for(int i = num; i >= 1 ;i--) {
				go(0,i,0);
				if(min != 100000) break;
			}
			System.out.println("#"+t+" "+min);
		}
	}

	// 조합 + 방향
	static void go(int idx, int f, int start) {
		if(idx == f) {

			min = Math.min(min, sum);
			return;
		}
		
		else {
			
			if( f-idx <= num-start) {
				int temp[][] = new int [N][N];
				for(int i = 0; i< N; i++) {
					for(int j = 0 ; j< N; j++) {
						temp[i][j] = cell[i][j];
					}
				}
				for(int i = start ; i < num; i++) {
					Point p = l.get(i);
					for(int j = 0; j< 4; j++) {
						int n = makeline(j,p.x,p.y);
						if(n != -1) {
							sum += n;
							go(idx+1,f,i+1);
							sum -= n;
						}
						for(int k = 0; k< N; k++) {
							for(int l = 0 ; l< N; l++) {
								cell[k][l] = temp[k][l];
							}
						}
						
					}
				}
			}
			
		}
	}
	
	static int makeline(int dir,int i, int j) {
		
		int sum = 0;
		boolean isImpos = false;
		i += dx[dir];
		j += dy[dir];
		while(i >= 0 && j>=0 && i < N && j < N) {
			
			// 전선 or 프로세서가 있다면 불가능
			if(cell[i][j] == 1) {
				isImpos = true;
				break;
			}
			// 전선 잇기
			cell[i][j] = 1;
			sum++;
			i += dx[dir];
			j += dy[dir];
		}
		
		
		if(isImpos) return -1;
		else return sum;
	}

}
