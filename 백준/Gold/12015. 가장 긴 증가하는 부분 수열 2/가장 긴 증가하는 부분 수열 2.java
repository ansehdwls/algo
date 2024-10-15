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
	
 	static StringTokenizer st;
 	
 	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		 
		int[] seq = new int[N];
		int[] lis = new int[N];
 
		st = new StringTokenizer(br.readLine());
 
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
 
		// 초기값 세팅
		lis[0] = seq[0];
		
		int length = 1;
		
		for (int i = 1; i < N; i++) {
 
			int temp = seq[i];
			
			// 만약 temp가 lis의 마지막 값보다 클 경우 추가. 
			if (lis[length - 1] < temp) {
				length++;
				lis[length - 1] = temp;
			} 
			else {
				// lower Bound 이분탐색
				int lower = 0;
				int high = length;
				while (lower < high) {
					int mid = (lower + high) >>> 1;
					
					if(lis[mid] < temp) {
						lower = mid + 1;
					}
					else {
						high = mid;
					}
 
				}
				
				lis[lower] = temp;
			
			}
			
		}
		System.out.println(length);
	}



}
