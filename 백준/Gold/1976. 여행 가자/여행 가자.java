import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int con[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		con = new int[N];
		for(int i = 0 ; i < N; i++) {
			con[i] = i;
		}

		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				if( Integer.parseInt(st.nextToken()) == 1) union(i,j);
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		int a = con[Integer.parseInt(st.nextToken())-1];
		
		boolean flag = true;
		
		for(int i = 0 ; i < M-1 ; i++) {
			if( find(Integer.parseInt(st.nextToken())-1) != a) {
				flag = false;
				break;
			}
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static void union(int a, int b) {
		con[find(b)] = find(a);
	}
	static int find(int a) {
		if(con[a] == a) return a;
		con[a] = find(con[a]);
		return con[a];
	}

	
}
