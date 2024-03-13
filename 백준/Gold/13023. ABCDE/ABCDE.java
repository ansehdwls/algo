import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int ans = 0;
	static int check[];
	static List<Integer> []l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		l = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) l[i] = new ArrayList<Integer>();
		
		check = new int[N];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			l[x].add(y);
			l[y].add(x);
		}
		
		for(int i = 0; i< N; i++) {
			go(i,0);
			if(ans == 1) break;
		}
		
		System.out.println(ans);
	}
	static void go(int start , int idx) {
		if(idx == 5) {
			ans = 1;
			return;
		}
		else {
			for(int i = 0; i < l[start].size(); i++) {
				if(check[l[start].get(i)] == 0) {
					check[l[start].get(i)] = 1;
					go(l[start].get(i),idx+1);
					check[l[start].get(i)] = 0;
				}
                if(ans == 1 ) break;
			}
		}
	}

}
