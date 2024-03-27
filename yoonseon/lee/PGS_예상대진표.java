package yoonseon.lee;

public class PGS_예상대진표 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(8, 4, 7));
	}

	public static class Solution {
		public int solution(int n, int a, int b) {
			int answer = 0;

			while (a != b) {
				a = (a + 1) / 2;
				b = (b + 1) / 2;
				answer++;
				/*
				if (a % 2 != 0) {
					a = a + 1;
				}
				a = a / 2;

				if (b % 2 != 0) {
					b = b + 1;
				}
				b = b / 2;

				answer++;
				*/
			}

			return answer;
		}
	}
}
