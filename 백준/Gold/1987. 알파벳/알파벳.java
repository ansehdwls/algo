import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char c[][];
	static int maxCount = 1;
	static List<Character> l = new ArrayList<Character>();
	static int check[];
	static int dx[] = { 0, 0 , 1, -1 };
	static int dy[] = {1, -1, 0, 0 };
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer((br.readLine()));
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		c = new char[N][M];
		check = new int[26];
		for(int i = 0 ; i < N; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				c[i][j] = s.charAt(j);
			}
		}
		
		go(0,0);
		System.out.println(maxCount);
		
	}
	static void go(int x, int y) {
		if(check[c[x][y] - 'A'] == 0) {
			check[c[x][y] - 'A'] = 1;
			l.add(c[x][y]);
			for(int i = 0; i < 4; i++) {
				int idx = dx[i] + x;
				int idy = dy[i] + y;
				
				if(idx >= 0 && idy >= 0 && idx < N && idy < M) {
					if(l.contains(c[idx][idy])) {
						maxCount = Math.max(maxCount, l.size());
					}
					else {
						go(idx, idy);
					}
				}
			}
			l.remove(l.size()-1);
			check[c[x][y] - 'A'] = 0;
		}
	}
}
