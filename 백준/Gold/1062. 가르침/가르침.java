import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int max = 0;
	static String word[];
	static List<Character> l = new ArrayList<Character>();
	static List<Character> add = new ArrayList<Character>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		word = new String[N];

		// 남극의 언어는 이 단어로 시작 따라서 필수로 배워야 함.
		l.add('a');
		l.add('n');
		l.add('t');
		l.add('i');
		l.add('c');

		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
			// 배울 수 있는 알파벳
			for (int j = 0; j < word[i].length(); j++) {
				if (!l.contains(word[i].charAt(j)) && !add.contains(word[i].charAt(j)) && word[i].charAt(j) - 'a' >= 0
						&& word[i].charAt(j) - 'a' < 26) {
					add.add(word[i].charAt(j));
				}
			}
		}
		
		// 배워야하는 단어 보다 더배울 수 있다면 max값
		if (K >= add.size() + l.size()) {
			// 단어 중에 알파벳으로 이루어진 단어가 아니라면 못읽음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < word[i].length(); j++) {
					if (word[i].charAt(j) - 'a' < 0 || word[i].charAt(j) - 'a' >= 26) {
						N--;
					}
				}
			}
			
			max = N;	
		}
		else if(K <= 4) {
			// 필수단어 보다 적기 때문에 아무 단어도 못배움
			max = 0;
		}
		else
			go(5, 0);

		System.out.println(max);
	}

	static void go(int idx, int start) {
		// 배운단어가 K개 라면 단어 읽을 수 있는지 검사
		if (idx >= K) {
			int sum = 0;
			boolean isOk = true;
			for (int i = 0; i < N; i++) {
				isOk = true;
				for (int j = 0; j < word[i].length(); j++) {
					// 모르는 글자가 있다면 못읽음 그리고 알파벳이 아니라면 못읽음
					if (!l.contains(word[i].charAt(j))) {
						isOk = false;
						break;
					}
				}
				if (isOk)
					sum++;
			}
			max = Math.max(max, sum);
			return;
		} else {
			for (int i = start; i < add.size(); i++) {
				// 배울 수 있는 알파벳 읽기
				l.add(add.get(i));

				// 다음 단어 익히기
				go(idx + 1, i + 1);

				// 배우지 않았을 때로 돌아감
				l.remove(l.size() - 1);
			}
		}
	}
}
