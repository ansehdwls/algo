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

	static int N, M;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int num[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		num = new int [N+1];
		
		for(int i = 0 ; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = N+1;
		int start = 0;
		int end = 0;
		
		int sum = 0;
		
		while(start <= N && end <= N) {
			
			if(sum >= M) {
				if(min > end - start ) min = end - start;
			}
			
			if(sum < M) {
				sum += num[end];
				
				end++;
			}
			else {
				sum -= num[start];
				
				start++;
			}
		}
		
		if(min == N + 1) System.out.println(0);
		else System.out.println(min);
    }
 

}
