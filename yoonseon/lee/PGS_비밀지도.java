package yoonseon.lee;

public class PGS_비밀지도 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		String[] solution = s.solution(n, arr1, arr2);
		for (String str : solution) {
			System.out.println(str);
		}
	}

	static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
			String format = "%"+n+"s";
			for (int i=0; i<n; i++) {
				answer[i] = String.format(format, Integer.toBinaryString(arr1[i] | arr2[i]))
					.replace("1","#").replace("0"," ");
			}
			return answer;
		}
	}
}
