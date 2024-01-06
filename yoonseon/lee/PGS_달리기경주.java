package yoonseon.lee;

import java.util.Arrays;
import java.util.HashMap;

public class PGS_달리기경주 {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		String[] answer = s.solution(players, callings);
		Arrays.stream(answer).forEach(System.out::println);
	}

	static class Solution {
		public String[] solution(String[] players, String[] callings) {
			HashMap<String, Integer> map = new HashMap<>();
			for (int i=0; i<players.length; i++) {
				map.put(players[i], i);
			}

			for (String player : callings) {
				int rank = map.get(player);
				String aheadPlayer = players[rank-1];
				players[rank-1] = players[rank];
				players[rank] = aheadPlayer;

				map.put(player, rank-1);
				map.put(aheadPlayer, rank);
			}

			return players;
		}
	}
}
