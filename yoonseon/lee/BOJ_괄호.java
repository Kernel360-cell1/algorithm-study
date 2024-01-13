package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] arr = new String[T];
		for (int i=0; i<T; i++) {
			arr[i] = br.readLine();
		}

		for (String str : arr) {
			Stack<Character> stack = new Stack<>();
			String answer = "YES";
			char[] chars = str.toCharArray();
			for (char c : chars) {
				if ('(' == c) {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						answer = "NO";
						break;
					}
					stack.pop();
				}
			}
			if (!stack.isEmpty()) {
				answer = "NO";
			}
			System.out.println(answer);
		}
	}
}
