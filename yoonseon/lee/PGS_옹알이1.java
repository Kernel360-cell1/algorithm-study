package yoonseon.lee;

import java.util.ArrayList;
import java.util.List;

public class PGS_옹알이1 {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		System.out.println(s.solution(babbling));
	}
	static class Solution {
		ArrayList<String> list = new ArrayList<>(List.of("aya", "ye", "woo", "ma"));
		public int solution(String[] babbling) {
			int answer = 0;
			for (String s : babbling) {
				for (String key : list) {
					while (s.contains(key)) {
						s = s.replace(key,".");
					}
				}
				if (s.replace(".","").length() == 0)
					answer++;
			}
			return answer;
		}
	}
}
