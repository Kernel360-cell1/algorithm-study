package jugwang.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_체스판다시칠하기 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            board[i] = s.toCharArray();
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                min = Math.min(min, count(i, j, true)); // 시작이 검은색
                min = Math.min(min, count(i, j, false)); // 시작이 흰색
            }
        }
        System.out.println(min);
    }

    // x, y 체스판 시작 위치
    // startIsBlack 은 검은색으로 시작하는지 확인
    public static int count(int x, int y, boolean startIsBlack) {
        int count = 0;
        boolean isBlack = startIsBlack;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (isBlack && board[i][j] == 'W') { count++; }
                if (!isBlack && board[i][j] == 'B') { count++; }
                isBlack = !isBlack; // 변경 .. W, B 번갈아가면서 체크해야하니까
            }
            isBlack = !isBlack;
        }
        return count;
    }
}
