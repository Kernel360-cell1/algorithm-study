package yoonseon.ko;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_최대힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬 설정
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if (pq.isEmpty()) // 우선순위 큐가 비어있으면
                    sb.append(0).append("\n"); // 0 출력
                else // 우선순위 큐가 비어있지 않다면
                    sb.append(pq.poll()).append("\n"); // 0일 때 우선순위 큐에서 최대값을 꺼내고(제거하고) 출력
                continue;
            }
            pq.add(x);
        }
        System.out.println(sb);
    }
}
