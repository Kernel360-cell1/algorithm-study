package minhyeop.kim;

import java.util.*;

class PGS_가장먼노드 {
    public int solution(int n, int[][] edge) {
        Map<Integer, LinkedList<Integer>> lines = new HashMap<>();

        for (int[] ed : edge) {
            int a = ed[0];
            int b = ed[1];
            if (!lines.containsKey(a)) {
                LinkedList<Integer> tempArr = new LinkedList<>();
                tempArr.add(b);
                lines.put(a, tempArr);
            }
            else {
                LinkedList<Integer> tempArr = lines.get(a);
                tempArr.add(b);
                lines.put(a, tempArr);
            }
            if (!lines.containsKey(b)) {
                LinkedList<Integer> tempArr = new LinkedList<>();
                tempArr.add(a);
                lines.put(b, tempArr);
            }
            else {
                LinkedList<Integer> tempArr = lines.get(b);
                tempArr.add(a);
                lines.put(b, tempArr);
            }
        }

        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = -1;
        }

        Queue<Integer> now = new LinkedList<>();
        now.add(1);
        result[1] = -2;
        int count = 0;
        while (!now.isEmpty()) {
            count++;
            Queue<Integer> next = new LinkedList<>();
            while (!now.isEmpty()) {
                int temp = now.poll();
                LinkedList<Integer> tempArr = lines.get(temp);
                for (int i : tempArr) {
                    if (result[i] == -1) {
                        result[i] = count;
                        next.add(i);
                    }
                }
            }
            now = new LinkedList<>(next);
        }

        int answer = 0;
        count--;
        for (int i = 1; i < n + 1; i++) {
            if (result[i] == count) answer++;
        }

        return answer;
    }
}
