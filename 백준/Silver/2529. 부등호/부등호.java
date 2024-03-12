import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int f[][];
	static int ans = 0;
	static int check[];
	static List<Character> l = new ArrayList<Character>();
	static List<Integer> num = new ArrayList<Integer>();
	static List<String> a = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		check = new int [10];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			l.add(st.nextToken().charAt(0));
		}
		for(int i = 0 ; i < 10;  i++) {
			check[i] = 1;
			num.add(i);
			go(1);
			num.remove(num.size()-1);
			check[i] = 0;
		}
		Collections.sort(a);
		System.out.println(a.get(a.size()-1));
		System.out.println(a.get(0));
	}
	static void go(int idx) {
		if(idx == N+1) {
			String z = "";
			for(int i =  0 ; i  < num.size(); i++)  z += num.get(i);
			a.add(z);
			return;
		}
		else {
			for(int i = 0 ; i < 10; i++) {
				if(check[i] == 0) {
					char c = l.get(idx-1);
					if( c == '<') {
						if(num.get(idx-1) <  i) {
							check[i] = 1;
							num.add(i);
							go(idx+1);
							num.remove(num.size()-1);
							check[i] = 0;
						}
					}
					else {
						if(num.get(idx-1) >  i) {
							check[i] = 1;
							num.add(i);
							go(idx+1);
							num.remove(num.size()-1);
							check[i] = 0;
						}
					}
					
				}
			}
		}
	}


}