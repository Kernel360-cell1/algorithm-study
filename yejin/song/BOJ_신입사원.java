package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_신입사원 {
    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼 반복
        for (int i = 0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            int rank[] = new int[N];

            for (int j = 0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rank[a-1] = b;
            }

            int pass = 1; // 서류 1등은 무조건 붙음
            int compare_rate = rank[0]; //서류 1등의 면접 등수

            for (int j = 1; j<N; j++){
                if (compare_rate > rank[j]){
                    pass++;
                    compare_rate = rank[j];
                }
            }
            System.out.println(pass);
        }
    }
}
