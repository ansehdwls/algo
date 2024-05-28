import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Rectangle{
	
	long len;
	long idx;
	
	public Rectangle(long idx,long len) {
		this.len = len;
		this.idx = idx;
	}
}

public class Main {
	
	static long N;
	static StringTokenizer st;
	static long max;
	static long ans[] = new long[100001];
	static long rec[] = new long[100001];
	static String s;
	static Stack<Rectangle> skR = new Stack<Rectangle>(); 
	static Stack<Rectangle> skL = new Stack<Rectangle>(); 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n;
		Rectangle temp;
		long maxLen;
		long currentLen;
		
		// 양옆으로 오작수 (오른쪽 가장 작고 가까운 수의 idx) 구하기 
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(st.countTokens() != 0) {
				max = 0;
				
				// 자기 자신의 길이
				for(int i = 0; i< N; i++) {
					rec[i] = Long.parseLong(st.nextToken());
					ans[i] = rec[i];
				}

				
				// 오른쪽 오작수를 통한 넓이
				// 첫 번째 직사각형은 그냥 넣기
				skR.add(new Rectangle(0,rec[0]));
				
				// 두 번째 부터 오작수 비교
				for(int i = 1; i < N; i++) {
					n = rec[i];
					while(!skR.isEmpty()) {
						if(skR.peek().len > n) {
							temp = skR.pop();
							ans[(int) temp.idx] += temp.len * ( i - temp.idx -1); 
						}
						else break;
					}
					skR.add(new Rectangle(i,n));
				}
				
				// len 처리를 위함.
				maxLen = N; 
				currentLen = N;
				
				// 남은 스택의 직사각형 처리
				while(!skR.isEmpty()) {
					//currentlen과 스택의 len 1차이라면 maxLen 유지
					temp = skR.pop();
					ans[ (int) temp.idx] += temp.len * (maxLen -temp.idx -1);

				}
				

				
				// 왼쪽으로 오작수 구하기 반대 끝편부터 넣기
				skL.add(new Rectangle(N-1,rec[(int) N-1]));
				
				// 두 번째 부터 오작수 비교
				for(int i =  (int) N-2; i >= 0; i--) {
					n = rec[i];
					while(!skL.isEmpty()) {
						if(skL.peek().len > n) {
							temp = skL.pop();
							ans[ (int) temp.idx] += temp.len * ( temp.idx-i -1); 
						}
						else break;
					}
					skL.add(new Rectangle(i,n));
				}
				

				// len 처리를 위함.
				maxLen = -1; 
				currentLen = -1;
				
				// 남은 스택의 직사각형 처리
				while(!skL.isEmpty()) {
					//currentlen과 스택의 len 1차이라면 maxLen 유지
					temp = skL.pop();
					ans[(int) temp.idx] += temp.len * (temp.idx-maxLen-1);
				}

				for(int i = 0 ; i< N;i++) max = Math.max(max, ans[i]);
				
				bw.write(max+"");
				bw.write("\n");
				skL.clear();
				skR.clear();
			}
			else break;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
