package minhyeop.kim;

import java.util.*;

class PGS_보석쇼핑 {
    public int[] solution(String[] gems) {
        int target = new HashSet<>(Arrays.asList(gems)).size();

        int start = 0;
        int end = gems.length - 1;

        HashSet<String> temp = new HashSet<>();
        int tempStart = 0;

        for (int i = 0; i < gems.length; i++) {
            temp.add(gems[i]);
            if (temp.size() == target) {
                temp.clear();
                tempStart = diet(gems, i, tempStart, target);
                if (i - tempStart < end - start) {
                    start = tempStart;
                    end = i;
                }
                i = tempStart;
            }
        }

        int[] answer = new int[]{start + 1, end + 1};
        return answer;
    }

    private int diet(String[] gems, int nowIndex, int tempStart, int target) {
        HashSet<String> dietSet = new HashSet<>();

        for (int i = nowIndex; i >= tempStart; i--) {
            dietSet.add(gems[i]);
            if (dietSet.size() == target) {
                return i;
            }
        }

        return tempStart;
    }
}
