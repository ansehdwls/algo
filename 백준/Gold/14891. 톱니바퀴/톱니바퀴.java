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
	static int top[][];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		top = new int[5][8];
		for(int i = 1 ; i < 5; i++) {
			String setTop = br.readLine();
			for(int j = 0 ; j < 8; j++) {
				top[i][j] = setTop.charAt(j)  - '0';
			}
		}
		
		
		
		N = Integer.parseInt(br.readLine());
	
		int con[] = new int [3];
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			// 현재 연결점 확인
			if(top[1][2] != top[2][6]) con[0] = 1;
			else con[0] = 0;
			if(top[2][2] != top[3][6]) con[1] = 1;
			else con[1] = 0;
			if(top[3][2] != top[4][6]) con[2] = 1;
			else con[2] = 0;
			
			if(num == 1) {
				rotate(1, dir);
				if(con[0] == 1) {
					rotate(2, dir * -1);
					if(con[1] == 1) {
						rotate(3, dir);
						if(con[2] == 1) {
							rotate(4, dir * -1);
						}
					}
				}
			}
			else if(num == 2) {
				rotate(2, dir);
				if(con[0] == 1) {
					rotate(1, dir * -1);
				}
				if(con[1] == 1) {
					rotate(3, dir * -1);
					if(con[2] == 1) {
						rotate(4, dir);
					}
				}
			}
			else if(num == 3) {
				rotate(3, dir);
				if(con[2] == 1) {
					rotate(4, dir * -1);
				}
				if(con[1] == 1) {
					rotate(2, dir * -1);
					if(con[0] == 1) {
						rotate(1, dir);
					}
				}
			}
			else{
				rotate(4, dir);
				if(con[2] == 1) {
					rotate(3, dir * -1);
					if(con[1] == 1) {
						rotate(2, dir);
						if(con[0] == 1) {
							rotate(1, dir * -1);
						}
					}
				}
			}
		}
		
		
		int answer = 0;
		if(top[1][0] == 1) answer += 1;
		if(top[2][0] == 1) answer += 2;
		if(top[3][0] == 1) answer += 4;
		if(top[4][0] == 1) answer += 8;
		
		System.out.println(answer);
		
	}


	static void rotate(int n, int d) {
		int temp = top[n][0];
		if(d == -1) {
			for(int i = 0; i < 7 ; i++) {
				top[n][i] = top[n][i+1];
			}
			top[n][7] = temp;
		}
		else {
			temp = top[n][7];
			for(int i = 7; i >= 1 ; i--) {
				top[n][i] = top[n][i-1];
			}
			top[n][0] = temp;
		}
	}
}
