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
	static int N, M;
	static int max= 0;
	// 집 list
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		// 받은 집 위치 설정
		Collections.sort(list);
		
		// 시작점
		int l = 0;
		int r = 1000000000;
		
		int mid = (l + r ) / 2;
		// 이분 탐색 시작
		// 공유기 사이 거리가 균열해야지 최소거리가 됨.
		// M개가 되도록 탐색.
		while(l <= r) {
			//  공유기 개수 첫번째 설치 기준
			int m = 1;
			int start = list.get(0);
			mid = (l + r ) / 2;
		
			// 항상 빼는게 아니다.
			// mid 길이보다 num이 작다면 다음 집에 공유기 설치
			for(int i = 1; i < list.size(); i++) {
				if( list.get(i) - start >=  mid ) {
					// 공유기 설치
					start = list.get(i);
					m++;
				}
			}
			// 더 설치가 된다.
			if(m < M) {
				r = mid-1;
			}
			// M개 혹은 N 개 설치가 된다.
			else {
				l = mid+1;
			}
		}
		System.out.println(r);
		
	}
}
