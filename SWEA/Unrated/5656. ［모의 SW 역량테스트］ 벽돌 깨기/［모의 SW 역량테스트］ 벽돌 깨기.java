import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	// N : 접수창구. M : 정비 창구 , K : 고객의 수
	static int N, W, H;
	// 벽
	static int wall[][];
	
	static int min = 0;
	static int sum = 0;
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static Queue<Point> q = new LinkedList<Point>();
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	H = Integer.parseInt(st.nextToken());
        	wall = new int[H][W];
    		
        	min = Integer.MAX_VALUE;
        	
        	
        	for(int i = 0 ; i < H; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0 ; j < W; j++) {
        			wall[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	go(0);
        	System.out.println("#"+t+" "+min);
        }
    }
    
    static void go(int idx) {
    	if(idx == N) {
    		sum = 0;
    		for(int i = 0 ; i < H; i++) {
        		for(int j = 0 ; j < W; j++) {
        			if(wall[i][j] > 0) sum++;
        		}
        	}
    		min = Math.min(sum, min);
    		return ;
    	}
    	else {
    		// 복구 temp 배열
    		int temp[][] = new int[H][W];
    		for(int i = 0 ; i < H; i++) {
        		for(int j = 0 ; j < W; j++) {
        			temp[i][j] = wall[i][j];
        		}
        	}
    		for(int i = 0 ;i < W; i++) {
    			wallBreak(i);
    			go(idx +1);
    			// 원상복구
    			for(int j = 0 ; j < H; j++) {
            		for(int k = 0 ; k < W; k++) {
            			wall[j][k] = temp[j][k];
            		}
            	}
    		}
    	}
    }
    static void wallBreak(int x) {

    	
    	for(int i =0 ; i< H; i++) {
    		// 구슬과 벽이만나면 q에 저장
    		if(wall[i][x] > 0) {
    			q.add(new Point(i,x));
    			break;
    		}
    	}
    	
    	boolean check[][] = new boolean[H][W];
    	
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		if(!check[p.x][p.y]) {
    			check[p.x][p.y] = true;
    			
    			// 벽의 크기만큼 터짐
    			for(int j = 0 ; j < 4; j++) {
    				int idx = p.x;
    				int idy = p.y;
    				for(int i = 0; i < wall[p.x][p.y]-1 ; i++) {
    					idx += dx[j];
    					idy += dy[j];
    					if(idx >=0 && idy >= 0 && idx < H && idy < W && !check[idx][idy] && wall[idx][idy] > 0) {
    						q.add(new Point(idx,idy));
    					}
    				}
    			}
    			// 부서짐
    			wall[p.x][p.y] = 0;
    		}
    	}
    	
    	// 벽 새로 세우기
    	for(int i = 0; i< W; i++) {
    		for(int j = H-1 ; j>= 0; j--) {
    			int y = j;
    			if(wall[j][i] == 0) {
    				while(--y >= 0) {
    					if(wall[y][i] > 0) {
    						wall[j][i] = wall[y][i];
    						wall[y][i] = 0;
    						break;
    					}
    				}
    				if(y == -1) break;
    			}
    		}
    	}
    }
        
}