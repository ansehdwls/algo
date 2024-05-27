import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	
	static int N;
	static int ans = 0;
	static String s;
	static Stack<Character> sk = new Stack<Character>(); 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		s = br.readLine();
		
		// 0 이면 이전의 값이 (, 1 이면 이전의 값이 )
		int flag = 0;
		for(int i = 0 ; i < s.length(); i++) {
			// ( 이면 스택에 넣는다.
			if(s.charAt(i) == '(') {
				flag = 0;
				sk.add(s.charAt(i));
			}
			else {
				// 이전이 ( 이면 레이저, 현재까지의 쇠막대기 자르기
				if( flag == 0) {
					sk.pop();
					ans += sk.size();
					flag = 1;
				}
				// 이전이 ) 이면 쇠막대기의 끝. 현재 잘린 쇠막대기만 더해주기
				else {
					sk.pop();
					ans += 1;
				}
				
			}
		}
		
		bw.write(ans+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
