package com.example.programmers.level2;

public class Programmers_level2_방문길이 {
    public int solution(String dirs) {
        // y: 세로, x : 가로, d : 방향
        int[][][] arr = new int[11][11][4];
        boolean[][][] visited = new boolean[11][11][4];
        int answer = 0;

        //상, 우, 하, 좌
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int y = 5, x = 5, d = 0;

        for (char dir : dirs.toCharArray()) {
            switch (dir) {
                case 'U' -> d = 0;
                case 'D' -> d = 2;
                case 'R' -> d = 1;
                case 'L' -> d = 3;
            }

            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= 11 || nx >= 11) continue;
            if (!visited[ny][nx][d]) {
                visited[ny][nx][d] = true;
                d = d % 2 == 0 ? 2 - d : 4 - d;
                visited[y][x][d] = true;
                ++answer;
            }

            y = ny;
            x = nx;
        }
        return answer;
    }
}
