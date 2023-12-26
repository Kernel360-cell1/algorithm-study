package yoonseon.lee;

import java.util.Arrays;

import com.sun.tools.javac.Main;

public class PGS_조이스틱 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("JDKV")); // JEROEN
	}
	static class Solution {
		public int solution(String name) {
			// A : 65, Z : 90
			int answer = 0;
			int[] arr = name.chars()
				.map(i -> 26 - ('Z' - i))
				.toArray();
			int ci = arr[0];
			answer = arr[0]-1;
			for (int i=1; i<arr.length; i++) {
				answer += Math.min(
					Math.abs(ci-arr[i]),
						Math.min(
							1+arr[i], // 커서를 왼쪽 끝으로 이동 후
							1+26-arr[i]
						)
				);
				ci = arr[i];
			}
			System.out.println("ci = " + ci);
			System.out.println("answer = " + answer);
			return answer;
		}
	}
}
