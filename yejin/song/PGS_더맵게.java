package yejin.song;
import java.util.PriorityQueue;

public class PGS_더맵게 {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville){
            pq.add(sco);
        }
        int count = 0;

        while (K>pq.peek()){
            if (pq.size()<=1) return -1;

            int first = pq.poll();
            int second = pq.poll();
            pq.add(first+second*2);
            count ++;
        }

        return count;
    }
}
