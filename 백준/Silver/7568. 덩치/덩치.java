import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Human{
	int key;
	int mom;
	int lev = 1;
	public Human(int key, int mom){
		this.key = key;
		this.mom = mom;
	}

}

public class Main {
	static int N, M, K;
	static Human man[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		man = new Human[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			man[i] = new Human(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(i != j) {
					if(man[i].key < man[j].key && man[i].mom < man[j].mom) man[i].lev++;
				}
			}
		}
		for(int i = 0 ; i < N; i++) {
			System.out.println(man[i].lev);
		}
	}

}
