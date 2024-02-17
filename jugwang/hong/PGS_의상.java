package jugwang.hong;

import java.util.*;

import static java.util.stream.Collectors.*;

public class PGS_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesHash = new HashMap<>();

        for(String[] clothe : clothes) {
            if(clothesHash.containsKey(clothe[1])) {
                int tmp = clothesHash.get(clothe[1]);
                clothesHash.put(clothe[1], tmp + 1);
            } else {
                clothesHash.put(clothe[1], 2);
            }
        }

        for(String k : clothesHash.keySet()) {
            answer *= clothesHash.get(k);
        }

        answer -= 1;

        return answer;
    }

    // 스트림 사용
    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting()))) // 옷의 종류로 그룹화
                .values() // 위에서 수행된 그룹화의 결과, 즉 각 옷 종류별 개수를 포함하는 컬렉션을 가져옴
                .stream() // 이 컬렉션을 다시 스트림으로 변환
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1; // y+1 은 옷을 입지 않는 경우 포함 ... 총에서 아무것도 안입는 1 을 뺌
    }
}
