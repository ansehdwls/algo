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
	static StringTokenizer st;

	// vertax node는 10만개, 자식 노드들을 저장하자
	static List<Integer> v[] = new ArrayList[100001];

	// 조상이 저장된 배열
	// i = 현재 노드, j = j 번째 부모 ( 2^j )
	static int [][] p = new int [100001][18];
	// 각 vertax의 깊이를 저장
	static int depth[] = new int[100001];
	// 방문 확인
	static boolean check[] = new boolean[100001];
	static Queue<Integer> q = new LinkedList<Integer>();
	static void bfs(int x) {
		
		check[x] = true;
		q.add(x);
		// 최상위 부모의 깊이는 0
		depth[x] = 0;
		// 1번 자식 부터 부모를 구해주자
		
		while(!q.isEmpty()) {
			
			int current = q.poll();
			
			for(int i = 0 ; i < v[current].size(); i++) {
				int child = v[current].get(i);
				// 방문한 적이없다면 초기세팅
				if( !check[ child ] ) {
					check[child] = true;
					// 나의 바로 위 부모는 현재
					p[child][0] = current;
					// 자식 q에 넣기
					q.add(child);
					// 현재 자식의 깊이는 부모 깊이의 + 1
					depth[child] = depth[current] + 1;
				}
			}
			
		}
	}
	
	static void lca(int x, int y) {
		// depth가 깊은것이 x가 되어야 한다.
		if(depth[x] < depth[y]) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		// x 와 y의 깊이를 맞춰준다.
		
		for(int dep = 16;  dep >= 0; dep--) {
			// 만약 dep만큼 이동한 깊이가 y 보다 작으면 그만큼 올려준다
			if(depth[x] - (1 << dep) >= depth[y]) {
				x = p[x][dep];
			}
		}
		
		// 만약 y가 x의 공통 조상이라면 바로 끝
		if( x == y) {
			System.out.println(x);
			return ;
		}
		
		// 동시에 올라가면서 lca 찾자
		for(int dep = 16;  dep >= 0; dep--) {
			
			// dep만큼 이동했는데 0이거나 조상이 같으면 일단 옮기지 않음.
			
			
			if(p[x][dep] != p[y][dep]) {
				// 다르다면 그만큼 점프 ( 이동하자 )
				x = p[x][dep];
				y = p[y][dep];	
			}
			
			
		}
		// 그 부모가 공통조상이다
		System.out.println(p[x][0]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < 100001; i++) {
			v[i] = new ArrayList<Integer>();
		}

		for(int i = 0 ; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 자식 저장
			v[x].add(y);
			v[y].add(x);
		}

		// 초기 트리를 만들자
		bfs(1);
		
		// 각 노드의 스파스 배열 만들기 ( 본인의 위 2^n 번째 부모를 알 수 있는 배열 )
		
		// 깊이 +1  과정
		for(int j = 1 ; (1 << j ) < N ; j++) {
			// 노드들 순회하기
			for(int i = 1; i <= N; i++) {
				
				// 내 2^i 번째 부모가 없다면 할 필요 없음
				if(p[i][j-1] != 0) {
					// 내 2^i 번째 부모는 나의 2^(i-1) 번째 부모의 2^(i-1) 부모와 같다
					p[i][j] = p[p[i][j-1]][j-1];		
				}
			
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// lca로 찾자
			
			lca(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
	}

}
