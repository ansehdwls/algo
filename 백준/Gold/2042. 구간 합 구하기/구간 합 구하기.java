import java.awt.Point;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Map;
	import java.util.Queue;
	import java.util.Set;
	import java.util.StringTokenizer;

	

	
	
	public class Main {
	
		static int N;
		static int M;
		static int K;
		static StringTokenizer st;	
		
		// 원배열
		static long[] a;
		
		// 최하단 노드
		static long[] d;
		

		public static void init(int node, int start, int end) {
			// 최 하단 노드 도착
			if(start == end) {
				d[node] = a[start];
				return ;
			}
			int mid = (start + end)/2;
			init(node*2,start, mid);
			init(node*2+1,mid+1,end);
			
			// 구간 합 저장
			d[node] = d[node * 2] + d[node * 2 + 1];

		}
		// index의 값을 value로 바꾼다
		public static void update(int node, int start, int end, int index, long value) {
			// 범위를 벗어나면 탐색 x
			if(start > index || end < index) return ;
			// 범위를 찾으면 return
			if(start == end) {
				d[node] = value;
				return ;
			}
			
			// update 이후 구간합도 변경.
			 int mid = (start + end) / 2;
		     update(node * 2, start, mid, index, value);
		     update(node * 2 + 1, mid + 1, end, index, value);
		     d[node] = d[node * 2] + d[node * 2 + 1];

		}
		
		// 구간 합을 구하자 i~j
		public static long query(int node, int start, int end, int i, int j) {
			// 범위를 벗어나면 탐색 x
			if(start > j || i > end) return 0;
			// 범위 안에 있다면 모두 리턴
			else if(start >= i && end <= j) return d[node];
			// 겹치는 부분이라면 모두 탐색
			else {
				int mid = (start + end)/2;
				return query(node*2, start, mid,i,j) + query(node*2 +1, mid+1, end,i,j);
			}
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			a = new long[N+1];
			d = new long[4*N + 1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				a[i] = Long.parseLong(st.nextToken());
			}
			
			// 원배열 넣었으면 세그먼트 트리 세팅
			init(1,1,N);
			
			for(int i = 0 ; i < M + K ; i++) {
				st = new StringTokenizer(br.readLine());
				int commend = Integer.parseInt(st.nextToken());
				// 변경
				if(commend == 1) {
					int index = Integer.parseInt(st.nextToken());
					long value = Long.parseLong(st.nextToken());
					update(1, 1, N, index, value);
				}
				// 검색
				else {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					System.out.println(query(1, 1, N, x, y));
				}
			}
		}
	
	}
