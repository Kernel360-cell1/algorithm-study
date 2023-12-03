package minhyeop.kim;

public class PGS_가장긴팰린드롬 {
    public static void main(String[] args) {
        System.out.println(solution("abacde"));
    }
    public static int solution(String s) {
        int answer = 0;

        char[] c = s.toCharArray();

        int end = c.length;
        for (int i = 0; i < end; i++) {
            int now1 = 0;
            for (int j = 0; j < Math.min(end-i-1, i + 1); j++) {
                if (c[i - j] != c[i + 1 + j]) {
                    break;
                }
                now1++;
            }
            now1 *= 2;
            answer = Math.max(answer, now1);
            int now2 = 0;
            for (int j = 0; j < Math.min(end-i-1, i); j++) {
                if (c[i - 1 - j] != c[i + 1 + j]) {
                    break;
                }
                now2++;
            }
            now2 = now2 * 2 + 1;
            answer = Math.max(answer, now2);
        }
        
        return answer;
    }
}
