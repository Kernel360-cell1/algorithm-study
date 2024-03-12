package minhyeop.kim;

class PGS_행렬테두리회전하기 {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows + 1][columns + 1];
        int value = 1;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                arr[i][j] = value++;
            }
        }

        int[] answer = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            answer[index++] = rotate(query[0], query[1], query[2], query[3]);
        }

        return answer;
    }

    private int rotate(int r1, int c1, int r2, int c2) {
        int min = arr[r1][c1];

        int temp = arr[r1 + 1][c1];

        int nowR = r1;
        int nowC = c1;
        int bef = arr[r1][c1];
        for (int i = 1; i < ((r2 - r1) + (c2 - c1)) * 2; i++) {
            int[] now = next(nowR, nowC, r1, c1, r2, c2);
            nowR = now[0];
            nowC = now[1];
            int nex = arr[nowR][nowC];
            min = Math.min(min, nex);
            arr[nowR][nowC] = bef;
            bef = nex;
        }
        arr[r1][c1] = temp;

        return min;
    }

    private int[] next(int nowR, int nowC, int r1, int c1, int r2, int c2) {
        if (nowR == r1 && nowC == c1) {
            return new int[]{nowR, nowC + 1};
        } else if (nowR == r1 && nowC == c2) {
            return new int[]{nowR + 1, nowC};
        } else if (nowR == r2 && nowC == c2) {
            return new int[]{nowR, nowC - 1};
        } else if (nowR == r2 && nowC == c1) {
            return new int[]{nowR - 1, nowC};
        } else if (nowR == r1) {
            return new int[]{nowR, nowC + 1};
        } else if (nowC == c2) {
            return new int[]{nowR + 1, nowC};
        } else if (nowR == r2) {
            return new int[]{nowR, nowC - 1};
        } else {
            return new int[]{nowR - 1, nowC};
        }
    }
}

