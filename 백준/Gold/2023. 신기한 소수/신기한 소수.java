import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int dp[][];
	static int ans = 0;
	static int check[];
	static List<Character> l = new ArrayList<Character>();
	static List<Integer> num = new ArrayList<Integer>();
	static List<Integer> a = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		go(2,1);
		go(3,1);
		go(5,1);
		go(7,1);
		
		Collections.sort(num);
		for(int i = 0; i< num.size(); i++) System.out.println(num.get(i));
	}
	static void go(int s , int idx) {
		if(idx == N) {
			num.add(s);
			return;
		}
		else {
			s *= 10;
			for(int i = 0 ; i < 10; i++) {
				if(isPrime(s+i)) {
					go(s+i,idx+1);
				}
			}
		}
	}
	 static boolean isPrime(int number) {

	        if (number == 3 ||  number == 2) {
	            return true;
	        }
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

}