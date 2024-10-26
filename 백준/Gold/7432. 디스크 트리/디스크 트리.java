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

class Trie {
	boolean isValid;
	Map<String, Integer> children;
	String s;
	
	public Trie(String s) {
		this.s = s;
		isValid = false;
		children = new HashMap<String, Integer>();
	}
}

public class Main {
	static int N;
	static int K;
	static List<Trie> trie;
	static StringTokenizer st;
	
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		trie = new ArrayList<Trie>();
		
		init("");
		
		for(int i = 0 ; i < N; i++) {
							
			String s[] = br.readLine().split("\\\\");
			for(int j = 0 ; j < K ; j++) {
				s[j] = st.nextToken();
			}
			add(0,s,0);
		}
		check = new boolean[trie.size()];
		
		Map<String, Integer> sortedChildren = new TreeMap<>(trie.get(0).children);
		
		for (Integer child : sortedChildren.values()) {
		    search(child,"");
		}
	}

	static int init(String s) {
		Trie temp = new Trie(s);
		trie.add(temp);
		
		return trie.size()-1;
	}
	
	static void add(int node, String[] s, int index) {
		if(s.length == index) {
			trie.get(node).isValid = true;
			return ;
		}
		
		if(!trie.get(node).children.containsKey(s[index])) {
			trie.get(node).children.put(s[index],init(s[index]));
		}
		
		add(trie.get(node).children.get(s[index]), s, index+1);
		
	}
	
	static void search(int node, String tem) {
		System.out.println(tem + trie.get(node).s);
		
		Map<String, Integer> sortedChildren = new TreeMap<>(trie.get(node).children);
		
		for (Integer child : sortedChildren.values()) {
		    search(child, tem+" ");
		}
	}
}
