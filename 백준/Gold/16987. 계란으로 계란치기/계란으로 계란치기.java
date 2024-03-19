import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Egg {
	int w;
	int arm;
	public Egg(int arm, int w) {
		this.arm = arm;
		this.w = w;
	}
}

public class Main {
	static int N;
	static Egg egg[];
	static int max = 0;
	static List<Point> t = new ArrayList<Point>();
	static List<Point> bin = new ArrayList<Point>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new Egg [N];
		StringTokenizer st;
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
		}
		go(0);
		System.out.println(max);
		br.close();
	}
	static void go(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i = 0 ;i < N; i++) {
				if(egg[i].arm <= 0) sum++;
			}

			max = Math.max(max, sum);
			return;
		}
		else {
				if(egg[idx].arm > 0) {
					for(int j = 0; j < N; j++) {
						if(j != idx ) {
							if(egg[j].arm > 0) {
								egg[idx].arm -= egg[j].w;
								egg[j].arm -= egg[idx].w;
								go(idx+1);
								egg[idx].arm += egg[j].w;
								egg[j].arm += egg[idx].w;
							}
							else go(idx+1);
						}
					}
				}
				else {
					go(idx+1);
				}
		}
	}
}
