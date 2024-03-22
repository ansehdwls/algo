import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Stack<Character> stack = new Stack<Character>();
	static String str;
	static char boom[];
	static char ans[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		String bo = br.readLine();
		boom = new char[bo.length()];
		boolean isGood = false;
		for(int i = 0; i < bo.length(); i++) {
			boom[i] = bo.charAt(i);
		}
		
		int size = bo.length();
		int s = 0;
		int stack_size = 0;
		char ch = ' ';
		while(s != str.length()) {
			stack_size = stack.size();
			ch = str.charAt(s);
			if(ch != boom[size-1]) {
				stack.add(ch);
			}
			else {
				if(stack_size < size-1 ) stack.add(ch);
				else {

					isGood = true;
					for(int i = 1 ; i < size; i++) {
						if(boom[size-1 - i] != stack.get(stack_size -i) ) {
							isGood = false;
							break;
						}
					}

					if(isGood) {
						for(int i = 0 ; i < size-1; i++) {
							stack.pop();
						}
					}
					else stack.add(boom[size-1]);
				}
			}
			s++;
		}
		StringBuilder sb = new StringBuilder();
		if(stack.size() != 0) {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse().toString());
		}
		else  System.out.println("FRULA");

	}

}
