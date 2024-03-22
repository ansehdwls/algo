import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class City implements Comparable<City>{
	int x;
	int dis;
	
	public City(int x, int dis) {
		this.x = x;
		this.dis = dis;
	}

	@Override
	public int compareTo(City o) {
		
		return this.dis - o.dis;
	}
}

public class Main {
	static int N, M;
	static int p[];
	static int dis[];
	static List<City> bus[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int [N+1];
		bus = new ArrayList[N+1];
		dis = new int[N+1];
		for(int i = 1 ;i < N+1; i++) {
			p[i] = i;
			bus[i] = new ArrayList();
			dis[i] = Integer.MAX_VALUE;
		}
		StringTokenizer st;
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			bus[Integer.parseInt(st.nextToken())].add(new City(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
//			matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int finish = Integer.parseInt(st.nextToken());

		
		dijkstra(start);
		
		System.out.println(dis[finish]);
//		Collections.sort(bus);
		
		
//		int select = 0;
//		for(int i = 0; i < bus.size(); i++) {
//			if(select == N-1) break;
//			City c = bus.get(i);
//			
//			if(find(c.x) == find(c.y)) continue;
//			
//			union(c.x,c.y);
//			
//		}

	}
	
	static void dijkstra (int start) {
		
		PriorityQueue<City> q = new PriorityQueue<City>();
		q.add(new City(start,0));
		
		while(!q.isEmpty()) {
			City city = q.poll();
			int current = city.x;
			int distance = city.dis;
			
			if(dis[current] < distance) continue;
			
			for(int i = 0 ; i < bus[current].size() ; i++) {
				int next = bus[current].get(i).x;
				int nextDistance = bus[current].get(i).dis + distance;
				
				if(dis[next] > nextDistance) {
					dis[next] = nextDistance;
					q.add(new City(next, nextDistance));
				}
			}
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
