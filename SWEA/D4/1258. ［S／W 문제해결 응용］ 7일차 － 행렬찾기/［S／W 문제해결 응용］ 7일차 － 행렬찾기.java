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

class Flask implements Comparable<Flask>{
	int row;
	int col;
	int size;
	public Flask(int row, int col, int size) {
		this.row = row;
		this.col = col;
		this.size = size;
	}
	@Override
	public int compareTo(Flask o) {
		if(this.size == o.size) return this.row - o.row;
		return this.size - o.size;
	}
}
public class Solution {
	static int N;
	static int num[][];
	static boolean check[][];
	static StringTokenizer st;
	static List<Flask> l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int [N][N];
			check = new boolean[N][N];
			l = new ArrayList<Flask>();
			for(int i = 0 ; i< N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
					if(num[i][j] == 0 ) check[i][j] = true;
				}
			}
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!check[i][j]) {
						checkBox(i,j);
					}
				}
			}
			
			Collections.sort(l);
			System.out.print("#"+t+" "+l.size()+" ");
			for(int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i).row + " "+l.get(i).col+" ");
			}
			System.out.println();
		}
		

	}
	static void checkBox(int x, int y) {
		int row = 0;
		int col = 0;
		int size = 0;
		for(int i=x; i< N; i++) {
			if(!check[i][y]) {
				check[i][y] = true;
				row++;
			}
			else break;
		}
		check[x][y] = false;
		for(int i=y; i< N; i++) {
			if(!check[x][i]) {
				check[x][i] = true;
				col++;
			}
			else break;
		}
		
		// 나머지 부분도 체크
		for(int i = x+1; i < x+row; i++) {
			for(int j = y+1 ; j< y+col; j++) {
				if(!check[i][j]) {
					check[i][j] = true;
				}
			}
		}
		
		l.add(new Flask(row,col,row*col));
		
	}
}
