package minhyeop.kim;

import java.util.ArrayList;
import java.util.Collections;

public class PGS_혼자놀기의달인 {
    public int solution(int[] cards) {
        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            arr.add(new int[]{i+1, cards[i]});
        }

        ArrayList<Integer> answers = new ArrayList<>();

        while (!arr.isEmpty()) {
            int answer = 0;

            int[] now = arr.get(0);
            arr.remove(0);
            answer++;
            boolean stop = false;

            while(!stop) {
                stop = true;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i)[0] == now[1]) {
                        now = arr.get(i);
                        arr.remove(i);
                        answer++;
                        stop = false;
                    }
                }
            }

            answers.add(answer);
        }

        if (answers.size() == 1) return 0;

        Collections.sort(answers, Collections.reverseOrder());

        return answers.get(0) * answers.get(1);
    }
}
