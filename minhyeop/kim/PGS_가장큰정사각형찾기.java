package minhyeop.kim;

class PGS_가장큰정사각형찾기 {
    static int[][] arr;
    static int[][] answers;
    public int solution(int[][] board) {
        arr = board;
        answers = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            answers[i] = new int[board[0].length];
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;

                answers[i][j] = 1;
                if (i == 0 || j == 0) continue;

                answers[i][j] = Math.min(answers[i - 1][j], Math.min(answers[i][j - 1], answers[i - 1][j - 1])) + 1;
            }
        }

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer = Math.max(answer, answers[i][j]);
            }
        }

        return (int) Math.pow(answer, 2);
    }
}
