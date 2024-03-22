import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


class Island implements Comparable<Island>{
	// 연결할 두 정점
	int start;
	int finish;
	
	// 거리 제곱
	double powDistance;
	
	public Island(int start,int finish, double powDistance) {
		this.start = start;
		this.finish = finish;
		this.powDistance = powDistance;
	}
	
	@Override
	public int compareTo(Island o) {
		
		return (int)( this.powDistance - o.powDistance);
	}
	
	
}
public class Solution {
	static int N;
	static int p[];
	static long landx[];
	static long landy[];
	static double rat;
	static List<Island> l;
	static double sum;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			// p 배열 초기화
			p = new int [N+1];
			for(int i = 1 ; i< N+1; i++) {
				p[i] = i;
			}
			
			landx = new long[N+1];
			landy = new long[N+1];
			l = new ArrayList<Island>();
			// x 좌표 먼저 받기
			for(int i = 1 ; i < N+1 ; i++) {
				landx[i] = sc.nextLong();
			}
			// y 좌표 받기
			for(int i = 1 ; i < N+1 ; i++) {
				landy[i] = sc.nextLong();
			}
			
			// 연결할 수 있는 곳 모두 넣기
			for(int i = 1 ; i < N+1 ; i++) {
				for(int j = i+1 ; j < N+1 ; j++) {
					l.add(new Island(i,j, Math.pow(Math.abs(landx[i] - landx[j]), 2) + Math.pow(Math.abs(landy[i] - landy[j]), 2)));
				}
			}
			
			// 거리순으로 정렬
			Collections.sort(l);
			
			rat = sc.nextDouble();
			
			// num : 연결 선 개수 , i : 인덱스 ,sum : 각 거리의 제곱 합
			int num = 0;
			int i = 0;
			sum = 0;
			
			// 크루스칼, 최소 거리부터 검색
			while(num != N-1) {
				// 연결할 정점이 이미 같은 그룹이 아니어야 연결 x
				if( find(l.get(i).start) != find(l.get(i).finish) ) {
					sum += l.get(i).powDistance;
					
					// 연결했으면 같은 그룹
					union(l.get(i).start, l.get(i).finish);
					num++;
				}
				i++;
			}
			System.out.print("#"+t+ " ");
			System.out.printf("%.0f",sum*rat);
			System.out.println();
		}
		
	}
	
	static void union(int x,int y) {
		p[find(y)] = find(x);
	}
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}
}
