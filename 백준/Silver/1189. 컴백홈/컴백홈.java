import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K;
	static int sum = 0;
	static char map[][];
	static int dx[] = {0 ,0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new boolean[R][C];
		for(int i = 0 ;i < R; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		go(1, new Point(R-1,0));
		System.out.println(sum);
		br.close();
	}
	
	static void go(int idx, Point p) {
		if(idx == K) {


			// 목적지 도착하면 개수 +1
			if(p.x == 0 && p.y == C-1) sum++;
			return;
		}
		else{
			// 한번도 오지 않은 곳이라면 ㄱ
			if(!check[p.x][p.y]) {
				

				
				//왔던곳 체크
				check[p.x][p.y] = true;
				
				for(int i = 0; i < 4; i++) {
					int x = p.x + dx[i];
					int y = p.y + dy[i];
					if(x >=0 && y >=0 && x < R && y < C) {
						if(map[x][y] != 'T' && !check[x][y]) go(idx+1, new Point(x,y));
					}
				}
				
				
				check[p.x][p.y] = false;
			}
			
		}
	}
}
