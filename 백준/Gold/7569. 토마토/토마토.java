import java.io.*;

import java.util.*;

class GoodTomato{
	int x;
	int y;
	int z;
	public GoodTomato(int z, int x, int y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class Main {
	static int[][][] tomato;
	static int N;
	static int M;
	static int H;
	static int dx[] = {0, 0, 0, 0, 1, -1};
	static int dy[] = {0, 0, 1, -1, 0, 0};
	static int dz[] = {1, -1, 0, 0, 0, 0};
	static boolean [][][]check;
	static int tomato_num = 0;
	static Queue<GoodTomato> q = new LinkedList<GoodTomato>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		check = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for(int j = 0 ; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k] == 1) {
						q.add(new GoodTomato(i, j, k));
					}
					else if (tomato[i][j][k] == 0 )tomato_num++;
				}
			}
		}
		int day = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i< size; i++) {
				GoodTomato gg = q.poll();
				if(!check[gg.z][gg.x][gg.y]) {
					check[gg.z][gg.x][gg.y] = true;
					tomato_num--;
					for(int j = 0 ; j < 6; j++) {
						int z = gg.z + dz[j];
						int x = gg.x + dx[j];
						int y = gg.y + dy[j];
						if(x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < H) {
							if(tomato[z][x][y] == 0 && !check[z][x][y]) q.add(new GoodTomato(z, x, y));
						}
					}
				}
			}
			

			day++;
			if(isAll()) break;
		}
		
		if(isAll()) System.out.println(day-1);
		else System.out.println("-1");
	}
	static boolean isAll() {
		for (int i = 0; i < H; i++) {
			for(int j = 0 ; j < N; j++) {
				for(int k = 0 ; k < M; k++) {
					if(tomato[i][j][k] == 0 && !check[i][j][k]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}