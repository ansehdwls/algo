import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Light implements Comparable<Light>{
	int x;
	int y;
	int dir;
	int len;
	public Light(int x, int y, int dir, int len) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.len = len;
	}
	@Override
	public int compareTo(Light o) {
		return this.len - o.len;
	}
}

public class Main {
	
	static int N;
	static StringTokenizer st;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static boolean visit[][][];
	static PriorityQueue<Light> l = new PriorityQueue<Light>();
	static char mirror[][];
	static int min = 3000;
	static int first = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		mirror = new char[N][N];
		visit = new boolean[N][N][4];
		String s;
		for(int i = 0 ; i < N; i++) {
			s = br.readLine();
			for(int j = 0 ; j < N; j++) {
				mirror[i][j] = s.charAt(j);
				if(mirror[i][j] == '#' && first == 0) {
					for(int k = 0; k < 4; k++) {
						l.add(new Light(i,j,k,0));
						visit[i][j][k] = true;
					}
					first = 1;
				}
			}
		}
		
		int x;
		int y;
		Light light;
		while(!l.isEmpty()) {
			light = l.poll();
			x = light.x + dx[light.dir];
			y = light.y + dy[light.dir];
			
			if(x <0 || y <0 || x >= N || y >=N) continue;
			
			if(!visit[x][y][light.dir]) {
				visit[x][y][light.dir] = true;
				
				if(mirror[x][y] == '#') {
					min = light.len;
					break;
				}
				
				else if(mirror[x][y] == '*') continue;
				
				else if( mirror[x][y] == '.') l.add(new Light(x,y,light.dir,light.len));
				
				else {
					l.add(new Light(x,y, light.dir, light.len) );
					l.add(new Light(x,y, (light.dir + 1)%4, light.len+1) );
					l.add(new Light(x,y, (light.dir + 3)%4, light.len+1) );
				}
				
			}
			
		}
		
		System.out.println(min);
		
	
	}

}
