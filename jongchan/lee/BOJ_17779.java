package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int[] region;
    static int total = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        input();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;
                        solv(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void solv(int x, int y, int d1, int d2) {
        writeBoundary(x, y, d1, d2);
        sumRegion(x, y, d1, d2);
    }

    private static void sumRegion(int x, int y, int d1, int d2) {
        region = new int[5];

        //1
        for (int r = 0; r < x + d1; r++) {
            for (int c = 0; c <= y; c++) {
                if (visited[r][c]) break;
                region[0] += A[r][c];
            }
        }

        //2
        for (int r = 0; r <= x + d2; r++) {
            for (int c = N - 1; c > y; c--) {
                if (visited[r][c]) break;
                region[1] += A[r][c];
            }
        }

        //3
        for (int r = x + d1; r < N; r++) {
            for (int c = 0; c < y - d1 + d2; c++) {
                if (visited[r][c]) break;
                region[2] += A[r][c];
            }
        }

        //4
        for (int r = x + d2 + 1; r < N; r++) {
            for (int c = N - 1; c >= y - d1 + d2; c--) {
                if (visited[r][c]) break;
                region[3] += A[r][c];
            }
        }

        //5
        region[4] = total;
        for (int i = 0; i < 4; i++) {
            region[4] -= region[i];
        }

        Arrays.sort(region);
        answer = Math.min(answer, region[4] - region[0]);
    }

    private static void writeBoundary(int x, int y, int d1, int d2) {
        visited = new boolean[N][N];

        for (int i = 0; i <= d1; i++) {
            visited[x + i][y - i] = true; //1
            visited[x + d2 + i][y + d2 - i] = true; //4
        }

        for (int i = 0; i <= d2; i++) {
            visited[x + i][y + i] = true; //2
            visited[x + d1 + i][y - d1 + i] = true; //3
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                total += A[i][j];
            }
        }
    }
}
