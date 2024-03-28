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
	static int N, M ,X;
	static int road[][];
	static StringTokenizer st;
	static int sum;
	static Deque<Integer> dq[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			//init
			road = new int [N][N];
			dq = new LinkedList[2*N];
			for(int i = 0; i< 2*N; i++) {
				dq[i] = new LinkedList<Integer>();
			}
			sum = 0;
			for(int i = 0 ; i< N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					road[i][j] = Integer.parseInt(st.nextToken());
					dq[i].add(road[i][j]);
					dq[j+N].add(road[i][j]);
				}
			}
			
			// 현재 높이
			int start = 0;
			// 다음 높이
			int next = 0;
			// 평탄한 길 길이
			int len = 1;
			
			boolean isImpos = false;
			
			// 도로 하나씩 꺼내면서 비교
			for(int i = 0; i< 2*N; i++) {
				start = dq[i].poll();
				len = 1;
				isImpos = false;
				
				while(!dq[i].isEmpty()) {
					next = dq[i].poll();
					
					if(next == start) len++;
					else {
						// 높은 곳으로 활주로를 세운다. 높이가 1차이고, X만큼 보장되어있다.
						if( (next-1 == start)  && len >= X) {
							start = next;
							len = 1;
						}
						else {
							// 낮은 곳으로 활주를 세운다. 높이가 1차이
							if(next+1 == start) {
								len = 0;
								int j = 0;
								// 그 다음부터의 X길이 만큼 보장되는가
								for(j = 0 ; j< X-1; j++) {
									// 길이 없다면 끝
									if(dq[i].isEmpty()) break;
									else {
										// 길이 확보되기 전 길이가 변경되면
										if(next != dq[i].poll()) break;
									}
								}
								// 모두 수행되었다면
								if(j == X-1) {
									start = next;
									continue;
								}
							}

							isImpos = true;
							break;
						}
					}
					
				}
				
				// 활주로 건설이 가능하다면 개수 증가
				if(!isImpos) sum++;			
			
			}
			
			System.out.println("#"+t+" "+sum);			
		}
		

	}
	

}
