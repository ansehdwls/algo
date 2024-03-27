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
	static int food[][];
	static StringTokenizer st;
	static boolean check[];
	static List<Integer> A = new ArrayList<Integer>();
	static List<Integer> B= new ArrayList<Integer>();
	static int min = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			food = new int [N][N];
			check = new boolean[N];
			min =Integer.MAX_VALUE;
			for(int i = 0 ; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			go(0,0);
			System.out.println("#"+t+" "+min);
		}
		

	}
	
	static void go(int idx,int start) {
		if(idx == N/2) {
			for(int i = 0 ; i< N; i++) {
				if(check[i]) A.add(i);
				else B.add(i);
			}
			
			int sumA = 0;
			int sumB = 0;
			for(int i = 0 ; i < N/2; i++) {
				for(int j =0  ; j < N/2; j++) {
					sumA += food[A.get(i)][A.get(j)];
					sumB += food[B.get(i)][B.get(j)];
				}
			}
			min = Math.min(min, Math.abs(sumA-sumB));
			A.removeAll(A);
			B.removeAll(B);
			return ;
		}
		for(int i = start ; i< N; i++) {
			if(!check[i]) {
				check[i] = true;
				go(idx+1,i+1);
				check[i] = false;
			}
		}
	}
}
