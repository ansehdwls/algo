#include <bits/stdc++.h>
using namespace std;

int ans = 1e6;
int malp = 0, mcop = 0;
int dp[151][151]; // [alp][cop] = cost

int solution(int alp, int cop, vector<vector<int>> prob) {
    
    for(int i = 0; i < prob.size(); i++) {
        int ap = prob[i][0], cp = prob[i][1]; 
        
        malp = max(malp, ap);
        mcop = max(mcop, cp);
    }
    
    sort(prob.begin(), prob.end());
        
    fill(&dp[0][0], &dp[150][151], 1e6);
    
    dp[alp][cop] = 0;

    for(int j = alp; j <= 150; j++) {
        for(int k = cop; k <= 150; k++) {
            for(int i = 0; i < prob.size(); i++) {
                int ap = prob[i][0], cp = prob[i][1], ad = prob[i][2], cd = prob[i][3], cost = prob[i][4]; 
                // 1증가
                if(k - 1 >= 0)
                    dp[j][k] = min(dp[j][k], dp[j][k - 1] + 1);
                if(j - 1 >= 0)
                    dp[j][k] = min(dp[j][k], dp[j - 1][k] + 1);
                
                int nx = j + ad > 150 ? 150 : j + ad;
                int ny = k + cd > 150 ? 150 : k + cd;
                
                if(j >= ap && k >= cp)
                    dp[nx][ny] = min(dp[nx][ny], dp[j][k] + cost);
            }
        }
    }
    
    for(int i = malp; i <= 150; i++) {
        for(int j = mcop; j <= 150; j++)
            ans = min(ans, dp[i][j]);
    }
    
    return ans;
}