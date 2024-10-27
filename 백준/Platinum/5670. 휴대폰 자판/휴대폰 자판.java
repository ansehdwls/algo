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
	Map<Character, Integer> children;
	
	public Trie() {
		isValid = false;
		children = new HashMap<Character, Integer>();
	}
}

public class Main {
	static int T;
	static int N;
	static List<Trie> trie;
	static StringTokenizer st;
	static double length;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String size;
		while((size = br.readLine()) != null){
			N = Integer.parseInt(size);
			trie = new ArrayList<Trie>();
			
			init();
			String s[] = new String[N];
			for(int i = 0 ; i < N; i++) {
				
				s[i] = br.readLine();
				add(0,s[i],0);
			}
			length = 0;
			for(int i = 0 ; i < N; i++) {
				
				length += search(0,s[i],0);
			}
			System.out.printf("%.2f\n",length / (double) N);
		}

	}

	static int init() {
		Trie temp = new Trie();
		trie.add(temp);
		
		return trie.size()-1;
	}
	
	static void add(int node, String s, int index) {
		if(s.length() == index) {
			trie.get(node).isValid = true;
			return ;
		}
		
		if(!trie.get(node).children.containsKey(s.charAt(index))) {
			trie.get(node).children.put(s.charAt(index),init());
		}
		
		add(trie.get(node).children.get(s.charAt(index)), s, index+1);
		
	}
	
	static int search(int node, String s, int index) {
		if(index == s.length()) {
			return 0;
		}
		if(trie.get(node).children.size() > 1) {
			return search(trie.get(node).children.get(s.charAt(index)), s, index+1) + 1;
		}
		if(trie.get(node).isValid) {
			return search(trie.get(node).children.get(s.charAt(index)), s, index+1) + 1;
		}
		if(node == 0) return search(trie.get(node).children.get(s.charAt(index)), s, index+1) + 1;
		return search(trie.get(node).children.get(s.charAt(index)), s, index+1);
	}
}
