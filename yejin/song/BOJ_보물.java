package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_보물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        Integer B[] = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B, Comparator.reverseOrder()); // 내림차순으로 하려면 wrapper 타입으로 배열 만들어야 함.

        int result=0;

        for (int i = 0 ; i < N ; i++){
            result += A[i]*B[i];
        }

        System.out.println(result);
    }
}
