import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringTokenizer st;

	static int size = 0;
	static int n[][];
	static int jo[];
	
	static int min = 1000000;
	static int sum[];
	static List<Integer> l = new ArrayList<Integer>();
	static List<Integer> ans = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		n = new int [5][N];
		
		st= new StringTokenizer(br.readLine());
		jo = new int[4];
		sum = new int[5];
		for(int i = 0; i< 4; i++) {
			jo[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0 ; i< N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j< 5; j++) {
				n[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<= N; i++) {
			go(0,i,0);
		}
		
		if(min != 1000000) {
			System.out.println(min);
			for(int i = 0 ; i<ans.size(); i++) {
				System.out.print(ans.get(i)+ " ");
			}
		}
		else System.out.println("-1");
	}

	static void go(int idx, int finish,int start) {
		if(idx == finish) {
			
			boolean isGood = true;
			for(int i = 0; i < 4; i++) {
				
				if(sum[i] < jo[i]) {
					isGood = false;
					break;
				}
			}
			if(isGood) {
				if(min > sum[4]) {
					ans = new ArrayList<Integer>();
					for(int i = 0; i< l.size(); i++) {
						ans.add(l.get(i));
					}
					min = sum[4];
				}
				else if(min == sum[4]) {
					int dx = 0;
					int dy = 0;
					boolean isOk = false;
					while(dx < l.size() && dy < ans.size()) {
						if(l.get(dx) < ans.get(dy)) {
							isOk = true;
							break;
						}
						else if(l.get(dx) == ans.get(dy)) {
							dx++;
							dy++;
						}
						else {
							break;
						}
					}
					if(isOk) {
						ans = new ArrayList<Integer>();
						for(int i = 0; i< l.size(); i++) {
							ans.add(l.get(i));
						}
					}
				}
			}
			
			
			return ;
		}
		else {
			for(int i = start ; i < N; i++) {
			for(int j = 0 ; j< 5; j++) {
				sum[j] += n[j][i];
			}
			l.add(i+1);
			go(idx+1,finish,i+1);
			l.remove(l.size()-1);
			for(int j = 0 ; j< 5; j++) {
				sum[j] -= n[j][i];
			}
		}
		}
	}

}