import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Swim{
	int x;
	int y;
	int wait;
	public Swim(int x, int y, int wait) {
		this.x = x;
		this.y = y;
		this.wait = wait;
	}
}
public class Solution {
	static int N;
	static int pool[][];
	static int vortex_t;
	static int lev;
	static boolean check[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static Queue<Swim> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			pool = new int[N][N];
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N ; j++) {
					pool[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// lev 값 소용돌이 주기, check 배열, q init
			lev = 0;
			vortex_t = 2;
			check = new boolean[N][N];
			q = new LinkedList<Swim>();
			
			// 시작점 q 에 넣기
			st = new StringTokenizer(br.readLine());
			q.add(new Swim(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0));
			// 도착 점
			st = new StringTokenizer(br.readLine());
			Swim finish = new Swim(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			
			// 더 이상 갈곳이 없거나 도착점에 도달했거나
			while(!q.isEmpty() && !check[finish.x][finish.y]) {
				int size = q.size();
				for(int i = 0; i < size; i++) {
					Swim s = q.poll();
					// 만약 wait 이 0 이상이라면 그만큼 기다려야함.
					if(s.wait > 0) {
						q.add(new Swim(s.x,s.y,s.wait-1));
						continue;
					}
					
					// 방문 한 곳이 아니라면 x
					if(!check[s.x][s.y]) {
						check[s.x][s.y] = true;
						
						for(int j = 0; j < 4; j++) {
							int x = s.x+dx[j];
							int y = s.y+dy[j];
							
							if(x >=0 && y >=0 && x < N && y < N) {
								// 아무것도 없다면 바로 이동
								if(pool[x][y] == 0 && !check[x][y]) q.add(new Swim(x,y,0));
								// 소용돌이라면 그만큼 wait
								else if(pool[x][y] == 2 && !check[x][y]) q.add(new Swim(x,y,vortex_t));
							}
							
						}
						
					}
				}
				
				// 시간 +1
				lev++;
				
				// 소용돌이 주기
				vortex_t--;
				if(vortex_t < 0) vortex_t = 2;
				
			}
			
			// 목표점 도달 이후 1초 더가기 때문에 lev-1
			if(check[finish.x][finish.y]) System.out.println("#"+t+ " " + (lev-1));
			// 도착 못하면 -1
			else System.out.println("#"+t+ " -1");
		}
		
	}

}
