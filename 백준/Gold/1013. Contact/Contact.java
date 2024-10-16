import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static String sic = "(100+1+|01)+";
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			if(s.matches(sic)) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}



}
