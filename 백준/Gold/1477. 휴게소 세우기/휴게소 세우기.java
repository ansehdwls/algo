import java.awt.Point;
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
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M, L;
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		// 시작점 끝점
		list.add(0);
		list.add(L);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		int l = 1;
		int r = list.get(list.size()-1);
		int mid;
		// 이분 탐색 시작
		// 최소 길이 일때 M개 되어야 함.
		while(l <= r) {
			int m = 0;
			mid = (l +r) / 2;
			for(int i = 1; i < list.size(); i++) {
				m += (list.get(i) - list.get(i-1) -1)/mid;
			}
//			System.out.println(m);
			// 길이를 더 줄인다.
			if(m <= M) {
				r = mid-1;
			}
			else l = mid+1;
			
//			System.out.println(l +" " + r);
		}
		System.out.println(l);
		
	}
}
