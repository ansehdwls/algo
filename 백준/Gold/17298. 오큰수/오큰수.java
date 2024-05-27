import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class NumDex{
	int idx;
	int num;
	
	public NumDex(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}

public class Main {
	
	static int N;
	static int ans[];
	static StringTokenizer st;
	static Stack<NumDex> stack = new Stack<NumDex>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		ans = new int[N];
		// 초기값 -1
		Arrays.fill(ans,-1);
		st = new StringTokenizer(br.readLine());
		
		// 첫번째 숫자를 index와 함께 넣기
		stack.add(new NumDex(0, Integer.parseInt(st.nextToken())));
		
		int n = 0;
		NumDex temp;
		
		for(int i = 1; i< N;i++) {
			// 두번째 부터 비교
			n = Integer.parseInt(st.nextToken());
			
			// 스택 차례대로 비교
			while(!stack.isEmpty()) {
				
				// 만약 오른쪽 수가 크다면 index에 값 넣어주기
				if(stack.peek().num < n) {
					ans[stack.pop().idx] = n;
				}
				// 현재값 그대로 넣고 break
				else {
					break;
				}
			}
			
			// 마지막엔 현재 숫자와 함께 index 넣기
			stack.add(new NumDex(i, n));
		}
		
		
		for(int i = 0; i< N; i++) {
			bw.write(ans[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
