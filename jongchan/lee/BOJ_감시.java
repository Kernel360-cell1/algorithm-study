package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_감시 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] office;
    static ArrayList<CCTV> cctvs;
    static final int[][] MOVE = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};// R, U, L, D
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        inputs();
        solv(0);
        System.out.println(answer);
        br.close();
    }

    private static void solv(int idx) {
        if (idx == cctvs.size()) { //모든 cctv를 다 확인했을 때
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (office[i][j] == 0) tmp++;
                }
            }
            answer = Math.min(answer, tmp);
            return;
        }
        int y = cctvs.get(idx).y;
        int x = cctvs.get(idx).x;
        int[][] backU = new int[8][8];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                backU[i][j] = office[i][j];
            }
        }

        for (int dir = 0; dir < 4; dir++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    backU[i][j] = office[i][j];
                }
            }
            if (office[y][x] == 1) {
                check(y, x, dir); //dir == 0 일때 R
            } else if (office[y][x] == 2) {
                check(y, x, dir); //dir == 0 일때 R
                check(y, x, dir + 2); //dir == 0 일때 L

            } else if (office[y][x] == 3) {
                check(y, x, dir); //dir == 0 일때 R
                check(y, x, dir + 1); //dir == 0 일때 U
            } else if (office[y][x] == 4) {
                check(y, x, dir); //dir == 0 일때 R
                check(y, x, dir + 1); //dir == 0 일때 U
                check(y, x, dir + 2); //dir == 0 일때 L

            } else if (office[y][x] == 5) {
                check(y, x, dir); //dir == 0 일때 R
                check(y, x, dir + 1); //dir == 0 일때 U
                check(y, x, dir + 2); //dir == 0 일때 L
                check(y, x, dir + 3); //dir == 0 일때 D
            }

            solv(idx + 1); //다음 cctv 회전

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    office[i][j] = backU[i][j];
                }
            }
        }
    }

    private static void check(int y, int x, int idx) {
        idx %= 4; // R, U, L, D (0 ~ 3)
        while (true) {
            int ny = y + MOVE[idx][0];
            int nx = x + MOVE[idx][1];
            y = ny;
            x = nx;
            if (nx < 0 || ny < 0 || ny >= N || nx >= M) return;
            if (office[ny][nx] == 6) return;
            if (office[ny][nx] != 0) continue;
            office[ny][nx] = '#';
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvs = new ArrayList<>();
        office = new int[8][8];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) cctvs.add(new CCTV(office[i][j], i, j));
            }
        }
    }

    static class CCTV {
        int num;
        int y;
        int x;

        public CCTV(int num, int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
        }
    }
}
