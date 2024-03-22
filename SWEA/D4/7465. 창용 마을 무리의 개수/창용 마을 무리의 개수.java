import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int p[];

	static List<Integer> l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			l = new ArrayList<Integer>();
			p = new int[N+1];
			for(int i = 1; i < N+1; i++) {
				p[i] = i;
			}
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			for(int i = 1; i < N+1; i++) {
				int a = find(i);
				if(!l.contains(a)) l.add(a);
			}
			System.out.println("#"+t +" "+ l.size());
		}

		br.close();

	}

	static void union(int x , int y) {
		p[find(y)] = find(x);
	}
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}

}
