package minhyeop.kim;

public class PGS_멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = (long)w * h;

        for (long i = 1; i <= w; i++) {
            long before = (long)Math.floor((i - 1) * h/(double)w);
            long after = (long)Math.ceil(i * h/(double)w);

            answer -= after - before;
        }

        return answer;
    }
}
