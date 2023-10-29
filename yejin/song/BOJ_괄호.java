package yejin.song;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_괄호 {
    // 첫 줄에서 입력 받은 수만큼 반복문 : 스택
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int s = in.nextInt();

        for(int i = 0; i<s;i++){
            System.out.println(solve(in.next()));
        }
    }

    public static String solve(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<s.length();i++){

            char c = s.charAt(i);

            if (c == '(') stack.push(c);
            else if (stack.empty()) return "NO";
            else stack.pop();
        }

        if(stack.empty()) return "YES";
        else return "NO";
    }
}
