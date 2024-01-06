package jugwang.hong;

import java.util.*;

public class PGS_가장큰수 {

    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];

        // 숫자를 문자로 변환
        for (int i =0; i < numbers.length; i++) {
            list[i] = String.valueOf(numbers[i]);
        }

        //내림차순
        Arrays.sort(list, (a, b) -> (b + a).compareTo(a + b));

        // 정렬 후 맨 처음이 0 이면 0으로 반환
        if (list[0].equals("0"))
            return "0";

        for (String s : list) {
            answer += s;
        }
        return answer;
    }
}
