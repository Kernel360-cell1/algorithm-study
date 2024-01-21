package minhyeop.kim;

import java.util.HashSet;
import java.util.Set;

public class PGS_롤케이크자르기 {
    public int solution(int[] topping) {
        int[] left = new int[topping.length];
        int[] right = new int[topping.length];

        int leftTemp = 0;
        Set<Integer> leftArr = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            if (leftArr.contains(topping[i])) {
                left[i] = leftTemp;
                continue;
            }
            leftArr.add(topping[i]);
            left[i] = ++leftTemp;
        }

        int rightTemp = 0;
        Set<Integer> rightArr = new HashSet<>();
        for (int i = topping.length - 1; i >= 0; i--) {
            if (rightArr.contains(topping[i])) {
                right[i] = rightTemp;
                continue;
            }
            rightArr.add(topping[i]);
            right[i] = ++rightTemp;
        }


        int answer = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            if (left[i] == right[i + 1]) {
                answer++;
            }
        }
        return answer;
    }
}