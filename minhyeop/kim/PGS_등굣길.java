package minhyeop.kim;

public class PGS_등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] area = new int[n][m];

        area[0][0] = 1;
        for (int[] puddle : puddles) {
            area[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0) {
                    if (j - 1 >= 0 && area[i][j - 1] != -1) {
                        area[i][j] += area[i][j - 1];
                    }
                    if (i - 1 >= 0 && area[i - 1][j] != -1) {
                        area[i][j] += area[i - 1][j];
                    }
                    area[i][j] %= 1000000007;
                }
            }
        }

        return area[n - 1][m - 1];
    }
}
