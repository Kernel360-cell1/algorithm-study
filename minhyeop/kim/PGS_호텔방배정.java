package minhyeop.kim;

import java.util.*;

class PGS_호텔방배정 {
    static HashMap<Long, Long> map;
    long[] answer;

    public long[] solution(long k, long[] room_number) {
        map = new HashMap<>();

        answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = check(room_number[i]);
        }

        return answer;
    }

    private long check(long i) {
        if (!map.containsKey(i)) {
            map.put(i, i + 1);
            return i;
        } else {
            long end = check(map.get(i));
            map.put(i, end);
            return end;
        }
    }
}
