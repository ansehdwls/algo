import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int paper[][];
	static StringTokenizer st;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N+1][N+1];
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(!isOne(1,1, N, N)) {
			slice(1,1,N/2);
		}
		bw.write(white+"\n");
		bw.write(blue+"");
		bw.flush();
		bw.close();
		br.close();
	}
	static void slice(int x1, int y1,int len) {
		
		// 1사분면
		if(!isOne(x1,y1,x1+len-1, y1+len-1)) {
			slice(x1,y1,len/2);
		}
		// 2사분면
		if(!isOne(x1,y1+len,x1+len-1, y1+2*len-1)) {
			slice(x1,y1+len, len/2);
		}
		// 3사분면
		if(!isOne(x1+len,y1,x1 + 2*len-1, y1+len-1)) {
			slice(x1+len,y1,len/2);
		}
		// 4사분면
		if(!isOne(len+x1,len+y1,x1 + 2*len-1, y1+2*len-1)) {
			slice(len+x1,len+y1,len/2);
		}
	}
	
	static boolean isOne(int x1, int y1, int x2, int y2) {
		int type = paper[x1][y1];
		for(int i = x1 ; i <= x2; i++) {
			for(int j = y1 ; j <= y2; j++) {
				if(type != paper[i][j]) return false;
			}
		}
		if(type == 0) white++;
		else blue++;
		return true;
	}

}
