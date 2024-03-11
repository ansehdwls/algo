import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int T[][];
	static int min = Integer.MAX_VALUE;
	static int sum = 0;
	static int check[];
	static List<Integer> l = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int [N][N];
		check = new int[N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				T[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i< N; i++) {
			go(i,i,0);
		}
		
		System.out.println(min);
	}
	static void go(int start , int finish, int idx) {
		if(idx == N-1) {
			if(T[start][finish] != 0) {
				sum += T[start][finish];
				min = Math.min(min, sum);
				sum -= T[start][finish];
			}
			return;
		}
		else {
			for(int i = 0; i < N; i++) {
				if(T[start][i] != 0 && check[i] == 0 && finish != i) {
					check[i] = 1;
					sum += T[start][i];
					go(i,finish,idx+1);
					sum -= T[start][i];
					check[i] = 0;
				}
			}
		}
	}

}
