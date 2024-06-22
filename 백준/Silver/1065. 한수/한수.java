import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int temp;
	static int first;
	static int second;
	static int third; 
	static int num[];
	static List<Integer> l[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = new int[1001];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num[0] = 1;
		// 1 ~ 9 길이가 1이라 고정
		// 10 ~ 99 길이가 2, 등차는 한번 
		for(int i = 1; i < 100; i++) {
			num[i] = i;
		}

		// 100 ~ 999 까지는 비교를 통해 추가
		for(int i = 100; i < 1000; i++) {
			if(isNum(i)) {
				num[i] = num[i-1] + 1;
			}
			else num[i] = num[i-1];
		}
		
		// 1000은 등차 수열을 못이룸
		num[1000] = num[999];
		System.out.println(num[N]);
	}
	static boolean isNum(int i) {
		temp = i;
		first = temp/100;
		temp -= first * 100; 
		second = temp/10;
		temp -= second * 10;
		third = temp;
		
		if( (first - second) == (second - third)) return true;
		
		return false;
	}

}
