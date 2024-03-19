import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static int num[] = {1,2,3};
	static List<Integer> l = new ArrayList<Integer>();
	static String s = "";
	static String min = ""; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String temps = s;
		for(int i = 0 ; i < 3; i++) {
			s += num[i];
			go(1);
			s = temps;
		}
		br.close();

	}
	
	static void go(int idx) {
		if(idx == N) {
			System.out.println(s);
			System.exit(0);
			return ;
		}
		else {
			String temp = s;
			int size = s.length()+1;
			for(int i = 0 ; i < 3; i++) {
				s += num[i];
				int j = 1;
				boolean isNotGood = false;
				while(size - j*2 >= 0)
				{
					isNotGood = s.substring(size-j, size).equals(s.substring(size - j*2 , size -j));
					if(isNotGood) break;
					j++;
				}
				if(!isNotGood) go(idx+1);
				s = temp;
			}
		}
	}

}
