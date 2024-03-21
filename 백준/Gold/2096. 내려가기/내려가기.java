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
	static int num[];
	static int dnum[];
	static int maxNum[];
	static int minNum[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[3];
		dnum = new int[3];
		maxNum = new int[3];
		minNum= new int[3];
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < 3 ; j++) {
			maxNum[j] = Integer.parseInt(st.nextToken());
			minNum[j] = maxNum[j];
		}
		
		
		for(int i = 1 ; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				num[j] = Integer.parseInt(st.nextToken());
				dnum[j] = num[j];
			}
			
			num[0] += Math.max(maxNum[0], maxNum[1]);
			num[2] += Math.max(maxNum[1], maxNum[2]);

			dnum[0] += Math.min(minNum[0], minNum[1]);
			dnum[2] += Math.min(minNum[1], minNum[2]);
			
			
			num[1] += Math.max(maxNum[1], Math.max(maxNum[0], maxNum[2]));
			dnum[1] += Math.min(minNum[1], Math.min(minNum[0], minNum[2]));
			
			maxNum[0] = num[0];
			maxNum[1] = num[1];
			maxNum[2] = num[2];
			minNum[0] = dnum[0];
			minNum[1] = dnum[1];
			minNum[2] = dnum[2];
		}

		
		int max = 0;
		int min = 999999;
		for(int j = 0 ; j < 3 ; j++) {
			max = Math.max(max, maxNum[j]);
			min = Math.min(min, minNum[j]);
		}
		
//		
		System.out.println(max+ " " +min);
		
	}
}
