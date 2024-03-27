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
	static int N;
	static int M;
	static int friends[][];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			friends = new int[N][N];
			for(int i = 0 ;i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					friends[i][j] = 100000;
				}
				friends[i][i] = 0;
			}
			for(int i = 0 ;i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						friends[i][j] = 1;
					}
				}
			}
			
			
			for(int k = 0 ; k< N; k++) {
				for(int i = 0 ; i < N; i++) {
					for(int j = 0; j < N; j++) {
						friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
					}
				}
			}

			
			int cc = 0;
			int min = 100000;
			for(int i = 0 ; i< N ;i++) {
				cc = 0;
				for(int j = 0 ; j < N; j++) {
					cc += friends[i][j];
				}
				min = Math.min(min, cc);
			}
			System.out.println("#"+t+" "+min);
			
		}
		

	}

}
