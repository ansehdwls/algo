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
	static int M;

	static StringTokenizer st;

	static int min = Integer.MAX_VALUE;
	
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int current = 64;
		int stick = 0;
		int X = 0;
		pq.add(64);
	
		while(current != N) {

			stick = pq.poll();
				
			stick /= 2;
			
			if(current - stick >= N) {
				pq.add(stick);
				current -= stick;
			}
			else {
				pq.add(stick);
				pq.add(stick);
				count++;
			}
			
			
		}
		
		System.out.println(count+1);
	}

}
