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
	// N: 벨트의 길이, K: 내구도가 0인 칸의 갯수
	static int N, M;
	static Point robot;
	static int num[];
	static List<String> l = new ArrayList<String>();
	static List<Integer> s = new ArrayList<Integer>();
	static char oper[] = { '+', '-', ' ' };
	static int sum = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			M = Integer.parseInt(br.readLine());
			num = new int[M];
			for (int j = 1; j <= M; j++)
				num[j - 1] = j;
			s.add(num[0]);
			go(1);
			s.remove(s.size() - 1);
			System.out.println();
		}
	}

	static void go(int idx) {
		if (idx == M) {
			int sum = s.get(0);
			int d = 1;
			for(int i = 0 ; i <l.size(); i++) {
				if(l.get(i).equals("+")) {
					sum += s.get(d++);
				}
				else if(l.get(i).equals("-")) {
					sum -= s.get(d++);
				}
			}
			if (sum == 0) {
				System.out.print(num[0]);
				for (int i = 0; i < l.size(); i++)
					System.out.print(l.get(i)+num[i+1]);
				System.out.println();
			}
			return;
		} else {
			l.add(" ");
			int pre = s.get(s.size() - 1);
			s.add(pre * 10 + num[idx]);
			s.remove(s.size() - 2);
			go(idx + 1);
			l.remove(l.size() - 1);
			s.remove(s.size() - 1);
			s.add(pre);

			l.add("+");
			s.add(num[idx]);
			go(idx + 1);
			l.remove(l.size() - 1);
			s.remove(s.size() - 1);
			
			
			l.add("-");
			s.add(num[idx]);
			go(idx + 1);
			l.remove(l.size() - 1);
			s.remove(s.size() - 1);
		}
	}

}