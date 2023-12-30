import java.util.*;

public class PGS_과제진행하기 {
	class Solution {
		public String[] solution(String[][] plans) {
			ArrayList<String> answerList = new ArrayList<>();
			LinkedList<Assignment> assignments = new LinkedList<>();
			Assignment now = null;

			HashMap<Integer, Assignment> left = new HashMap<>();
			for (String[] plan : plans) {
				Assignment assignment = new Assignment(plan);
				left.put(assignment.time, assignment);
			}

			for (int i = 0; i < 100000; i++) {
				if (now != null) {
					now.playtime--;
					if (now.playtime == 0) {
						answerList.add(now.subject);
						now = null;
					}
				}
				if (left.containsKey(i)) {
					if (now != null) {
						assignments.addFirst(now);
					}
					now = left.get(i);
				} else if (now == null) {
					if (!assignments.isEmpty()) {
						now = assignments.removeFirst();
					}
				}
			}
			return answerList.stream().toArray(String[]::new);
		}

		class Assignment {
			String subject;
			int time;
			int playtime;

			Assignment(String[] plan) {
				this.subject = plan[0];
				this.time = parseTime(plan[1]);
				this.playtime = Integer.parseInt(plan[2]);
			}

			int parseTime(String time) {
				String[] timeArr = time.split(":");
				return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
			}
		}
	}
}
