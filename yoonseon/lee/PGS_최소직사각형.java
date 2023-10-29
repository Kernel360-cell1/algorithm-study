package yoonseon.lee;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class PGS_최소직사각형 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution.solution(sizes));
	}

	static class Solution {
		public int solution(int[][] sizes) {
			int maximumWidth = 1, minimumHeight  = 1;
			for (int i=0; i<sizes.length; i++) {
				int width = Math.max(sizes[i][0], sizes[i][1]); // 가로 세로 길이 중 높은 것을 가로로 설정
				maximumWidth = Math.max(width, maximumWidth);
				int height = Math.min(sizes[i][0], sizes[i][1]); // 가로 세로 길이 중 낮은 것을 세로로 설정
				minimumHeight = Math.max(height, minimumHeight);
			}
			return maximumWidth * minimumHeight;
		}
	}
}
