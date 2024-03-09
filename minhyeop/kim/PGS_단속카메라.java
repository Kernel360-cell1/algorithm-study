package minhyeop.kim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class PGS_단속카메라 {
    public int solution(int[][] routes) {
        // 진입지점 오름차순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] route : routes) {
            queue.add(route);
        }

        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        int now = -30000;
        while (!queue.isEmpty() || !arr.isEmpty()) {
            // 현재 도로의 지점 갱신
            int arrMin = 30001;
            for (int i : arr) {
                arrMin = Math.min(arrMin, i);
            }
            if (queue.isEmpty()) {
                now = arrMin;
            } else if (arr.isEmpty()) {
                now = queue.peek()[0];
            } else {
                now = Math.min(queue.peek()[0], arrMin);
            }

            // 현재 지점에서 진입하는 route 추가.
            while (!queue.isEmpty() && queue.peek()[0] == now) {
                arr.add(queue.poll()[1]);
            }
            // 현재 지점에서 진출해야 하는 route 있다면, 단속카메라 설치.
            if (arr.contains(now)) {
                arr = new ArrayList<>();
                answer++;
            }
        }
        return answer;
    }
}
