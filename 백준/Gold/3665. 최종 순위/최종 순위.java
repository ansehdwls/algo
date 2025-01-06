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

class Order implements Comparable<Order> {
	int x;
	int y;
	public Order(int x, int y) {
	 this.x = x;
	 this.y = y;
	}
	@Override
	public int compareTo(Order o) {

		return this.y - o.y;
	}
}

public class Main {

	static int N, M, K, T;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int idxNum[];
	static int num[];
	static List<Integer>[] l;
	static Queue q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			
			idxNum = new int [N+1];
			int idxBase[] = new int [N+1];
			num = new int[N+1];
			
			
			st = new StringTokenizer(br.readLine());
			
			
			for(int i = 1; i <= N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				idxNum[num[i]] = i-1;		
				idxBase[num[i]] = i-1;
			}

			M = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(idxBase[a] > idxBase[b]) {
					idxNum[a]--;
					idxNum[b]++;	
				}
				else {
					idxNum[a]++;
					idxNum[b]--;	
				}
				
			}
			
			
			int ans[] = new int [N+1];
			boolean isImpos = false;
			for(int i = 1; i<= N; i++) {
				
				if(idxNum[i] > N || idxNum[i] < 0 || ans[idxNum[i]] != 0 ) {
					isImpos = true;
					break;
				}
				
				ans[idxNum[i]] = i;
			}
			
			if(isImpos) System.out.println("IMPOSSIBLE");
			else {
				for(int i = 0; i< N; i++) {
					
					System.out.print( ans[i] + " ");
				}
				System.out.println();
			}
			
		}
	}

}
