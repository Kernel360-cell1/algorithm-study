package jugwang.hong;

import java.io.*;
import java.util.*;

public class BOJ_균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // sout 로 해도 되지만 그냥 사용해봤습니다.

        // . 을 만나면 문장 종료로 break
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<String> stack = new Stack<>();

            // 한글자씩 분리
            String[] sentence = str.split("");
            for(String word : sentence){
                switch (word) {
                    case ("("):
                    case ("["):
                        stack.push(word);
                        break;
                    case (")"):
                        if(!stack.isEmpty() && stack.peek().equals("(")) // 스택이 비어있지 않고 맨위가 ( 일 때 pop
                            stack.pop();
                        else stack.push(")");
                        break;
                    case ("]"):
                        if(!stack.isEmpty() && stack.peek().equals("[")) // 스택이 비어있지 않고 맨위가 [ 일 때 pop
                            stack.pop();
                        else stack.push("]");
                        break;
                }
            }

            // sout 로 해도 상관없음
            if (stack.empty())
                bw.write("yes\n");
            else
                bw.write("no\n");

            bw.flush();
        }

    }
}
