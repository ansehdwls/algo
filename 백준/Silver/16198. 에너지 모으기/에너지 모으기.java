import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int W[];
	static int max = 0;
	static int sum = 0;
	static int check[];
	static List<Integer> l = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		W = new int [N];
		check = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i  < N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}
		go(0);
		System.out.println(max);
	}
	static void go(int idx) {
		if(idx == N-2) {
			max = Math.max(max, sum);
			return ;
		}
		else {
			for(int i = 1 ; i < N-1 ; i++) {
				if(check[i] == 0) {
					check[i] = 1;
					int x = i;
					int y = i;
					while(x >= 0) {
						if(check[x] == 0) {
							x = W[x];
							break;
						}
						x--;
					}
					while(y < N) {
						if(check[y] == 0 ) {
							y = W[y];
							break;
						}
						y++;
					}
					sum += x*y;
					go(idx +1);
					sum -= x*y;
					check[i] = 0;
				}
			}

		}
	}

}
