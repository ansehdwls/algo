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

	static int N, M;
	static int x, y;
	static StringTokenizer st;

	static Queue<Integer> q = new LinkedList<Integer>();
	// 그 list 부모의 깊이
	static int idxNum[];
	// 순서를 담을 list
	static List<Integer> l[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		l = new ArrayList[N];
		idxNum = new int [N];
		for(int i = 0 ; i< N; i++) {
			l[i] = new ArrayList<Integer>();
		}

		for(int i = 0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			l[x].add(y);
			idxNum[y]++;
		}
		
		for(int i = 0; i< N; i++) {
			// 최상위 부모 list 찾기
			if(idxNum[i] == 0) {
				q.add(i);
			}
		}
		
		// 순서대로 빼기
		while(!q.isEmpty()) {
			x = q.poll();
			System.out.print((x+1) + " ");
			int size = l[x].size();
			
			for(int i = 0; i < size; i++) {
				// 자식들의 부모 list 개수 줄이기 
				idxNum[l[x].get(i)]--;
				// 만약 0이되면 최상위 list 
				if(idxNum[l[x].get(i)] == 0) q.add(l[x].get(i));
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
