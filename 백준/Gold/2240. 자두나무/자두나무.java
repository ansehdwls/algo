import java.util.*;
import java.io.*;

public class Main {
    static int T, W; // T: 시간, W: 이동 횟수
    static int[] plum;

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        plum = new int[T];

        for (int i = 0; i < T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[T][W + 1][3];

        if (plum[0] == 1) {
            dp[0][0][1]++;
        } else {
            if (W >= 1)
                dp[0][1][2]++;
        }

        for (int i = 1; i < T; i++) {
            if (plum[i] == 1) {
                for (int j = 0; j <= W && j <= i + 1; j++) {
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    dp[i][j][2] = dp[i - 1][j][2];
                }

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2] + 1, dp[i][j][1]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i][j][2]);
                }
            } else {
                for (int j = 0; j <= W && j <= i + 1; j++) {
                    dp[i][j][1] = dp[i - 1][j][1];
                    dp[i][j][2] = dp[i - 1][j][2] + 1;
                }

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i][j][1]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1] + 1, dp[i][j][2]);
                }
            }
        }

        // 최대 이동횟수를 사용하지 않은것이 정답일 수도 있나?
        int max = 0;
        for (int i = 0; i <= W; i++) {
            max = Math.max(max, dp[T - 1][i][1]);
            max = Math.max(max, dp[T - 1][i][2]);
        }
        System.out.println(max);
        br.close();
    }
}