import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex> {
	int v;
	long w;

	public Vertex(int v, long w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Vertex o) {
		return (int) (this.w - o.w );
	}
}

public class Main {

	static int N, E;

	static int v1, v2;
	static int s, e;
	static long w;
	static Vertex temp;

	static List<Vertex> l[];

	// 시작점의 dijkstra 거리
	static long dist[][];

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 다익스트라 초기값은 무한
		dist = new long[3][N+1];
		Arrays.fill(dist[0], 200000001);
		Arrays.fill(dist[1], 200000001);
		Arrays.fill(dist[2], 200000001);

		l = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			l[i] = new ArrayList<Vertex>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			l[s].add(new Vertex(e, w));
			l[e].add(new Vertex(s, w));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		dijkstra(0, 1);
		dijkstra(1, v1);
		dijkstra(2, v2);
		long dis1 = dist[0][v1] + dist[1][v2] + dist[2][N];
		long dis2 = dist[0][v2] + dist[2][v1] + dist[1][N];

		if (dis1 > dis2 && dis2 < 200000001) {
			System.out.println(dis2);
		} else if (dis1 < 200000001) {
			System.out.println(dis1);
		} else {
			System.out.println("-1");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static void dijkstra(int t, int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(start, 0));
		dist[t][start] = 0;

		while (!pq.isEmpty()) {
			Vertex vertex = pq.poll();

			if (vertex.w <= dist[t][vertex.v]) {

				int len = l[vertex.v].size();

				for (int i = 0; i < len; i++) {
					temp = l[vertex.v].get(i);
					if (dist[t][temp.v] > vertex.w + temp.w) {
						dist[t][temp.v] = vertex.w + temp.w;
						pq.add(new Vertex(temp.v, vertex.w + temp.w));
					}

				}
			}
		}
	}
}
