import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static Point home;
	static Point company;
	static List<Point> custom; 
	static boolean check[];
	static int N;
	// max 값과 케이스별 sum
	static int sum;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 회사, 집 좌표 받기
			company = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			// 손님 배열 초기화
			custom = new ArrayList<Point>();
			
			// 손님 좌표 받기
			for(int i = 0 ; i < N; i++) {
				custom.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			
			// 체크 배열 초기화
			check = new boolean[N];
			min = Integer.MAX_VALUE;
			sum = 0;
			
			go(0,company);
			System.out.println("#"+t+" " +min);
		}
		br.close();
	}
	static void go(int idx, Point start) {
		
		// 손님집 방문이 끝나면 집으로 이동 후 종료
		if(idx == N) {
			
			// 최종 값
			int ans = sum;
			ans += Math.abs(start.x - home.x) + Math.abs(start.y - home.y);
			
			// 최단 경로
			min = Math.min(min, ans);
			return ;
		}
		else {
			for(int i = 0 ; i < N; i++) {
				if(!check[i]) {
					// x 거리 + y 거리
					Point cus = custom.get(i);
					int distance = Math.abs(start.x - cus.x) + Math.abs(start.y - cus.y);
					
					check[i] = true;
					sum += distance;
					go(idx+1, cus);
					sum -= distance;
					check[i] = false;
				}
			}
		}
	}

}
