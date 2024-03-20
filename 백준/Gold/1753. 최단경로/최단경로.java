import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertax implements Comparable<Vertax>{
	int v;
	int w;
	public Vertax(int v, int w) {
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Vertax o) {
		
		return this.w - o.w;
	}
}

public class Main {
	static int V, E;
	static int path[];
	static int start;
	static int min;
	static int sum;
	static boolean check[];
	static PriorityQueue<Vertax> q = new PriorityQueue<Vertax>();
	static ArrayList<Point> l[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		l = new ArrayList[V+1];
		for(int i = 0 ; i < V+1; i++) l[i] = new ArrayList<Point>();
		path = new int [V+1];
		Arrays.fill(path, Integer.MAX_VALUE);

		check = new boolean [V+1];
		start = Integer.parseInt(br.readLine());
		path[start] = 0;
		// 간선 및 경로 저장
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			l[x].add(new Point(y, weight));
		}

		q.add(new Vertax(start,0));
		
		while(!q.isEmpty()) {
			Vertax ver = q.poll();

				for(int i = 0 ; i < l[ver.v].size(); i++) {
					if(path[ver.v] + l[ver.v].get(i).y < path[l[ver.v].get(i).x]) {
						path[l[ver.v].get(i).x] = path[ver.v] + l[ver.v].get(i).y;
						q.add(new Vertax(l[ver.v].get(i).x,path[l[ver.v].get(i).x]));
					}
				}
				
			
		}

		for(int i = 1; i <= V; i++) {
			if(path[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(path[i]);
		}
		
	}

	

}
