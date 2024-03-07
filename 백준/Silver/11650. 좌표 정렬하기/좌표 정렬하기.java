import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Po implements Comparable<Po>{
	int x;
	int y;
	public Po(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Po o) {
		if(o.x == this.x) return this.y - o.y;
		return this.x - o.x;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Po p[] = new Po[N];
		StringTokenizer st;
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Po(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(p);
		for(int i = 0  ; i < N; i++) {
			System.out.println(p[i].x + " " + p[i].y);
		}
		br.close();
	}

}
