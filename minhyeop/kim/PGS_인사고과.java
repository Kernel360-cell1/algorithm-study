package minhyeop.kim;

import java.util.ArrayList;

class PGS_인사고과 {
    public int solution(int[][] scores) {
        int wha = scores[0][0];
        int whb = scores[0][1];
        int wh = wha + whb;

        int answer = 1;

        ArrayList<int[]> arr = new ArrayList<>(); // 완호보다 앞 순위 점수 저장할 List

        for (int[] score : scores) {
            if (score[0] + score[1] <= wh) continue; // 완호보다 점수합 낮으면 continue;
            if (score[0] > wha && score[1] > whb) return -1; // 완호보다 점수 둘다 높으면 return -1;

            boolean con = false;
            for (int i = 0; i < arr.size(); i++) {
                int[] ar = arr.get(i);
                if (score[0] < ar[0] && score[1] < ar[1]) { // 기존 앞 순위보다 낮으면 취급 안함.
                    con = true;
                }
                if (ar[0] < score[0] && ar[1] < score[1]) { // 기존 앞 순위에 있는 게, 지금 성적보다 둘다 낮으면 제거.
                    arr.remove(i--);
                    answer--;
                }
            }

            if (con) continue; // 기존 앞 순위 중 어느 하나보다 둘다 점수가 낮으면, 앞 순위로 추가 안함.

            arr.add(score);
            answer++;
        }

        return answer;
    }
}
