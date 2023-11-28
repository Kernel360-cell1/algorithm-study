package yoonseon.lee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS_전화번호목록 {
	/**
	 * 1) Sort후 순회
	 */
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for (int i=0; i<phone_book.length-1; i++) {
			if (phone_book[i+1].startsWith(phone_book[i])) answer = false;
		}
		return answer;
	}

	/**
	 * 2) 해시 사용
	 */
	public boolean solution2(String[] phone_book) {
		boolean answer = true;
		Map<String, String> map = new HashMap<>();
		for (String s : phone_book) {
			map.put(s,s);
		}

		for (int i=0; i<phone_book.length; i++) {
			for (int j=0; j<phone_book[i].length(); j++) {
				if (map.containsKey(phone_book[i].substring(0,j))) answer = false;
			}
		}
		return answer;
	}
}
