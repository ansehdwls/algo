import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static String N;
	static int count = 0;
	static Set<String> num = new HashSet<String>();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = br.readLine();
		for(int i = 0 ; i< N.length(); i++) {
			go(i,i, N.charAt(i)+"", N.charAt(i)+"");
		}
		System.out.println(num.size());
	}

	static void go(int l, int r,String s, String path) {
		if(s.length() == N.length()) {
			num.add(path);
			return;
		}
		else {
			if(l-1 >= 0) {
				go(l-1,r,N.charAt(l-1)+s,path+N.charAt(l-1)+s);
			}
			if(r+1 < N.length()) {
				go(l,r+1,s+N.charAt(r+1),path+s+N.charAt(r+1));
			}
		}
	}
}
