import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Bridge implements Comparable<Bridge>{
	
	int start;
	int finish;
	int len;
	public Bridge(int start, int finish, int len) {
		this.start = start;
		this.finish = finish;
		this.len = len;
	}
	
	@Override
	public int compareTo(Bridge o) {
		return this.len - o.len;
	}
	
	
}

public class Main {

	/* 학교의 수 N, 다리의 수 M */
	static int N, M;
	
	/* 대학교 배열 */
	static int V[];
	
	/* union find p배열 */ 
	static int p[];
	
	/* 다리 연결 총 길이*/
	static int lenSum = 0;
	
	static PriorityQueue<Bridge> pq = new PriorityQueue<Bridge>();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		V = new int[N+1];
		p = new int[N+1];
		/* 남자 0, 여자 1 */
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<= N ;i++) {
			if(st.nextToken().equals("M")) V[i] = 0;
			else V[i] = 1;
		}
		
		int x = 0, y = 0;
		int len = 0;
		/* 다리 리스트 받기 */
		/* 크루스칼, 우선순위 큐 ( 다리 길이 짧은 기준 ) */
		for(int i = 0 ; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			
			// 만약 성별이 같다면 연결 x
			if(V[x] != V[y]) {
				pq.add(new Bridge(x,y,len));
			}
		}
		
		/* 사이클 확인을 위한 p배열 초기화 */
		for(int i = 1 ; i<=N ; i++) p[i] = i;
		
		/* 다리 개수 */
		int bSum = 0;
		
		/* 다리 잇기 N-1 개 */
		while(!pq.isEmpty() && bSum != N-1) {
			Bridge b = pq.poll();
			
			// 만약 연결되어있다면 연결 x
			if(find(b.start) != find(b.finish)) {
				union(b.start,b.finish);
				lenSum += b.len;
				bSum++;
			}

		}
		
		/* 모든 대학교가 이어졌는지 체크 */
		boolean isGood = true;
		int check = find(1);
		for(int i = 2 ; i<= N; i++) {
			if(check != find(i)) {
				isGood = false;
				break;
			}
		}
		
		/* 연결되었다면 출력 */ 
		if(isGood) System.out.println(lenSum);
		else System.out.println("-1");
		
	}
	
	static void union(int x,int y) {
		p[find(x)] = find(y);
	}
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}

	
}