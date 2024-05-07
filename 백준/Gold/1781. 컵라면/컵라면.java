import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static PriorityQueue<Integer> pq[];
	static PriorityQueue<Integer> ans = new PriorityQueue<Integer>(Collections.reverseOrder());
	static StringTokenizer st;
	static long sum = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue[N+1];
		
		for(int i = 0; i <= N; i++) {
			pq[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		int b = 0;
		
		for(int i = N; i >= 1; i--) {
			int a = pq[i].size();
			for(int j = 0; j < a; j++) {
				ans.add(pq[i].poll());
			}
			if(!ans.isEmpty()) sum += ans.poll();
		}

		System.out.println(sum);
	}

}
