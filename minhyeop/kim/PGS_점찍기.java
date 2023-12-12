package minhyeop.kim;

public class PGS_점찍기 {
    public static void main(String[] args) {
        System.out.println(solution(1, 5));
    }
    public static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; k * i <= d; i++) {
            int now = i * k;
            answer += ((int) (Math.sqrt(Math.pow(d, 2) - Math.pow(now, 2)))) / k + 1;
        }

        return answer;
    }
}
