import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;

public class Main {
	static int N;
	static List<Integer> l = new ArrayList<Integer>();
	static int num[];
	static int check[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		check = new int[N];
		for(int i = 1 ; i <= N; i++) {
			num[i-1] = i;
		}
		go(0);
		br.close();
	}
	static void go(int idx) {
		if(idx == N) {
			for(int i = 0 ; i < l.size(); i++)
			{
				System.out.print(l.get(i) +" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = 0 ; i < N; i++) {
				if(check[i] == 0) {
					check[i] = 1;
					l.add(num[i]);
					go(idx+1);
					l.remove(l.size()-1);
					check[i] = 0;
				}
			}
		}
	}
}
