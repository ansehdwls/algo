import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	// N : 접수창구. M : 정비 창구 , K : 고객의 수
	static int N, M, K;
	static final int SIXTEEN = 16;
	static StringTokenizer st;
	static String temp;
	static Set<String> set = new HashSet<String>();
	static Deque<String> dq = new LinkedList<String>();
	static List<Long> pass = new ArrayList<Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	set = new HashSet<String>();
        	
        	String s = br.readLine();
        	for(int k = 0; k < N/4; k++) {
        		for(int i = 0 ; i < 4; i++) {
            		temp = "";
            		for(int j = 0 ; j < N/4; j++) {
            			if(i*N/4 +j+k >= N) temp += s.charAt( (i*N/4 +j + k )% N);
            			else temp += s.charAt(i*N/4 +j+k);
            		}
            		set.add(temp);
            	}
        	}
        	dq = new LinkedList<String>(set);
        	pass = new ArrayList<Long>();
        	while(!dq.isEmpty()) {
        		temp = dq.poll();
        		// 16진수 변환해서 넣기
        		pass.add(convert(temp));
        	}
        	Collections.sort(pass,Collections.reverseOrder());
        	System.out.println("#"+t+" "+pass.get(M-1));
        	
        }
    }
    static long convert(String s) {
    	int size = s.length();
    	long sum = 0;
    	int a = 0;
    	long m = 1;
    	for(int i = size-1; i >=0; i--) {
    		char c = s.charAt(i);
    		switch(c) {
    			case 'A' : a = 10; break;
    			case 'B' : a = 11; break;
    			case 'C' : a = 12; break;
    			case 'D' : a = 13; break;
    			case 'E' : a = 14; break;
    			case 'F' : a = 15; break;
    			default : a = c -'0';
    		}
    		sum += a*m ;
    		m *= SIXTEEN;
    	}
    	return sum;
    }
        
}