import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Nasa {
	int head;
	int tail;
	public Nasa(int head, int tail)
	{
		this.head = head;
		this.tail = tail;
	}


}

public class Solution {
	static int N;
	static int num[][];
	static boolean check[][];
	static StringTokenizer st;
	static Queue<Nasa> q;
	static LinkedList<Nasa> res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			q = new LinkedList<Nasa>();
			res = new LinkedList<Nasa>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i++) {
				q.add(new Nasa(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}

			Nasa temp = q.poll();
			int head = temp.head;
			int tail = temp.tail;
			res.add(temp);
			
			while(!q.isEmpty()) {
				temp = q.poll();
				if(tail == temp.head) {
					res.add(temp);
					tail = temp.tail;
				}
				else if(head == temp.tail) {
					res.add(0, temp);
					head = temp.head;
				}
				else q.add(temp);
			}
			System.out.print("#"+t+" ");
			for(int i = 0 ; i < res.size(); i++) {
				System.out.print(res.get(i).head + " " + res.get(i).tail + " ");
			}
			System.out.println();
			
		}

	}
}
