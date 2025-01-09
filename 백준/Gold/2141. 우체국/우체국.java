import java.util.*;
import java.awt.Point;
import java.io.*;

class Village implements Comparable<Village>{

	
	int x ;
	int y ;
	
	public Village(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Village o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}

class Main {
    static int N, M;
    
    static Village[] X; 
    
    static long sum = 0;
    static Queue<Point> q = new LinkedList<Point>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = new Village[N]; 
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = new Village(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sum += X[i].y;
        }

        Arrays.sort(X);

    	long mSum = 0;
    	for(int i=0 ; i<N ; i++) {
    		mSum += X[i].y;
    		if( ( (sum + 1) / 2 <= mSum )) {
    			System.out.println(X[i].x);
    			break;
    		}
    	}
    	
    }

}
