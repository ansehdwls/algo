import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] dp;
    static int[] indegree;
    static List<int[]>[] adj;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        
        dp = new int[N + 1][N + 1];
        indegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); 
            int Y = Integer.parseInt(st.nextToken()); 
            int K = Integer.parseInt(st.nextToken()); 
            
            adj[Y].add(new int[]{X, K}); 
            indegree[X]++; 
        }


        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N; i++) {
            if (indegree[i] == 0) { 
                dp[i][i] = 1; 
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int[] next : adj[cur]) {
                int temp = next[0]; 
                int count = next[1]; 
                indegree[temp]--;
                
                
                for (int i = 1; i < N; i++) {
                    dp[temp][i] += dp[cur][i] * count;
                }

                if (indegree[temp] == 0) {
                    q.add(temp);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (dp[N][i] > 0) {
                sb.append(i).append(" ").append(dp[N][i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
