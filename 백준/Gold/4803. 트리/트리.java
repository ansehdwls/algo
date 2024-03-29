import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int matrix[][];
	static int p[];
	static List<Integer> cycle = new ArrayList<Integer>();
	static List<Integer> tree = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cycle = new ArrayList<Integer>();
			tree = new ArrayList<Integer>();
			int v1 = 0;
			int v2 = 0;
			// 0 0 입력 종료
			if(N == 0 && M == 0) break;
			System.out.print("Case "+idx + ": ");
			p = new int[N+1];
			for(int i = 1 ; i<= N; i++ ) p[i] = i;
			
			for(int i = 0 ; i< M; i++) {
				st = new StringTokenizer(br.readLine());
				v1 = Integer.parseInt(st.nextToken());
				v2 = Integer.parseInt(st.nextToken());
				
				// 이건 사이클
				int x  = find(v1);
				int y = find(v2);
				if(x == y ) {
					cycle.add(x);
				}
				else {
					
					//유니온 하는 것중 하나가 cycle이면 사이클
					if(cycle.contains(x) || cycle.contains(y)) {
						union(v1,v2);
						cycle.add(find(v1));
					}
					else {
						union(v1,v2);
					}
				}
			}
			
			int num = 0;
			for(int i =1; i<= N; i++) {
				v1 = find(i);
				if(cycle.contains(v1)) continue;
				else if(tree.contains(v1)) continue;
				else {
					tree.add(v1);
					num++;
				}
			}
			
			if(num == 0) System.out.println("No trees.");
			else if(num == 1) System.out.println("There is one tree.");
			else System.out.println("A forest of "+num+" trees.");
			idx++;

		}
	
	
	}
	static void union(int x, int y) {
		p[find(y)] = find(x);
	}
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}


}