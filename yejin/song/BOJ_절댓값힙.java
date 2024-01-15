package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 절댓값 작은 순으로 정렬되도록 오버라이드

                // 절댓값 기준으로 a가 더 크면 자리를 바꿔준다.
                if (Math.abs(a) > Math.abs(b)){
                    return Math.abs(a) - Math.abs(b);
                } //절댓값 기준으로 값이 같으면 음수를 앞으로 보내준다.
                else if (Math.abs(a) == Math.abs(b)){
                    return a-b;
                }
                else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }else{
                pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}
