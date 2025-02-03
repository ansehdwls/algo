import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N;

    static int num[];
    static int count[];
    
    static int dp[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        for(int t= 0 ; t < 3; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	num = new int [N];
        	count = new int [N];
        	dp = new int[100001];
        	int sum = 0 ;
        	
        	for(int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
        		num[i] = Integer.parseInt(st.nextToken());
        		count[i] = Integer.parseInt(st.nextToken());
        		sum += num[i] * count[i];
        	}
        	dp[0] = 1;
        	if(sum%2 == 1) System.out.println(0);
        	
        	else {
        		
        		for(int i = 0; i < N; i++) {
        			
        			for(int j = sum/2; j >= num[i]; j--) {
        				
        				if(dp[j-num[i]] == 1) {
        					for(int k = 1; k <= count[i]; k++) {
        						if(j - num[i] + (num[i] * k) < 100001) {
        							dp[j - num[i] + (num[i] * k)] = 1;
        						}
        					}
        				}
        				
        			}
        		}
        		if(dp[sum/2] == 1) {
        			System.out.println(1);
        		}
        		
        		else {
        			
        			System.out.println(0);
        		}
        	}
        }

        
    }

}
