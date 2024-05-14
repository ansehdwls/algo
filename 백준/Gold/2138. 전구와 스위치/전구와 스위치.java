import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int num1[];
	static int num2[];
	static int ans[];

	static boolean finish1 = false;
	static boolean finish2 = false;
	static Deque<Integer> btn = new LinkedList<Integer>();
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		num1 = new int[N];
		num2 = new int[N];
		
		ans = new int[N];
	
		String s = br.readLine();

		for (int i = 0; i < N; i++) {
			num1[i] = s.charAt(i) - '0';
			num2[i] = num1[i];
		}

		s = br.readLine();

		for (int i = 0; i < N; i++) {
			ans[i] = s.charAt(i) - '0';
		}
		
		int count1 = 0;
		int count2 = 1;
		
		
		num2[0]  = (num2[0] + 1)%2;
		num2[1]  = (num2[1] + 1)%2;
		
		for(int i = 1; i < N-1; i++) {
			if(ans[i-1] != num1[i-1]) {
				count1++;
				num1[i-1]  = (num1[i-1] + 1)%2;
				num1[i]  = (num1[i] + 1)%2;
				num1[i+1]  = (num1[i+1] + 1)%2;
			}
		}
		
		if(ans[N-2] != num1[N-2]) {
			count1++;
			num1[N-2]  = (num1[N-2] + 1)%2;
			num1[N-1]  = (num1[N-1] + 1)%2;
		}
		
		if(ans[N-1] == num1[N-1]) finish1 = true;
		
		for(int i = 1; i < N-1; i++) {
			if(ans[i-1] != num2[i-1]) {
				count2++;
				num2[i-1]  = (num2[i-1] + 1)%2;
				num2[i]  = (num2[i] + 1)%2;
				num2[i+1]  = (num2[i+1] + 1)%2;
			}
		}
		
		if(ans[N-2] != num2[N-2]) {
			count2++;
			num2[N-2]  = (num2[N-2] + 1)%2;
			num2[N-1]  = (num2[N-1] + 1)%2;
		}
		
		if(ans[N-1] == num2[N-1]) finish2 = true;
		if(finish1 && finish2) {
			System.out.println(Math.min(count1, count2));
		}
		else if(finish1) {
			System.out.println(count1);
		}
		else if(finish2) {
			System.out.println(count2);
		}
		else System.out.println("-1");
	}


}
