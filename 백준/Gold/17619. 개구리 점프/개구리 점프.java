import java.util.*;
import java.awt.Point;
import java.io.*;

class Log implements Comparable<Log> {
    int num, x1, x2, y;

    public Log(int num, int x1, int x2, int y) {
    	this.num = num;
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

	@Override
	public int compareTo(Log o) {
		// TODO Auto-generated method stub
		return this.x1 - o.x1;
	}
}
class Main {
    static int N, Q;

    static int [] p;
    static Log[] logs;
    
    static long sum = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        
        logs = new Log[N + 1];
        p = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        logs[0] = new Log(0, -1, -1, -1);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            logs[i] = new Log(i, x1, x2, y);
        }
        
        Arrays.sort(logs);
        
        for (int i = 1; i < N; i++) {
        	     	
        	for (int j = i + 1; j <= N; j++) {
        		
        		
        		if (find(logs[i].num) != find(logs[j].num)) {
        			
                    if (logs[i].x2 < logs[j].x1) break;
                    else {
                    	if(logs[i].y != logs[j].y) union(logs[i].num, logs[j].num);
                    }
                    
        		}
            }
        }
//        for(int i = 1 ; i <= N ; i++) {
//        	System.out.println(logs[i].num);
//        }
//        System.out.println();
//        for(int i = 1 ; i <= N ; i++) {
//        	System.out.println(find(logs[i].num));
//        }
        
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
        
    }
    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]); 
    }

    static void union(int x, int y) {
        p[find(y)] = find(x);
    }
}
