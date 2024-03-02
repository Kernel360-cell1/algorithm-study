package jugwang.hong;

public class PGS_카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int i = 1; i <= (int)Math.sqrt(total); i++) {
            if (total % i == 0) { // i가 total의 약수인 경우
                int j = total / i; // 다른 약수
                if ((i - 2) * (j - 2) == yellow) {
                    return new int[] {Math.max(i, j), Math.min(i, j)};
                }
            }
        }
        return new int[] {0, 0};
    }
}
