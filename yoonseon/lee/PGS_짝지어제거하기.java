package yoonseon.lee;

import java.util.Stack;

public class PGS_짝지어제거하기 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("xsxs"));
	}

	public static class Solution {
		public int solution(String s) {
			Stack<Character> stack = new Stack<>();

			for (char c : s.toCharArray()) {
				if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}

			return stack.size() == 0 ? 1 : 0;
		}
	}
}
