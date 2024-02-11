package minhyeop.kim;

public class PGS_마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            if (storey % 10 == 0) {
                storey /= 10;
            }

            else if (storey % 10 < 5) {
                answer += storey % 10;
                storey -= storey % 10;
                storey /= 10;
            }

            else if (storey % 10 > 5) {
                answer += (10 - storey % 10);
                storey += (10 - storey % 10);
                storey /= 10;
            }

            else {
                answer += 5;
                int storeyUp = (storey + 5) / 10;
                int storeyDown = (storey - 5) / 10;

                if (storeyUp % 10 <= 5 && storeyUp % 10 != 0) {
                    storey = storeyDown;
                } else {
                    storey = storeyUp;
                }
            }
        }

        return answer;
    }
}
