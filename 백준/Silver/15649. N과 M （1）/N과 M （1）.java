import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M;
	static boolean[] visit = new boolean[9];

	static List<Integer> v = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		go(0);

	}

	public static void go(int idx) {

		if (idx >= M) {
			for (int i = 0; i < v.size(); i++) {
				System.out.print(v.get(i) + " ");
			}
			System.out.println();
			return;
		}

		else {
			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					visit[i] = true;
					v.add(i);
					go(idx + 1);
					v.remove(v.size() - 1);
					visit[i] = false;
				}

			}
		}
	}

}