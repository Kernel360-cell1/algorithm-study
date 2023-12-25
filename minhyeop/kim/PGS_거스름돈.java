package minhyeop.kim;

public class PGS_거스름돈 {
    int[] answer = new int[100001];

    public int solution(int n, int[] money) {

        answer[0] = 1;
        for (int i = 0; i < money.length; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j - money[i] >= 0) {
                    answer[j] += answer[j - money[i]];
                    answer[j] %= 1000000007;
                }
            }
        }

        return answer[n];
    }
}
