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

	static int N, M, K, T;

	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int [] sum;
	static List<Point> p = new ArrayList<Point>();
	
	
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());

		sum = new int[N];
		Arrays.fill(sum, Integer.MAX_VALUE);
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p.add(new Point(x, y));
		}	
		
		int baseX;
		int baseY;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int start = 0;
		int temp = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				
				baseX = p.get(i).x;
				baseY = p.get(j).y;
				
				for(int k = 0 ; k < N; k++) {
				
					pq.add(Math.abs( baseX - p.get(k).x) + Math.abs( baseY - p.get(k).y));
				}
				start = 0;
				temp  = 0;
				while(!pq.isEmpty()) {
					temp += pq.poll();
					sum[start] = Math.min(sum[start],  temp );
					start++;
					
				}
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			System.out.print(sum[i] + " ");
		}
		
	}
	

	
}
