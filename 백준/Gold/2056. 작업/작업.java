
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static int N, M;
	
	static int idxNum[];
	static int jobTime[];
	static List<Integer> l[];
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static int result[];
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		idxNum = new int[N+1];
		jobTime = new int[N+1];
		result = new int[N+1];
		l = new ArrayList[N+1];
		
		for(int i = 0; i < N+1; i++) {
			l[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1 ; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			jobTime[i] = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				l[i].add(temp);

				idxNum[temp]++;
			}
			
		}
		
		for(int i = 1; i< N+1; i++) {
			result[i] = jobTime[i];
			
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
				
				result[l[x].get(i)] = Math.max(result[l[x].get(i)], result[x]+jobTime[l[x].get(i)]);
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		
		System.out.println(max);
		
    }
    

}
