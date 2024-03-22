import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int map[][];
	static int min = 999999;
	static List<Point> h = new ArrayList<Point>();
	static List<Point> c = new ArrayList<Point>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i =  0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) h.add(new Point(i,j));
				if(map[i][j] == 2) c.add(new Point(i,j));
			}
		}
		go(0,c.size());
		System.out.println(min);
	}
	public static void go( int s ,int idx ) {
		if(idx == M) {
			min = Math.min(min, str());
			return;
		}
		else {
			for(int i = s; i < c.size(); i++) {
				map[c.get(i).x][c.get(i).y] = 0;
				go(i+1, idx-1);
				map[c.get(i).x][c.get(i).y] = 2;
			}
		}
		
	}
	
	public static int str() {
		int sum = 0 ;
		List<Point> rc = new ArrayList<Point>();
		for(int i =  0 ; i < N ; i++) {
			for(int j = 0; j < N ; j++) {
				if(map[i][j] == 2) rc.add(new Point(i,j));
			}
		}
		
		for(int i =  0 ; i < h.size() ; i++) {
			int a = Math.abs(rc.get(0).x - h.get(i).x) + Math.abs(rc.get(0).y - h.get(i).y);
			for(int j = 1; j < rc.size() ; j++) {
				a = Math.min(a, Math.abs(rc.get(j).x - h.get(i).x) + Math.abs(rc.get(j).y - h.get(i).y));
			}
			sum += a;
		}
		
		return sum;
	}

}
