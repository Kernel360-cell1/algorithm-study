package minhyeop.kim;

import java.util.PriorityQueue;

public class PGS_더맵게 {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            // 스코빌 지수 담을 최소힙
            PriorityQueue<Integer> arr = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                arr.add(scoville[i]);
            }

            int minScoville = arr.poll(); // 스코빌 최소힙 중 가장 낮은 스코빌 가져오기
            while (minScoville < K) { // 종료 조건1: 가장 낮은 스코빌이 K보다 크거나 같으면 반복문 종료
                if (arr.isEmpty()) { // 종료 조건2: 하나 남은 스코빌이 K보다 작으면 반복문 종료 (-1 리턴)
                    answer = -1;
                    break;
                }
                int nextMinScoville = arr.poll(); // 두 번째로 낮은 스코빌 가져오기
                int newScoville = minScoville + nextMinScoville * 2; // 가장 낮은 스코빌, 두번째로 낮은 스코빌 섞어서, 새로운 스코빌 생성
                arr.add(newScoville); // 새로운 스코빌 최소힙에 추가
                answer += 1; // 섞은 횟수 += 1
                minScoville = arr.poll(); // 현재 스코빌 최소힙에서 가장 낮은 스코빌 가져오기
            }
            return answer;
        }
    }