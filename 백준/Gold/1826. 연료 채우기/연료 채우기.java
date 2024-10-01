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

class Gas implements Comparable<Gas>{
	int x;
	int num;
	public Gas(int x, int num) {
		this.x = x;
		this.num = num;
	}
	@Override
	public int compareTo(Gas o) {
		// TODO Auto-generated method stub
		return this.x - o.x ;
	}
}

public class Main {
	static int N;
	static int L;
	static int P;
	static int min = 11;
	static PriorityQueue<Gas> dq = new PriorityQueue<Gas>(); 
	static PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dq.add(new Gas(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int distance = 0;
		Gas station = dq.poll();
		int count = 0;
		boolean isGood = true;
		while(distance < L) {
			if(station.x <= distance) {
				q.add(station.num);
				if(!dq.isEmpty()) station = dq.poll();
			}
			
			if(distance == P) {
				if(q.isEmpty()) {
					isGood = false;
					break;
				}
				else {
					P += q.poll();
					count++;
				}
			}
			distance++;
		}
		
		
		if(!isGood) System.out.println(-1);
		else System.out.println(count);
	}

}
