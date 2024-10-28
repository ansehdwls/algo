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
	
	class Trie{
		
		boolean isValid;
		Map<Integer, Integer> children;
		
		public Trie() {
			this.isValid = false;
			this.children = new HashMap<Integer, Integer>();
		}
	}
	
	public class Main {
	
		static int N;
		static int M;
		
		static String[] s;
		static StringTokenizer st;
		
		static List<Trie> trie;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			trie = new ArrayList<Trie>();
			init();
			for(int i = 0 ; i< N; i++) {
				// 집합을 넣자!
				add(0,br.readLine(),0);
			}
			int count = 0;
			for(int i = 0 ; i < M ; i++) {
				// 검사를 하자!
				if(check(0,br.readLine(), 0)) count++;
				
			}
			System.out.println(count);
		}
		static int init() {
			Trie temp = new Trie();
			
			trie.add(temp);
			
			return trie.size()-1;
		}
		static boolean add(int node, String s, int index) 
		{
			if(s.length() == index) {
				trie.get(node).isValid = true;
				return true;
			}
			
			// 문자열이 없다면 추가
			if(!trie.get(node).children.containsKey(s.charAt(index) - 'a')) {
				trie.get(node).children.put(s.charAt(index) - 'a', init());
			}
			
			return add(trie.get(node).children.get(s.charAt(index) - 'a'), s, index+1);
		}
		
		static boolean check(int node, String s, int index) 
		{
			if(s.length() == index) {
				if(trie.get(node).isValid) return true;
				else return false;
			}
			
			if(!trie.get(node).children.containsKey(s.charAt(index) - 'a')) {
				return false;
			}
			
			return check(trie.get(node).children.get(s.charAt(index) - 'a'), s, index+1);
		}
	}
