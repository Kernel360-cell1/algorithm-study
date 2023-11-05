package yoonseon.lee;

import java.util.HashSet;
import java.util.Iterator;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class PGS_소수찾기 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("17"));
	}

	static class Solution {
		HashSet<Integer> numberSet = new HashSet<>();
		public int solution(String numbers) {
			int answer = 0;

			// 1. 모든 조합의 숫자를 만든다.
			recusive("", numbers);

			// 2. 소수의 개수를 센다.
			Iterator<Integer> it = numberSet.iterator();
			while (it.hasNext()) {
				int number = it.next();
				if (isPrime(number)) {
					answer++;
				}
			}

			// 3. 소수의 개수를 반환한다.
			return answer;
		}

		private boolean isPrime(int number) {
			// 1. 0과 1은 소수가 아니다.
			if (number < 2)
				return false;

			// 2부터 제곱근까지의 숫자로 나눠보며 소수 여부를 판별한다.
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0)
					return false;
			}

			return true;
		}

		private void recusive(String combination, String others) { // combination: 조합한 문자 , others: 아직 조합하지 않은 문자
			if (!"".equals(combination)) { // 처음에는 빈 문자열이기 때문에 넘어감.
				// 1.현재 조합을 set에 추가한다.
				numberSet.add(Integer.valueOf(combination));
			}
			// 2.남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
			for (int i=0; i<others.length(); i++) {
				recusive(combination + others.charAt(i), // others i번째 문자 뽑아와서 여태까지 만든 combination에 더함
					others.substring(0, i) + others.substring(i+1)); // others i번째 문자를 뽑았으니 i번째 문자를 제거해준다.
			}
		}

	}
}
