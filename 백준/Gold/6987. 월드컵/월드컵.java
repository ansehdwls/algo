import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Point robot;
	static int num[][];
	static int temp[][];
	static int teamA[] = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int teamB[] = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static List<String> l = new ArrayList<String>();
	static List<Integer> s = new ArrayList<Integer>();
	static char oper[] = { '+', '-', ' ' };
	static boolean isImpos = false;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		for (int t = 0; t < 4; t++) {
			num = new int[6][3];
			temp = new int[6][3];
			isImpos = false;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 6; i++) {
				num[i][0] = Integer.parseInt(st.nextToken());
				num[i][1] = Integer.parseInt(st.nextToken());
				num[i][2] = Integer.parseInt(st.nextToken());
				if(num[i][0] + num[i][1]+ num[i][2] != 5) isImpos = true;
			}
			if(!isImpos) {
				isImpos = true;
				go(0);
			}
			if(isImpos) System.out.print(0+ " ");
			else System.out.print(1+ " ");
		}
	}

	static void go(int idx) {
		if(idx == 15) {
			isImpos = false;
			return;
		}
		else {
			if(num[teamA[idx]][0] > 0 && num[teamB[idx]][2] > 0) {
				num[teamA[idx]][0]--;
				num[teamB[idx]][2]--;
				go(idx+1);
				num[teamA[idx]][0]++;
				num[teamB[idx]][2]++;
			}
			if(num[teamA[idx]][1] > 0 && num[teamB[idx]][1] > 0) {
				num[teamA[idx]][1]--;
				num[teamB[idx]][1]--;
				go(idx+1);
				num[teamA[idx]][1]++;
				num[teamB[idx]][1]++;
			}
			
			if(num[teamA[idx]][2] > 0 && num[teamB[idx]][0] > 0) {
				num[teamA[idx]][2]--;
				num[teamB[idx]][0]--;
				go(idx+1);
				num[teamA[idx]][2]++;
				num[teamB[idx]][0]++;
			}
		}
	}
}