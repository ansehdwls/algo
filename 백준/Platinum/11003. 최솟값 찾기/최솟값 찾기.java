import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class A implements Comparable<A> {
	int num;
	int idx;

	public A(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}

	@Override
	public int compareTo(A o) {

		return this.num - o.num;
	}

}

public class Main {
	static int N;
	static int L;
	// pop() O(1)
	static Deque<A> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		q = new LinkedList<A>();
		q.add(new A(Integer.parseInt(st.nextToken()), 1));
		StringBuilder sb = new StringBuilder();
		sb.append(q.getFirst().num + " ");
		for (int i = 2; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 마지막 값이 num 보다 크다면 최소값은 항상 num
			while(!q.isEmpty() && q.getLast().num > num) {
				q.removeLast();
			}
			q.add(new A(num,i));
			
			while(q.getFirst().idx <= i - L) {
				q.removeFirst();
			}

			sb.append(q.getFirst().num + " ");

		}
		System.out.println(sb);

	}

}