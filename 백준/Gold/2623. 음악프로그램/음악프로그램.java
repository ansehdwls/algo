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

	static int N, M;
	static int temp;

	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	static Queue<Integer> ans = new LinkedList<Integer>();
	static int idxNum[];
	static List<Integer> l[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		l = new ArrayList[N+1];
		for(int i = 1 ; i< N+1; i++) l[i] = new ArrayList<Integer>();
		idxNum = new int[N+1];
		
		int n;
		int first;
		int second;
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			first = Integer.parseInt(st.nextToken());
			for(int j = 1 ; j< n; j++) {
				second = Integer.parseInt(st.nextToken());
				idxNum[second]++;
				l[first].add(second);
				first = second;
			}
		}
		
		// 자식이 없는 건물 먼저 짓기
		for(int i = 1; i< N+1; i++) {
			// 최상위 부모 list 찾기
			if(idxNum[i] == 0) {
				q.add(i);
			}
		}
		int x ;
		while(!q.isEmpty()) {
			x = q.poll();
			int size = l[x].size();
			ans.add(x);
			for(int i = 0; i < size; i++) {
				// 자식들의 부모 list 개수 줄이기 
				idxNum[l[x].get(i)]--;
				// 만약 0이되면 최상위 list 
				if(idxNum[l[x].get(i)] == 0) q.add(l[x].get(i));
			}
		}
		if(isImpos()) bw.write("0");
		else {
			while(!ans.isEmpty()) {
				bw.write(ans.poll() + "\n");
			}
		}

		bw.close();
	}
	static boolean isImpos() {
		for(int i = 1 ; i< N+1; i++) {
			if(idxNum[i] != 0) return true;
		}
		return false;
	}

}
