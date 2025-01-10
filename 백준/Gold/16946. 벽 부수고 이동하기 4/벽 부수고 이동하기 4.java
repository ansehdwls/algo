import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N, M;

    static int map[][];
    
    static int check[][];
    
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static Point temp ;
    static int idx;
    static int idy;
    static int num[] = new int[5000001];
    static Queue<Point> q;
    static List<Integer> l ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M];
    	check = new int[N][M];
        String s;
        for(int i = 0 ; i < N; i++) {
        	s = br.readLine();
        	for(int j = 0 ; j < M; j++) {
        		map[i][j] = s.charAt(j) - '0';
        	}
        }
        int groupId = 1;
        for(int i = 0 ; i < N; i++) {
        	for(int j = 0 ; j < M; j++) {
        		if(map[i][j] == 0 && check[i][j] == 0) bfs(i,j,groupId++);
        	}
        }
        
        for(int i = 0 ; i < N; i++) {
        	for(int j = 0 ; j < M; j++) {
        		if(map[i][j] == 0) System.out.print(0);
        		else {
        			System.out.print(counting(i,j));
        		}
        	}
        	System.out.println();
        }
    }

    static int counting(int x , int y) {
    	l = new ArrayList<Integer>();
    	
    	int count = 0;
    	
		for(int i = 0 ; i < 4; i++) {
			idx = dx[i] + x;
			idy = dy[i] + y;
			if(idx >= 0 && idy >= 0 && idx < N && idy < M) {
				if(check[idx][idy] != 0) {
					if(!l.contains(check[idx][idy])) {
						l.add(check[idx][idy]);
					}
				}
			}
		}
		
		for(int i = 0 ; i < l.size(); i++) {
			count += num[l.get(i)];
		}
		
		return (1 + count)%10;
		
    }
    
    static void bfs(int x, int y, int groupId) {
    	
    	if(check[x][y] != 0) return ;
    	
    	int count = 0;

    	check[x][y] = groupId;
    	
    	q = new LinkedList<Point>();
    	q.add(new Point(x,y));

    	while(!q.isEmpty()) {
    		
    		temp = q.poll();
    		count++;
    		for(int i = 0 ; i < 4; i++) {
    			idx = dx[i] + temp.x;
    			idy = dy[i] + temp.y;
    			if(idx >= 0 && idy >= 0 && idx < N && idy < M) {
    				if(check[idx][idy] == 0 && map[idx][idy] == 0) {
    					check[idx][idy] = groupId;
    					q.add(new Point(idx, idy));
    				}
    			}
    		}
    	}
    	
    	num[groupId] = count%10;
    }
}
