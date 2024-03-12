package minhyeop.kim;

import java.util.*;

class PGS_섬연결하기 {
    static ArrayList<int[]> cost;
    public int solution(int n, int[][] costs) {
        // 다리 정보 저장할 cost.
        cost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cost.add(new int[n]);
        }

        // 건설비용이 내림차순으로 정렬된 다리 정보 queue.
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o[2]));

        for (int[] c : costs) {
            cost.get(c[0])[c[1]] = c[2];
            cost.get(c[1])[c[0]] = c[2];
            queue.add(c);
        }

        // 다리 건설비용 높은 것부터, 빼도 되는지 수행.
        while (!queue.isEmpty()) {
            check(queue.poll());
        }

        // 현재 도로 정보에 대해 중복 없이 계산.
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

        // 0부터 시작.
        gone[0] = true;
        now.add(0);

        while (!now.isEmpty()) {
            int n = now.poll();
            for (int i = 0; i < cost.size(); i++) {
                if (!gone[i] && (cost.get(n)[i] != 0)) {
                    // 가본적 없고, 유효한 도로 있다면 => now Queue에 추가 & gone 처리.
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

        // 0에서 모든 섬으로 이어지지 않으면 롤백.
        if (!allGone) {
            cost.get(road[0])[road[1]] = road[2];
            cost.get(road[1])[road[0]] = road[2];
        }
    }
}
