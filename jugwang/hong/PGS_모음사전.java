package jugwang.hong;

import java.util.*;

public class PGS_모음사전 {

    static List<String> dictionary = new ArrayList<>();

    // 재귀함수를 이용해 사전 만들기
    public void recursion(String p, int step) {
        if (step == 6) {
            return;
        }
        if (!p.equals("")) {
            dictionary.add(p);
        }
        char[] words = {'A', 'E', 'I', 'O', 'U'};
        for (char c : words) {
            recursion(p + c, step + 1);
        }
    }

    public int solution(String word) {
        recursion("", 0);
        int answer = 0;
        // 만들어진 사전에서 인덱스 + 1 로 답 추출
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}
