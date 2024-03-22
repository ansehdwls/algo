import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static Integer num[];
	static List<Integer> l = new ArrayList<Integer>();
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			num = new Integer [s.length()];
			max = 0;
			for(int i = 0 ; i < s.length(); i++) {
				num[i] = s.charAt(i) - '0';
			}
			N = Integer.parseInt(st.nextToken());
			
			if( N <= 5 ) go(0);
			else {
				Arrays.sort(num,Collections.reverseOrder());
				go(5);
			}
			System.out.println("#"+t+" "+max);
		}

		br.close();

	}

	static void go(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i = 0; i < num.length; i++) {
				sum = sum*10 + num[i];
			}
			max = Math.max(sum, max);
			return ;
		}
		else {
			int temp[] = new int [num.length];
			for(int i = 0 ; i < num.length; i++ ) {
				temp[i] = num[i];
			}
			int te =0;
			for(int i = 0 ; i < num.length; i++) {
				if(te != num[i]) {
					for(int j = 0 ; j < num.length; j++) {
						if(i != j && num[i] <= num[j]) {
							int tem = num[i];
							num[i] = num[j];
							num[j] = tem;
							go(idx+1);
							for(int k = 0 ; k < num.length; k++ ) {
								num[k]= temp[k];
							}
						}
					}
				}
			}
		}
	}
}
