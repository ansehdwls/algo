import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static double sum = 0;
	static double each_per = 1;
	static boolean map[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static double per[] = new double[4];
	static List<Point> t = new ArrayList<Point>();
	static List<Point> bin = new ArrayList<Point>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[30][30];
		for(int i = 0 ; i < 4; i++) {
			per[i] = Integer.parseInt(st.nextToken());
		}
		go(0, new Point(15,15));

		System.out.println(sum);
	}
	static void go(int idx, Point bot) {
		if(idx == N) {
//			System.out.println(each_per);
			sum += each_per;
			return;
		}
		else {
			if(!map[bot.x][bot.y]) {
				map[bot.x][bot.y] = true;
				
				for(int i = 0 ; i < 4; i++) {
					if(!map[bot.x+dx[i]][bot.y+dy[i]] && per[i] != 0) {
						each_per *= (per[i]/100);
						go(idx+1, new Point(bot.x+dx[i],bot.y+dy[i]));
						each_per /= (per[i]/100);
					}
				}
				
				map[bot.x][bot.y] = false;
			}
		}
	}
}
