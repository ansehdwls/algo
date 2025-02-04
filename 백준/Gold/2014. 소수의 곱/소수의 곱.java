import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
    static int N, K;

    static long num[];
    static PriorityQueue<Long> pq = new PriorityQueue<>();;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
     
        num = new long [K];
        
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K; i++) {	
        	num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for(int i = 0 ; i < K; i++) {	
        	pq.add(num[i]);
        }
        int sum = 0;
        for(int i = 1 ; i< N; i++) {
        	long temp = pq.poll();
        	
        	for(int j = 0; j < K; j++) {
        		
				pq.add(num[j] * temp);
				
				if(temp % num[j] == 0 )break;
        		
        	}
        	
        	
        }
        
        System.out.println(pq.poll());
    }

}
