import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int r_map[][];
	static int lev;
	static boolean check[][];
	static int max_len = 0;
	static String s[];
	static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			s = new String[200];
			max_len = 0;
			
			for(int i = 0 ; i < 100; i++) {
				s[i] = "";
				s[i+100] = "";
				s[i] = br.readLine();
			}
			
			for(int i = 0 ; i < 100; i++) {
				for(int j = 0 ; j < 100; j++) {
					s[100+i] += s[j].charAt(i)+"";
				}
			}
			for(int i = 0 ; i< 200; i++) {
				for(int j = 0; j < 100; j++) {
					if(100 - j < max_len ) break;
					if(s[i].charAt(j) == s[i].charAt(99)) {
						max_len = Math.max(max_len, isPalindrome(s[i].substring(j, s[i].length())));
					}
				}
			}
			
			System.out.println("#"+T+" " + max_len);
		}
		

	}

	static int isPalindrome(String temp) {
		if (max_len > temp.length())
			return 1;
		if (temp.length() == 1)
			return 1;

		int len = temp.length();
		sb = new StringBuffer(temp.substring(len / 2 + len % 2, len));
		if (temp.substring(0, len / 2).equals(sb.reverse().toString())) {
			return len;
		}
			
		else
			return isPalindrome(temp.substring(0, len-1));

	}

}
