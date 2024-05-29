import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
	
	public class Main {
		
		static int N;
		static int mid;
		static int temp;
		static StringTokenizer st;
		static String s;
		static PriorityQueue<Integer> upq = new PriorityQueue<Integer>(Collections.reverseOrder());
		static PriorityQueue<Integer> dwq = new PriorityQueue<Integer>();
		
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			N = Integer.parseInt(br.readLine());
			mid = Integer.parseInt(br.readLine());
			bw.write(mid+"\n");
			
			for(int i = 1 ; i< N; i++) {
				temp = Integer.parseInt(br.readLine());
				// 중간값보다 크면 오름차순 큐
				// 중간값보다 작으면 내림차순 큐
				if(mid < temp) dwq.add(temp);
				else upq.add(temp);
				
				// 중간 값이라면 출력
				if(upq.size() == dwq.size() || dwq.size()-1 == upq.size()) bw.write(mid+"\n");
				else if(upq.size() > dwq.size()) {
					dwq.add(mid);
					mid = upq.poll();
					bw.write(mid+"\n");
				}
				else {
					upq.add(mid);
					mid = dwq.poll();
					bw.write(mid+"\n");
				}
			}
			
			bw.flush();
			bw.close();
			br.close();
		}
	}
