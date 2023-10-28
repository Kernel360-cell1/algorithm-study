package jugwang.hong;

import java.util.Arrays;
public class PGS_구명보트 {
    //문제 조건에 부합한 풀이
    public int solution(int[] people, int limit) {
        int boats = 0; // 한 번에 2명씩 구출된 횟수
        Arrays.sort(people); // 사람들의 무게를 오름차순으로 정렬

        // 이 부분은 문제의 제한사항에서 아래의 조건이 사라졌을 때를 대비해봄
        // "구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다."
        // limit 넘는 사람은 구출 못하니까 제외
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] > limit) {
                people[i] = -1;
                count++;
            }
        }


        int left = 0; // 왼쪽 인덱스
        int right = people.length - count - 1; // 오른쪽 인덱스

        while (left < right) {
            // left와 right의 무게 합이 limit 이하인 경우
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                boats++;
            // 무게 합이 limit를 초과하는 경우
            } else {
                right--; // 오른쪽 인덱스만 감소
            }
        }

        // 모든 사람의 수 - 구출 못하는 사람의 수 - 구명보트의 수 -> 혼자 타는 보트도 포함한 보트의 수가 나옴
        return people.length - count - boats;
    }

}
