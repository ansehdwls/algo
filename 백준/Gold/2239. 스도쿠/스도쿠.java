import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N;
	static int M;
	static int bd[][];
	static boolean c_row[][] = new boolean[9][10];
	static boolean c_col[][] = new boolean[9][10];
	static boolean s_chk[][][] = new boolean[3][3][10];
	static List<int[][]> q = new ArrayList<int[][]>();
	static List<Point> l = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		bd = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				bd[i][j] = Integer.parseInt(s.charAt(j) + "");

				if (bd[i][j] != 0) {
					c_row[i][bd[i][j]] = true;
					c_col[j][bd[i][j]] = true;
					s_chk[i / 3][j / 3][bd[i][j]] = true;
				} else
					l.add(new Point(i, j));
			}
		}
		go(0);
	}

	public static void go(int idx) {
		if (idx >= l.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(bd[i][j]);
				}
				System.out.println();
			}
			System.exit(0);

			return;
		} else {

			for (int j = 1; j < 10; j++) {
				if (!c_row[l.get(idx).x][j] && !c_col[l.get(idx).y][j]
						&& !s_chk[l.get(idx).x / 3][l.get(idx).y / 3][j]) {
					bd[l.get(idx).x][l.get(idx).y] = j;
					c_row[l.get(idx).x][j] = true;
					c_col[l.get(idx).y][j] = true;
					s_chk[l.get(idx).x / 3][l.get(idx).y / 3][j] = true;
					go(idx + 1);
					c_row[l.get(idx).x][j] = false;
					c_col[l.get(idx).y][j] = false;
					s_chk[l.get(idx).x / 3][l.get(idx).y / 3][j] = false;
					bd[l.get(idx).x][l.get(idx).y] = 0;
				}
			}
		}
	}
}
