import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int max;
	
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				pStar(i,j,N);
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void pStar(int i, int j,int n) throws IOException {
		if(n == 1 ) bw.write("*");
	    else if ((i / (n/3)) % 3 == 1 && (j / (n/3)) % 3 == 1){
	        bw.write(" ");
	    }
	    else pStar(i,j,n/3);
	}
	
}
