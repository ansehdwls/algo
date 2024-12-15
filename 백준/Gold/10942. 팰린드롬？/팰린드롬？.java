
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static int N, M, K ,S , E ;
	
	static int num[];
	static int dp[][];

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N+1];
		dp = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			for(int j = 1; j < N+1; j++) {
				dp[i][j] = -1;
			}
			dp[i][i] = 1;
		}
		
		for(int i = 2 ; i <= N ; i++) {
			if(num[i-1] == num[i]) dp[i-1][i] = 1;
			else dp[i-1][i] = 0;
		}
		
		
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		for(int k = 0; k < K ;k++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			sb.append(go(S, E)).append("\n");
			
		}

		System.out.println(sb.toString());
		
    }
    static int go(int a, int b) {
        if (dp[a][b] != -1) {
            return dp[a][b];
        }


        if (num[a] != num[b]) {
            return dp[a][b] = 0;
        } else {
            return dp[a][b] = go(a + 1, b - 1);
        }
    }

}
