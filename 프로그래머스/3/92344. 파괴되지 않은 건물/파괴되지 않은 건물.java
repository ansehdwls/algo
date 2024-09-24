class Solution {
    static int damage[][];
    static int query;
    static int N;
    static int M;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length;
        
        damage = new int[N][M];
        query = skill.length;
        
        
        for(int i = 0; i < query; i++){
            // 공격
            if(skill[i][0] == 1){
              damage[skill[i][1]][skill[i][2]] += -1 * skill[i][5];  
              if(skill[i][3]+1 < N){
                  damage[skill[i][3]+1][skill[i][2]] += skill[i][5];  
              }
              if(skill[i][4]+1 < M){
                  damage[skill[i][1]][skill[i][4]+1] += skill[i][5];  
              }
            if(skill[i][3]+1 < N && skill[i][4]+1 < M){
                damage[skill[i][3]+1][skill[i][4]+1] +=  -1 * skill[i][5];  
            }
            }
            // 회복
            else {
              damage[skill[i][1]][skill[i][2]] += skill[i][5];  
              if(skill[i][3]+1 < N){
                  damage[skill[i][3]+1][skill[i][2]] += -1 * skill[i][5];   
              }
              if(skill[i][4]+1 < M){
                  damage[skill[i][1]][skill[i][4]+1] += -1 * skill[i][5];   
              }
                        if(skill[i][3]+1 < N && skill[i][4]+1 < M){
                            damage[skill[i][3]+1][skill[i][4]+1] +=  skill[i][5];  
                        }
            }
        }
                    
        
        
            for(int j = 0 ; j< N; j++){
                for(int k = 1 ; k < M; k++){
                    damage[j][k] += damage[j][k-1];
                }
            }
        

        
           for(int j = 0 ; j< M; j++){
                for(int k = 1 ; k < N; k++){
                    damage[k][j] += damage[k-1][j];
                }
            }
        
        
            for(int j = 0 ; j< N; j++){
                for(int k = 0 ; k < M; k++){
                    board[j][k] += damage[j][k];
                    if(board[j][k] > 0) answer++;
                }
            }
        
        
        return answer;
    }
}