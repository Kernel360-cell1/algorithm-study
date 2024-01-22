package minhyeop.kim;

public class PGS_도둑질 {
    public int solution(int[] money) {
        int end = money.length - 1;
        int[] gone0 = new int[money.length];
        int[] gone1 = new int[money.length];

        gone0[0] = money[0];
        gone0[1] = money[1];
        gone0[2] = money[0] + money[2];

        gone1[0] = 0;
        gone1[1] = money[1];
        gone1[2] = money[2];

        for (int i = 3; i < end; i++) {
            gone0[i] = money[i] + Math.max(gone0[i - 2], gone0[i - 3]);
            gone1[i] = money[i] + Math.max(gone1[i - 2], gone1[i - 3]);
        }
        gone1[end] = money[end] + Math.max(gone1[end - 2], gone1[end - 3]);

        int answer0 = Math.max(gone0[end - 1], gone0[end - 2]);
        int answer1 = Math.max(gone1[end], gone1[end - 1]);

        return Math.max(answer0, answer1);
    }
}
