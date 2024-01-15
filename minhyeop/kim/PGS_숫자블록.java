package minhyeop.kim;

import java.util.ArrayList;

public class PGS_숫자블록 {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end - (int)begin + 1];
        int index = 0;

        for (int i = (int)begin; i < (int)end + 1; i++) {
            int temp = 1;

            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    arr.add(j);
                    if (i / j <= 10000000) {
                        temp = i / j;
                        break;
                    }
                }
            }

            if (temp == 1 && !arr.isEmpty()) {
                temp = arr.get(arr.size() - 1);
            }

            if (i == 1) temp = 0;
            answer[index++] = temp;
        }

        return answer;
    }
}
