import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int day[] = new int[N];
		int pay[] = new int[N];

		int sum[] = new int[N];

		for (int i = 0; i < N; i++) {
			day[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		if (day[N - 1] == 1)
			sum[N - 1] = pay[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (i + day[i] > N)
				sum[i] = sum[i + 1];
			else if(i + day[i] == N) {
				sum[i] = Math.max(pay[i], sum[i + 1]);
			}
			else {
				sum[i] = Math.max(pay[i] + sum[i + day[i]], sum[i + 1]);
			}
			
		}
		
		System.out.println(sum[0]);

	}

}