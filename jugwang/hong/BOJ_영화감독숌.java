package jugwang.hong;
import java.io.*;

public class BOJ_영화감독숌 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int number = 666;
        int cnt = 1;

        while (cnt != N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                cnt++;
            }
        }
        System.out.println(number);
    }
}
