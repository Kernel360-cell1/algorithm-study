package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_로프 {

    public static int N;
    public static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순 정렬

        // 모든 로프 사용이라면 그리디로 제일 작은 중량 * N 인데 , 안써도 됨

        // 작은 중량 * N / 그다음 중량 * (N-1) / ... 반복 해서 최대 중량 구한다.
        // 이렇게 했을 때 시간/ 메모리 제한에 걸리는지 아닌지... 체크해보기
        // 근데 이렇게 하면 그리디가 아니라 완전 탐색 같음

        //IntStream.of(arr).forEach(System.out::println);

        int max = 0;

        for (int i = 0; i< N; i++){
            int now = arr[i] * (N-i);
            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}
