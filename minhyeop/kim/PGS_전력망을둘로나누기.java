package minhyeop.kim;

import java.util.*;

class PGS_전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        for (int nn = 0; nn < wires.length; nn++) {
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                arr.add(new ArrayList<>());
            }

            for (int i = 0; i < wires.length; i++) {
                if (i == nn) continue;
                arr.get(wires[i][0]).add(wires[i][1]);
                arr.get(wires[i][1]).add(wires[i][0]);
            }

            ArrayList<Integer> gone = new ArrayList<>();

            LinkedList<Integer> queue = new LinkedList<>();

            gone.add(1);
            queue.add(1);

            while (!queue.isEmpty()) {
                ArrayList<Integer> now = arr.get(queue.poll());
                for (int j : now) {
                    if (gone.contains(j)) continue;
                    queue.add(j);
                    gone.add(j);
                }
            }

            int tempAnswer =
                    Math.max(gone.size(), n - gone.size())
                            - Math.min(gone.size(), n - gone.size());

            answer = Math.min(answer, tempAnswer);
        }

        return answer;
    }
}
