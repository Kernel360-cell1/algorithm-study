package minhyeop.kim;

class PGS_두원사이의정수쌍 {
    public static void main(String[] args) {
        System.out.println(solution(200,1000000));
    }
    public static long solution(int r1, int r2) {

        long answer = 0;

        Long powR1 = (long) Math.pow(r1, 2);
        Long powR2 = (long) Math.pow(r2, 2);

        int startX = 0;
        int endX = 0;

        for (int i = 1; i < r2 + 1; i++) {
            double a = Math.sqrt(powR1 - Math.pow(i, 2));
            double b = Math.sqrt(powR2 - Math.pow(i, 2));

            if (i >= r1) {
                startX = 0;
            } else {
                startX = (a == (double) ((int) a)) ? (int) a : (int) a + 1;
            }
            endX = (int) b;

            answer += endX - startX + 1;
        }

        answer *= 4L;

        return answer;
    }
}