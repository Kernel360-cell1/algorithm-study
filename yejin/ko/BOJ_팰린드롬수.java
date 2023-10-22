package yejin.ko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        // br 통해서 줄 별로 읽어오기
        // 맨 앞 , 맨 뒤 부터 돌아가면서 비교하기
        // 만약 같지 않다면 boolean 값 바꾸고 다음 줄로 넘어가기
        // 각 결과에 맞게 출력하기

        while (true){
            String palin_num = br.readLine();
            boolean palin = true; // 입력되는 수가 팰린드롬 수라고 가정함.
            if (palin_num.equals("0")) return;

            for (int i = 0; i<=palin_num.length()/2; i++){å
                if(palin_num.charAt(i)!=palin_num.charAt(palin_num.length()-i-1)) {
                    palin = false;
                    break;
                }
            }
            if (palin) out.println("yes");
            else out.println("no");
        }
    }
}
