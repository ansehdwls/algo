import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int num[];
	static int sum = 0;
	static int level = 0;
	static Queue<Integer> robot = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int [2*N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 2*N; i++) {
			num[i]  =  Integer.parseInt(st.nextToken());
			if(num[i] == 0 ) sum++;
		}
		
		int start = 0;
		int finish = N-1;
		int res = 2*N;
		while(sum < K) {
			
			level++;
			
			// 1. 컨베이어 벨트와 로봇이 돌아감 
			start = start-1 ;
			finish = finish -1 ;
			if( start < 0 ) start = 2*N -1;
			if(finish < 0) finish = 2*N -1;
			
			// 2. 로봇 이동
			int r_size = robot.size();
			for(int i = 0 ; i < r_size; i++ ) {
				int a = robot.poll();
				if(a == finish) continue;
				else {
						a = (a+1)%res;
						if(num[a] > 0 && !robot.contains(a)) {
							num[a]--;
							if(num[a] == 0 ) sum++;
							if(a != finish) robot.add(a);
						}
						else {
							if(a-1 < 0 ) robot.add(2*N -1);
							else robot.add( (a-1) );
						}
					}
			}
			// 3 로봇 올리기
			if(num[start] > 0 && !robot.contains(start) ) {
				num[start]--;
				if(num[start] == 0) sum++;
				robot.add(start);
			}

			
		}
		System.out.println(level);
		
	}


}