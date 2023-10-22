package minhyeop.ko;

import java.util.ArrayList;
import java.util.List;

public class PGS_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; // default; 끝말잇기 모두 성공하면 [0, 0] 출력
        List<String> str = new ArrayList<>();
        str.add(words[0]);

        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length()-1) != words[i + 1].charAt(0)) { // i+1 인덱스에서 끝말잇기 실패하면
                answer = new int[]{(i + 1) % n + 1, (int)((i + 1) / n + 1)}; // 순번과 차례 계산
                break;
            } else if (str.contains(words[i + 1])) { // i+1 인덱스에서 중복된 단어 말하면
                answer = new int[]{(i + 1) % n + 1, (int) ((i + 1) / n + 1)}; // 순번과 차례 계산
                break;
            } else { // 끝말잇기 성공하면
                str.add(words[i + 1]); // str에 단어 저장
            }
        }

        return answer;
    }
}
