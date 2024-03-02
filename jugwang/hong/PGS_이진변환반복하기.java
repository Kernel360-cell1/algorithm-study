package jugwang.hong;

public class PGS_이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(s.length() > 1) {

            int count = 0;
            for(int i=0; i<s.length(); i++) {

                if(s.charAt(i) == '0') answer[1] ++;
                else count++;
            }

            s = Integer.toBinaryString(count);
            answer[0] ++;
        }

        return answer;
    }
}
