import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char map[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static List<Point> t = new ArrayList<Point>();
	static List<Point> bin = new ArrayList<Point>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') t.add(new Point(i,j));
				if(map[i][j] == 'X') bin.add(new Point(i,j));
			}
		}
		
		go(0,0);
		System.out.println("NO");
		
		br.close();

	}
	
	static void go(int idx,int start) {
		if(idx == 3) {
			if(isGood()) {
				System.out.println("YES");
				System.exit(0);
			}
			return ;
		}
		else {
			char temp[][] = new char [N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N ; j++) {
					temp[i][j] = map[i][j];
				}
			}
			for(int i = start; i < bin.size(); i++) {
				map[bin.get(i).x][bin.get(i).y] = 'O';
				go(idx+1, start+1);
				for(int j = 0; j < N; j++) {
					for(int k = 0 ; k < N ; k++) {
						map[j][k] = temp[j][k];
					}
				}
			}
		}
	}
	static boolean isGood() {
		for(int i = 0 ; i < t.size(); i++) {
			int x = t.get(i).x;
			int y = t.get(i).y;
			
			for(int j = 0 ; j < 4; j++) {
				int xdx = x+dx[j];
				int ydy = y+dy[j];
				while(xdx >= 0 && ydy >= 0 && xdx < N && ydy < N) {
					if(map[xdx][ydy] == 'O') break;
					if(map[xdx][ydy] == 'S') return false;
					xdx += dx[j];
					ydy += dy[j];
				}
			}
		}
		return true;
	}

}
