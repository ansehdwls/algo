import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N, M;

    static int num[];
    static int dp[][][];
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int [3];
        dp = new int [61][61][61];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        go(num[0],num[1],num[2],0);
        
        System.out.println(dp[num[0]][num[1]][num[2]]);
    }

    static int go(int scv1, int scv2, int scv3, int cnt) {
    	
    	if(scv1 <= 0 && scv2 <= 0 && scv3 <= 0) {
    		return 0;
    	}
    	
    	if(scv1 <= 0 ) {
    		scv1 = 0;
    	}
    	if(scv2 <= 0 ) {
    		scv2 = 0;
    	}
    	if(scv3 <= 0) {
    		scv3 = 0;
    	}
    	
    	if(dp[scv1][scv2][scv3] != 0) {
    		return dp[scv1][scv2][scv3];
    	}
    	
    	int res = 1000000;
    	
    	res = Math.min(res, 1 + go(scv1 - 9, scv2 - 3, scv3 - 1, cnt+1));
    	res = Math.min(res, 1 + go(scv1 - 9, scv2 - 1, scv3 - 3, cnt+1));
    	res = Math.min(res, 1 + go(scv1 - 3, scv2 - 9, scv3 - 1, cnt+1));
    	res = Math.min(res, 1 + go(scv1 - 1, scv2 - 9, scv3 - 3, cnt+1));
    	res = Math.min(res, 1 + go(scv1 - 1, scv2 - 3, scv3 - 9, cnt+1));
    	res = Math.min(res, 1 + go(scv1 - 3, scv2 - 1, scv3 - 9, cnt+1));
    	dp[scv1][scv2][scv3] = res;
    	
    	return dp[scv1][scv2][scv3];
    	
    }
}
