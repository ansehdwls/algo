
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

	static int N, T;
	static int count = 0;
	static List<Integer> l[];
	static int num[];
	static int check[], visit[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case  = 0 ; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	
			l = new ArrayList[N+1];
			check = new int[N+1];
			visit = new int[N+1];
			num = new int[N+1];
			count = 0;
			for(int i = 1 ; i < N+1; i++) {
				l[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i< N + 1; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1 ; i< N + 1; i++) {
				if(visit[i] != 1) {
					go(i);	
				}
			}
			System.out.println(N-count);
		}
		
	
    }
    static void go(int d) {
    	

    	if(visit[d] == 1) {
    		check[d] = 1;
    		count++;
    	}
    	
    	else visit[d] = 1;
    	
    	if(check[num[d]] != 1) {
    		go(num[d]);
    	}
    	
    	visit[d] = 0;
    	check[d] = 1;
    		
    }

}
