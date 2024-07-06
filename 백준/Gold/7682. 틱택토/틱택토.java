import java.io.*;

public class Main {
    static int ttt[][] = { {0 ,0 ,0},{0 ,0 ,0},{0 ,0 ,0}};
    static String cmd;
    static int zero;
    static int one;
    static int two;
    static boolean win[] = {false, false};
    static int connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            cmd = br.readLine();
            // 입력 끝
            if(cmd.equals("end")) break;

            // 초기화
            zero = 0;
            one = 0;
            two = 0;
            win[0] = false;
            win[1] = false;

            for(int i = 0 ; i < 9; i++){
                if(cmd.charAt(i) == '.'){
                    ttt[i/3][i%3] = 0;
                    zero++;
                }
                else if(cmd.charAt(i) == 'X'){
                    ttt[i/3][i%3] = 1;
                    one++;
                }
                else {
                    ttt[i / 3][i % 3] = 2;
                    two++;
                }
            }

            // 만약 개수가 맞지 않으면 invalid ( X의 개수 = O의 개수 or 0의 개수 + 1 )
            if(one == two || one == two+1){

                // 불가능한 경우
                // 1. X, O 모두 이긴경우
                // 2. 승자가 없는데 .이 남아있는 경우
                // 3. O가 이겼는데 X를 한번더 둔 경우 or X가 이겼을때 O를 한번 더 둔 경우
                win[0] = isWin(1);
                win[1] = isWin(2);
                if(win[0] && win[1]) bw.write("invalid\n");
                else if(win[0]){
                    if(one > two) bw.write("valid\n");
                    else bw.write("invalid\n");
                }
                else if(win[1]){
                    if(one == two) bw.write("valid\n");
                    else bw.write("invalid\n");
                }
                else{
                    if(zero > 0) bw.write("invalid\n");
                    else bw.write("valid\n");
                }
            }
            else bw.write("invalid\n");


        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isWin(int t){

        connect = 0;

        // 가로 3
        for(int i = 0 ; i< 3; i++){
            for(int j = 0 ; j < 3; j++){
                if(ttt[i][j] == t) connect++;
            }
            if(connect == 3) {
                return true;
            }
            connect = 0;
        }

        // 세로 3
        for(int j = 0 ; j< 3; j++){
            for(int i = 0 ; i < 3; i++){
                if(ttt[i][j] == t) connect++;
            }
            if(connect == 3) {
                return true;
            }
            connect = 0;
        }

        // 대각선
        for(int i = 0 ; i < 3; i++){
            if(ttt[i][i] == t) connect++;
        }
        if(connect == 3) {
            return true;
        }
        connect = 0;

        for(int i = 0 ; i < 3; i++){
            if(ttt[2-i][i] == t) connect++;
        }
        if(connect == 3) {
            return true;
        }
        connect = 0;

        return false;
    }
}