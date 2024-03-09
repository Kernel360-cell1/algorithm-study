package minhyeop.kim;

import java.util.*;

class PGS_메뉴리뉴얼 {
    static LinkedList<String> answer;
    static HashMap<String, Integer> map;
    static int[] indexes;

    public String[] solution(String[] orders, int[] course) {
        answer = new LinkedList<>();

        for (int target : course) {
            check(orders, target);
        }

        String[] ans = new String[answer.size()];
        int index = 0;

        Collections.sort(answer);
        for (String s : answer) {
            ans[index++] = s;
        }

        return ans;
    }

    private void check(String[] orders, int target) {
        map = new HashMap<>();

        for (String order : orders) {
            if (order.length() < target) continue;

            indexes = new int[order.length()];
            mapping(order, 0, target);
        }

        LinkedList<String> tempAnswer = new LinkedList<>();
        int min = Integer.MIN_VALUE;

        for (String s : map.keySet()) {
            if (map.get(s) == min) {
                tempAnswer.add(s);
            } else if (map.get(s) > min && map.get(s) > 1) {
                tempAnswer.clear();
                tempAnswer.add(s);
                min = map.get(s);
            }
        }

        answer.addAll(tempAnswer);
    }

    private void mapping(String order, int now, int target) {
        if (now == order.length()) {
            String s = "";

            for (int i = 0; i < indexes.length; i++) {
                if (indexes[i] == 1) {
                    s += String.valueOf(order.charAt(i));
                }
            }

            if (s.length() == target) {
                LinkedList<String> sort = new LinkedList<>();
                for (char c : s.toCharArray()) {
                    sort.add(String.valueOf(c));
                }
                Collections.sort(sort);

                String sortedS = "";
                for (String ss : sort) {
                    sortedS += ss;
                }

                map.put(sortedS, map.getOrDefault(sortedS, 0) + 1);
            }
            return;
        }

        indexes[now] = 1;
        mapping(order, now + 1, target);
        indexes[now] = 0;
        mapping(order, now + 1, target);
    }
}
