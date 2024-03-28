import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int N;
	static int desert[][];
	static boolean check[][];
	static StringTokenizer st;
	static int max = -1;
	static int sum = 0;
	static List<Integer> l;
	// 오 왼 왼 오 대각선
	static int dx[] = {1,1,-1,-1};
	static int dy[] = {1,-1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	desert = new int[N][N];
        	max = -1;
        	sum = 0;
        	l = new ArrayList<Integer>();
        	
        	for(int i =0 ; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j< N; j++)
        		{
        			desert[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}

        	for(int i =0 ; i < N; i++) {
        		for(int j = 0; j< N; j++)
        		{
        			go(i,j,0,i,j);
        		}
        	}
        	
        	System.out.println("#"+t+" "+max);
        }
    }
    static void go(int x, int y, int dir,int start,int finish) {
    	// 범위 벗어나면 아웃
    	if(x < start ||x < 0 || y < 0 || x >= N || y >= N) return ;
    	if(dir == 3 && start == x && y == finish) {
    		max =Math.max(max, sum);
    		return;
    	}
    	else {
    		// 디저트가 들어있다면 볼필요 없음
    		if(l.contains(desert[x][y])) return ;
    		else {
    			// 쭉 가거나 or 방향을 틀거나
    			sum++;
    			l.add(desert[x][y]);
    			go(x+dx[dir],y+dy[dir],dir,start,finish);
    			// 방향이 3이면 더이상 바꿀필요 x
    			if(dir != 3) go(x+dx[dir+1],y+dy[dir+1],dir+1,start,finish);
    			l.remove(l.size()-1);
    			sum--;
    			
    			//
    		}
    	}
    }
        
}