import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static int N;
	static int a[][];
	static StringTokenizer st;

	static int min = Integer.MAX_VALUE;
	static int max = -3000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, a[i][j]);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				a[i][j] += a[i][j-1];
			}
		}
		for(int i = 2; i < N; i++) {
			go(i);
		}
		System.out.println(max);
		
	}
	static void go(int size) {
		int sum = 0;
		for(int i = 0; i <= N - size; i++) {
			for(int j = 0 ; j <= N -size; j++) {
				sum = 0;
				for(int startx = i; startx < size+i; startx++) {
					if(j -1 < 0) {
						sum += a[startx][j+size-1];
					}
					else{
						sum += a[startx][j+size-1] - a[startx][j-1];
					}
				}
				max = Math.max(max, sum);
			}
		}
	}
}
