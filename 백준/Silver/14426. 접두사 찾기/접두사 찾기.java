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

class Trie{
	boolean isValid;
	Map<Integer, Integer> children;
	
	public Trie() {
		isValid = false;
		children = new HashMap<Integer, Integer>();
	}
	
}

public class Main {

	static int N;
	static int M;
	static StringTokenizer st;
	static List<Trie> trie = new ArrayList<Trie>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init();
		
		for(int i = 0; i <N ; i++) {
			add(0,br.readLine(),0);
		}
		int count = 0;
		
		for(int i = 0 ; i < M ; i++) {
			if(search(0,br.readLine(),0)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	
	static void add(int node, String s, int index) {
		if(s.length() == index) {
			trie.get(node).isValid = true;
			return ;
		}
		
		if(!trie.get(node).children.containsKey(s.charAt(index)- 'a')) {
			trie.get(node).children.put(s.charAt(index)- 'a', init());
		}
		trie.get(node).isValid = true;
		add(trie.get(node).children.get(s.charAt(index)- 'a'), s, index+1);
	}
	
	static int init() {
		Trie temp = new Trie();
		trie.add(temp);
		
		return trie.size()-1;
		
	}
	static boolean search(int node, String s, int index) {
		if(s.length() == index) {
			return trie.get(node).isValid;
		}
		
		if(!trie.get(node).children.containsKey(s.charAt(index) - 'a')) return false;
		
		return search(trie.get(node).children.get(s.charAt(index) - 'a'), s,index+1);
	}
	
}
