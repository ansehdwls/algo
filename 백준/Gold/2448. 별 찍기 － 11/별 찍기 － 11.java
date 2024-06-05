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
	static char star[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		star = new char[N][2*N];
		for(int i = 0 ; i< N; i++) Arrays.fill(star[i], ' ');

		// 시작 정점 찍기
		printStarPoint(0,N-1,N);

		for(int i = 0 ; i< N; i++) {
			for(int j = 0 ; j < 2*N; j++) {
				bw.write(star[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void printStarPoint(int x, int y, int N) {
		if(N == 3) {
			printStar(x,y);
			return;
		}
		printStarPoint(x,y,N/2);
		printStarPoint(x+N/2,y-N/2,N/2);
		printStarPoint(x+N/2,y+N/2,N/2);
	}
	static void printStar(int x, int y) {
		star[x][y] = '*';
		star[x+1][y-1] = '*';
		star[x+1][y+1] = '*';
		star[x+2][y-2] = '*';
		star[x+2][y-1] = '*';
		star[x+2][y] = '*';
		star[x+2][y+1] = '*';
		star[x+2][y+2] = '*';
	}

}
