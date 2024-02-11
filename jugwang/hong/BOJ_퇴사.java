package jugwang.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2]; // 초깃값 0 을 준다

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken()); // 상담 일수
            P[i] = Integer.parseInt(st.nextToken()); // 돈
        }

        for(int i = N; i > 0; i--) {
            int next = i + T[i];

            if(next > N + 1) { // 퇴사 날짜를 넘어가는지 체크
                DP[i] = DP[i + 1]; // 앞 날짜로
            } else {
                DP[i] = Math.max(DP[i + 1], P[i] + DP[next]); // max(일하지 않았을 때, 일 했을 때) 비교
            }
        }

        System.out.println(DP[1]);
    }
}
