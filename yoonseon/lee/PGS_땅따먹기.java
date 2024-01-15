package yoonseon.lee;

public class PGS_땅따먹기 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] land = {{1, 1, 3, 1}, {2, 3, 2, 2}, {1, 4, 1, 1}};
		System.out.println(s.solution(land));
	}
	static class Solution {
		public int solution(int[][] land) {
			int answer = 0;

			for (int i=1; i<land.length; i++) {
				for (int j = 0; j < 4; j++) {
					int maxValue = 0;
					for (int k = 0; k < 4; k++) {
						if (j != k) {
							maxValue = Math.max(maxValue, land[i-1][k]);
						}
					}
					land[i][j] += maxValue;
				}
			}

			for (int i : land[land.length-1]) {
				answer = Math.max(i, answer);
			}

			return answer;
		}
	}
}
