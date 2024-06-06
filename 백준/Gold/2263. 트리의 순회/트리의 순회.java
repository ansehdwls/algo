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
	static int preorder[];
	static int inorder[];
	static int postorder[];
	static int indexing[];
	static StringTokenizer st;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		inorder = new int[N+1];
		postorder = new int[N+1];
		preorder = new int[N+1];
		indexing = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
				indexing[inorder[i]] = i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		printPreorder(1,N,1,N);
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void printPreorder(int is ,int ie, int ps, int pe) {
		
		if(ie < is || pe < ps )return ;
		// postorder의 끝부분은 root이다
		System.out.print(postorder[pe] + " ");
		
		// 현재 루트의 인오더 기준 index 
		int idx = indexing[postorder[pe]];
		
		// 인오더의 왼쪽의 트리 부터 먼저 root 출력
		printPreorder(is, idx-1, ps, ps + idx - is - 1);
		printPreorder(idx+1, ie, ps + idx - is, pe - 1);
	}
}
