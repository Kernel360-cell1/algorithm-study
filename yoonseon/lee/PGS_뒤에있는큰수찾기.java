package yoonseon.lee;

import java.util.Arrays;
import java.util.Stack;

public class PGS_뒤에있는큰수찾기 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {9,1,5,3,6,2};
		Arrays.stream(s.solution(numbers)).forEach(System.out::println);

	}
	private static class Solution {
		public int[] solution(int[] numbers) {
			int[] answer = new int[numbers.length];
			Arrays.fill(answer, -1);
			Stack<Integer> stack = new Stack<>();
			for (int i=0; i<numbers.length; i++) {
				while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
					int index = stack.pop();
					answer[index] = numbers[i];
				}
				stack.push(i);
			}

			return answer;
		}
	}
}
