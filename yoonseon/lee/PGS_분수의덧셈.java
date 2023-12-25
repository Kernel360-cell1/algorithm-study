package yoonseon.lee;

public class PGS_분수의덧셈 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] solution = s.solution(1, 2, 3, 4);
		System.out.println("solution[0] = " + solution[0]);
		System.out.println("solution[1] = " + solution[1]);
	}
	static class Solution {
		public int[] solution(int numer1, int denom1, int numer2, int denom2) {
			int numer = (numer1 * denom2) + (numer2 * denom1);
			int denom = denom1 * denom2;

			int max = gcd(numer, denom);

			return new int[] {numer/max, denom/max};
		}

		public int gcd(int a, int b) {
			if (b == 0) return a;
			return gcd(b, a % b);
		}
	}
}
