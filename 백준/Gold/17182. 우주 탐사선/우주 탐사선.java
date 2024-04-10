import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

	/* 행성의 수 N, 출발 행성 K */
	static int N, K;
	
	/* 행성간의 거리 */
	static int plt[][];
	
	/* 행성을 담을 리스트 */
	static List<Integer> l = new ArrayList<Integer>();
	
	/* check 배열 */
	static boolean check[];
	
	
	/* sum은 행성간의 총 길이, min 최소 거리*/
	static int min = Integer.MAX_VALUE;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new boolean [N];
		
		/* 처음 거리 */
		plt = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				plt[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* A행성에서 B행성으로 가는 최단경로 구하기 (플로이드) */
		for(int k = 0 ; k< N; k++) {
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					plt[i][j] = Math.min(plt[i][j], plt[i][k]+plt[k][j]);
				}
			}
		}
		
		
		/* K 부터 시작해서 모든 행성을 돌아보자 */
		check[K] = true;
		go(1);
		
		System.out.println(min);
			
	}

	static void go(int idx) {
		if(idx == N) {
			int start = K;
			int sum = 0;
			for(int i = 0; i< l.size(); i++) {
				sum += plt[start][l.get(i)];
				start = l.get(i);
			}
			min = Math.min(min, sum);
			return ;
		}
		else {
			for(int i = 0 ; i< N; i++) {
				if(!check[i]) {
					l.add(i);
					check[i] = true;
					go(idx +1);
					check[i] = false;
					l.remove(l.size()-1);
				}
				
			}
		}
	}
}