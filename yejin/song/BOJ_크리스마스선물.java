package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_크리스마스선물 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // 최대힙 되도록 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            // 거점지일 경우
            if (a != 0) {
                continue;
            }

            // a==0 , 즉 아이들 만났을 때
            if (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }
            else {
                sb.append(-1).append("\n");
            }

        }
        System.out.println(sb.toString());
    }

}

