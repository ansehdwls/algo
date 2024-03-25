import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int K;
	static String s;
	static String temp;
	static StringBuffer sb;
	static Set<String> l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			s = br.readLine();
			l = new HashSet<String>();
			for(int i =0; i < s.length(); i++) {
				for(int j = i+1 ; j <= s.length(); j++) {
					l.add(s.substring(i, j));
				}
			}
//			TreeSet<String> ts = new TreeSet<String>();
//			ts.addAll(l);
			List<String> ls = new ArrayList<String>(l);
			Collections.sort(ls);
			if(ls.size() < K) System.out.println("#"+t+" none");
			else System.out.println("#"+t+" "+ls.get(K-1));
		}
		

	}


}
