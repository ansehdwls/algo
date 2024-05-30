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

public class Main {

	static int T;
	static int N, K;
	static int x, y;
	static StringTokenizer st;

	static Queue<Integer> q = new LinkedList<Integer>();
	// 그 list 부모의 깊이
	static int idxNum[];
	// 순서를 담을 list
	static List<Integer> l[];
	static int craft[];
	static int finish;
	static int ans[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = new int [N];
			craft = new int [N];
			
			l = new ArrayList[N];
			idxNum = new int [N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i< N; i++) {
				
				craft[i] = Integer.parseInt(st.nextToken());
				
				l[i] = new ArrayList<Integer>();
			}

			for(int i = 0 ; i< K ; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken())-1;
				y = Integer.parseInt(st.nextToken())-1;
				l[x].add(y);
				idxNum[y]++;
			}
			
			finish = Integer.parseInt(br.readLine())-1;
			
			for(int i = 0; i< N; i++) {
				// 최상위 부모 list 찾기
				if(idxNum[i] == 0) {
					q.add(i);
				}
			}
			
			// 순서대로 빼기
			while(!q.isEmpty()) {
				x = q.poll();
				int size = l[x].size();
				
				for(int i = 0; i < size; i++) {
					// 자식들의 부모 list 개수 줄이기 
					idxNum[l[x].get(i)]--;
					// 만약 0이되면 최상위 list 
					if(idxNum[l[x].get(i)] == 0) q.add(l[x].get(i));
					
					ans[l[x].get(i)] = Math.max(ans[l[x].get(i)], ans[x]+craft[x]);
				}
			}
			bw.write((ans[finish]+craft[finish]) +"\n");
			
		}
		
		

		bw.flush();
		bw.close();
		br.close();
	}

}
