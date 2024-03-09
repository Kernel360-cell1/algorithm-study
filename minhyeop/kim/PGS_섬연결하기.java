package minhyeop.kim;

/*
- 49:10

- 그리디

- cost에 다리 정보를 모두 저장합니다.
- 그러고 난 뒤, 다리 건설비용이 가장 높은 것부터 하나씩 빼보며
  - check()를 통해, 해당 다리 없이도 다 연결되면 빼고, 다 연결되지 않으면 빼지 않습니다.
- 그런 다음, cost에 남아있는 다리 비용만 계산하여 return 합니다.

- 이 풀이와는 다른 방식인,
  - 다리 건설비용 낮은 것부터 추가하며, 이미 연결돼 있다면 pass 하는 방식이 더 간결하고 합리적으로 보입니다.
 */

import java.util.*;

class PGS_섬연결하기 {
    static ArrayList<int[]> cost;
    public int solution(int n, int[][] costs) {
        // 다리 정보 모두 저장
        cost = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            cost.add(new int[n]);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o[2]));

        for (int[] c : costs) {
            cost.get(c[0])[c[1]] = c[2];
            cost.get(c[1])[c[0]] = c[2];
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            check(queue.poll());
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cost.get(i)[j] != 0) {
                    answer += cost.get(i)[j];
                }
            }
        }
        return answer;
    }

    private void check(int[] road) {
        cost.get(road[0])[road[1]] = 0;
        cost.get(road[1])[road[0]] = 0;

        boolean[] gone = new boolean[cost.size()];
        Queue<Integer> now = new LinkedList<>();
        gone[0] = true;
        now.add(0);

        while (!now.isEmpty()) {
            int n = now.poll();
            for (int i = 0; i < cost.size(); i++) {
                if (gone[i]) continue;
                else {
                    if (cost.get(n)[i] == 0) continue;
                    gone[i] = true;
                    now.add(i);
                }
            }
        }

        boolean allGone = true;
        for (boolean b : gone) {
            if (!b) {
                allGone = false;
                break;
            }
        }

        if (!allGone) {
            cost.get(road[0])[road[1]] = road[2];
            cost.get(road[1])[road[0]] = road[2];
        }
    }
}
