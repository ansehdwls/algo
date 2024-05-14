#include <bits/stdc++.h>
using namespace std;

int malp = 0, mcop = 0;
vector<vector<int>> prob;
int dp[151][151]; // [alp][cop] = cost

int dfs(int a, int c) {
    if(a >= malp && c >= mcop) return 0;
    if(dp[a][c] != 1e9) return dp[a][c];
    
     // 1증가
    if(a < 150)
        dp[a][c] = dfs(a + 1, c) + 1;
    if(c < 150)
        dp[a][c] = min(dp[a][c], dfs(a, c + 1) + 1);
                
    for(int i = 0; i < prob.size(); i++) {
        int ap = prob[i][0], cp = prob[i][1], ad = prob[i][2], cd = prob[i][3], cost = prob[i][4];
        
        if(a >= ap && c >= cp)
            dp[a][c] = min(dp[a][c], dfs((a + ad >= 150) ? 150 : a + ad, (c + cd) >= 150 ? 150 : c + cd) + cost);
    }
    
    return dp[a][c];
}

int solution(int alp, int cop, vector<vector<int>> probl) {
    prob = probl;
    
    for(int i = 0; i < prob.size(); i++) {
        int ap = prob[i][0], cp = prob[i][1]; 
        
        malp = max(malp, ap);
        mcop = max(mcop, cp);
    }
    
    sort(prob.begin(), prob.end());
        
    fill(&dp[0][0], &dp[150][151], 1e9);
        
    int ans = dfs(alp, cop);
    
    return ans;
}