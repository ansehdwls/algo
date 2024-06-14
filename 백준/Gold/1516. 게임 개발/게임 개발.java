import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int temp;
	static int gate[];

	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	static int ans[];
	static int idxNum[];
	static List<Integer> l[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		ans = new int [N];
		gate = new int[N];
		l = new ArrayList[N];
		for(int i = 0 ; i< N; i++) l[i] = new ArrayList<Integer>();
		idxNum = new int[N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gate[i] = Integer.parseInt(st.nextToken());
			while(true) {
				temp = Integer.parseInt(st.nextToken());
				if(temp == -1) break;
				else {
					// 부모 입력
					idxNum[i]++;
					l[temp-1].add(i);
				}
			}
		}
		
		// 자식이 없는 건물 먼저 짓기
		for(int i = 0; i< N; i++) {
			// 최상위 부모 list 찾기
			if(idxNum[i] == 0) {
				q.add(i);
			}
		}
		int x ;
		while(!q.isEmpty()) {
			x = q.poll();
			int size = l[x].size();
			
			for(int i = 0; i < size; i++) {
				// 자식들의 부모 list 개수 줄이기 
				idxNum[l[x].get(i)]--;
				// 만약 0이되면 최상위 list 
				if(idxNum[l[x].get(i)] == 0) q.add(l[x].get(i));
				
				ans[l[x].get(i)] = Math.max(ans[l[x].get(i)], ans[x]+gate[x]);
			}
		}
		for(int i = 0; i< N; i++) {
			bw.write((ans[i]+gate[i])+"\n");
		}

		bw.close();
	}

}
