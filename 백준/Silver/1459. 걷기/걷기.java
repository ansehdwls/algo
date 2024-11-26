import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static long X;
    static long Y;

    static long W;
    static long C;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 1칸이동
        long one  = W;

        // 2칸이동
        long two = Math.min(W+W, C+C);

        // 대각 이동
        long cross = Math.min(C, W+W);

        long min = 0;

        // 둘중 하나가 0이 될때까지 대각이동
        min += Math.min(X,Y)* cross;

        // 나머지 길이
        long len = ( Math.max(X,Y) - Math.min(X,Y) );

        min +=  (len/2) * two;
        min += (len%2) * one;

        System.out.println(min);

    }
}
