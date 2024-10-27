import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Trie {
	boolean isValid;
	Map<Integer, Integer> child;
	
	public Trie(){	
		this.isValid = false;
		child = new HashMap<Integer, Integer>();
	}
	
}

public class Main {

	static int N;
	static int T;
	static String[] s;
	static StringTokenizer st;
	
	static List<Trie> trie;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 0 ; t < T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			s = new String[N];
			trie = new ArrayList<Trie>();
			
			for(int i = 0 ; i < N; i++) {
				s[i] = br.readLine();
			}
			
			Arrays.sort(s);
			
			boolean ans = true;
			init();
			
			for(int i = 0 ; i < N; i++) {
				if(!add(0,s[i],0)) {
					ans = false;
					break;
				}
			}
			
			if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	
	 static boolean add(int node, String number, int index) {
		 
		 // 문자열의 끝은 가능
		 if(index == number.length()) {
			
			 trie.get(node).isValid = true;
			 return true;
		 }

		 // 만약 이미 완성된 번호가 있으면 x
		 if(trie.get(node).isValid) return false;
		 
		 int nodeNum = 0;
		 
		 // 자식이 있다면 만들지 않음
		 if(!trie.get(node).child.containsKey(number.charAt(index) - '0')) {
			 nodeNum = init();
			 trie.get(node).child.put(number.charAt(index) - '0', nodeNum);
		 }
		 else {
			 nodeNum =  trie.get(node).child.get(number.charAt(index) - '0');
		 }
		 return add(nodeNum, number, index+1);
	}
	
	static int init() {
		Trie temp = new Trie();
		trie.add(temp);
		return trie.size()-1;
	}
}
