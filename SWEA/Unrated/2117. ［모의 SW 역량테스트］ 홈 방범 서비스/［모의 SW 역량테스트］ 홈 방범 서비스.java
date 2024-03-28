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
	static int N, M;
	static int service[][];
	static int cost[];
	static StringTokenizer st;
	static Point house[];
	static Deque<Point> dq;
	static int size;
	static int max = 0;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		cost = new int[22];
		for(int i =1; i< 22; i++) {
			cost[i] = i*i + (i-1)*(i-1);
		}
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//init
			service = new int [N][N];
			dq = new LinkedList<Point>();
			max = 1;
			sum = 0;
			
			
			for(int i =0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j< N; j++) {
					service[i][j] = Integer.parseInt(st.nextToken());
					if(service[i][j] == 1) dq.add(new Point(i,j));
				}
			}
			
			// 집의 개수
			size = dq.size();
			house = new Point[size];
			int idx = 0;
			
			// 집의 위치 배열
			while(!dq.isEmpty()) {
				house[idx] = dq.poll();
				idx++;
			}
			
			int dis = 0;
			// 모든 i,j에 대해 검색
			for(int i =0; i < N ; i++) {
				for(int j = 0 ; j< N; j++) { 
					if(service[i][j] == 1) dis = 1;
					else dis = 0;
					for(int k = 2; k < 22 ; k++) {
						max = Math.max(max, distance(k,i,j));
					}
					
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}
		

	}
	static int distance(int k, int x,int y) {
		int sum =0;
		for(int i = 0 ; i < size; i++) {
			if(Math.abs(x - house[i].x) + Math.abs(y - house[i].y) < k) sum++;
		}
		if(sum*M - cost[k] >= 0) return sum;
		return -1;
	}

}
