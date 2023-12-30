import java.util.*;

public class PGS_조이스틱 {
	class Solution {
		int answer = Integer.MAX_VALUE;
		int[] moves;
		String endString;
		int[] dx = {-1, 1};

		public int solution(String name) {
			moves = new int[name.length()];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < name.length(); i++) {
				int now = (int) name.charAt(i % name.length()) - (int) 'A';
				sb.append('A');
				if (now != 0) {
					moves[i] = Math.min(Math.abs(now), 26 - Math.abs(now));
				}
			}

			endString = sb.toString();
			bfs(name, 0);

			return answer + sum();
		}

		private int sum() {
			return Arrays.stream(moves).sum();
		}

		class Node {
			StringBuilder name;
			int count;
			int index;
			int[] check;

			public Node(String s, int count, int index, int[] check) {
				this.name = new StringBuilder(s);
				this.count = count;
				this.index = index;
				this.check = check;
			}

			private void replace(int index) {
				this.name.replace(index, index + 1,  "A");
			}

			private void makeTrue(int index) {
				this.check[index]++;
			}
		}

		private void bfs(String now, int index) {
			LinkedList<Node> q = new LinkedList<>();
			q.add(new Node(now, 0, 0, new int[now.length()]));
			q.get(0).makeTrue(0);

			while (!q.isEmpty()) {
				Node cur = q.poll();
				cur.replace(cur.index);
				if (cur.name.toString().equals(endString)) {
					answer = Math.min(cur.count, answer);
					break;
				}
				for (int i = 0; i < 2; i++) {
					int nx = cur.index + dx[i];
					if (nx < 0) {
						nx = endString.length() - 1;
					} else if (nx >= endString.length()) {
						nx = 0;
					}
					if (cur.check[nx] <= 2) {
						cur.check[nx]++;
						q.add(new Node(cur.name.toString(), cur.count + 1, nx, Arrays.copyOf(cur.check, cur.check.length)));
					}
				}
			}
		}
	}
}
