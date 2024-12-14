import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static int N;

	static int S;
	
	static int num[];
	static Map<Integer, Integer> count = new HashMap<>();
	static StringTokenizer st;
    static long ans = 0;
	static Queue q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	
		
        int m = N / 2;
        left(0, 0, m);
        right(0, m, N);
        if (S == 0) ans -= 1;

        System.out.println(ans);
		
	}
	
	public static void left(int sum, int current, int end) {
        if (current == end) {
        	count.put(sum, count.getOrDefault(sum, 0) + 1);
            return;
        }
        left(sum, current + 1, end);
        left(sum +num[current], current + 1, end);
    }

    public static void right(int sum, int current, int end) {
        if (current == end) {
           
            if (count.containsKey(S - sum)) {
                ans += count.get(S - sum);
            }
            
            else if (sum == S) {
                ans += 1;
            }
            return;
        }
        right(sum, current + 1, end);
        right(sum + num[current], current + 1, end);
    }

}
