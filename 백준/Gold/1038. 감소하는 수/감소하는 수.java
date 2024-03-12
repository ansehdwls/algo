import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int f[][];
	static int ans = 0;
	static int check[];
	static List<Long> l = new ArrayList<Long>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < 10 ; i++) {
			go(i,1);
		}
		Collections.sort(l);
		if(l.size()  <= N) System.out.println(-1);
		else System.out.println(l.get(N));
		br.close();
	}
	static void go(long s, int idx) {
		if(idx == 11) {
			return;
		}
		else {
			l.add(s);
			for(long i = s%10-1 ; i >=0 ; i--) {
				go( (s*10) + i, idx+1);
			}
		}
	}


}