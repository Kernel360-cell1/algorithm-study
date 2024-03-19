import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] A, dp1, dp2;

    public static void main(String[] args) throws IOException {
        input();
        solv();
        br.close();
    }

    public static void solv() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp1[i] <= dp1[j]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j] && dp2[i] <= dp2[j]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sum = Math.max(sum, dp1[i] + dp2[i]);
        }
        System.out.println(sum - 1);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}
