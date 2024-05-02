#include <string>
#include <vector>
#include <queue>
#include <set>
#include <iostream>
#include <iterator>
using namespace std;
int map[50][50];
int check[50][50];
int dx[4]={1,0,0,-1};
int dy[4]={0,-1,1,0};
string s[4]={"d","l","r","u"};
set<string> vstr;
string result;
int gn,gm,desx, desy, gk;

// 남은 거리 > 갈 수 있는 거리(k - dp)
bool available(int x, int y, int d) {
    if(abs(desx - x) + abs(desy - y) > gk - d) return false; 
    if((gk - d) & 1 && !((abs(desx - x) + abs(desy - y)) & 1)) return false;
    if(!((gk - d) & 1) && (abs(desx - x) + abs(desy - y)) & 1) return false;
    
    return true;
}

void dfs(int sx,int sy,int idx,string path){
    int cx, cy;
    if((sx==desx)&&(sy==desy)&&(gk==idx)){
        
        
        if((gk-path.length())%2==0)
            result = path;
        return ;
    }
    if(gk<=idx){
        return ;
    }
    for(int i=0;i<4;i++){
        if(result!=""){
            if(result[idx]<s[i][0]){
                return;
            }
        }
        cx=sx+dx[i];
        cy=sy+dy[i];
        
        if(!available(cx, cy, path.length() + 1)) continue;
        
        if(cx>=0&&cx<gn&&cy>=0&&cy<gm){
            dfs(cx,cy,idx+1,path+s[i]);
        }
    }
}
string solution(int n, int m, int x, int y, int r, int c, int k) {
    string answer = "";
    //일단 경로 구하기
    gn=n;gm=m;desx=r-1;desy=c-1; gk=k;
    dfs(x-1,y-1,0,"");
    if(result=="")
        result="impossible";
    return result;
}