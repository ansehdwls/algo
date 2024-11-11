
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

	static int N, M, K;

	static StringTokenizer st;

	static Queue q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());	
		
		a = new long[N+1];
		d = new long[N * 4 + 1];
		Arrays.fill(d, 1);
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		init(1,1,N);
		
	
		for(int i =0 ; i < K + M; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1) {
				update(1,1,N,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			else {
				System.out.println(query(1,1,N,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
		}
	}
	
	// 세그먼트 트리 필요한 것, 원배열 최하단 노드
	static long a[];
	static long d[];
	
	// 3개의 함수가 있다. init : 초기세팅 , update : 변경 하면서 저장, query 찾기
	static void init(int node, int start, int end) {
		// 끝까지 내려와서 최하위 노드 도착, 자신 본인 값 저장
		if(start == end) {
			d[node] = a[start];
			return ;
		}
		int mid = ( start + end ) / 2;
		
		// 자식 좌, 우로 다시 세팅
		init(node*2, start, mid);
		init(node*2 + 1, mid+1, end);
		
		d[node] = (d[node * 2] * d[node *2 + 1]) % 1000000007;
		
	}
	static void update(int node, int start, int end, int index, int value) 
	{
		// 범위를 벗어나면 아님
		if( start > index || end < index) return ;
		if(start == end) {
			d[node] = value;
			return ;
		}
		
		// update된 노드 구간들도 변경
		int mid = (start + end) /2 ;
		
		update(node*2 , start, mid,index, value);
		update(node*2 +1, mid + 1, end,index, value);
		
		d[node] = (d[node * 2] * d[node *2 + 1] ) % 1000000007;
		
	}
	static long query(int node, int start, int end, int i, int j) {
		
		// 범위를 벗어나면 탐색 x
		if(start > j || i > end) return 1;
		
		// 범위 안에 있다면 모두 리턴
		else if(start >= i && end <= j) return d[node];
		
		// 겹치는 부분이라면 모두 탐색
		else {
			int mid = (start + end)/2;
			return (query(node*2, start, mid,i,j) * query(node*2 +1, mid+1, end,i,j)) % 1000000007;
		}
	}
}
