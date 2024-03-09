package jugwang.hong;

import java.util.*;

public class PGS_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 순서대로 꺼내기 위해 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        } // 소수점 나오면 올림

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll(); // 현재 기능이 완료되는 일자를 꺼내옴
            }
            ans.add(cnt);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
