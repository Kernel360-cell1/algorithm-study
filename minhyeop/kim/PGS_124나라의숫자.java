package minhyeop.kim;

class PGS_124나라의숫자 {
    static String answer = "";

    public String solution(int n) {

        int count = first(n);
        for (int i = 1; i < count; i++) {
            n -= Math.pow(3, i);
        }

        second(count, n);

        return answer;
    }

    private int first(int num) {
        for (int i = 1; i < 100000; i++) {
            if (num <= Math.pow(3, i)) return i;
            else num -= Math.pow(3, i);
        }
        return 0;
    }

    private void second(int count, int num) {
        for (int i = count; i > 0; i--) {
            int max = (int)(Math.pow(3, i));

            if (num <= (max/3)) {
                answer += "1";

            } else if (num <= (max/3*2)) {
                answer += "2";
                num -= (max/3);
            } else {
                answer += "4";
                num -= (max/3*2);
            }
        }
    }
}
