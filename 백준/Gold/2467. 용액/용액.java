import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N ;
	static StringTokenizer st;
	static int num[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int left = 0;
		int right = N-1;
		
		int lnum = num[left];
		int rnum = num[right];
		
		int n = num[left] + num[right];
		int min = Math.abs(n);
		while(left < right) {
			
			if(n == 0 ) break;
			else if(n > 0) {
				right--;
			}
			else {
				left++;
			}
			
			if(left == right) break;
			
			n = num[left] + num[right];
			
			if(min > Math.abs(n)) {
				min = Math.abs(n);
				lnum = num[left];
				rnum = num[right];
			}
		}
		System.out.println(lnum + " " + rnum);

	}
}