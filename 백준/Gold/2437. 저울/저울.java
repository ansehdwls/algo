
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static int N;

	static StringTokenizer st;
	static int a[];
	static Queue q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		int start = 1;
		if(1 < a[0]) System.out.println(1);
		else {
			for(int i = 1 ; i < N; i++) {
				if(start+1 < a[i]) {
					break;
				}
				else {
					start += a[i];
				}
			}
			System.out.println(start+1);
		}
	}

}
