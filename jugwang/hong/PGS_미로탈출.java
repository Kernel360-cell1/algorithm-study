package jugwang.hong;
import java.util.*;

public class PGS_미로탈출 {
    // 상, 하, 좌, 우
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        // BFS를 위한 큐 생성
        Queue<Point> queue = new LinkedList<>();
        // 방문 여부를 체크하기 위한 배열
        boolean[][] visited = new boolean[n][m];

        //좌표 초기화
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;

        // 미로 정보를 순회하면서 시작 지점, 레버 위치, 출구 위치를 찾음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // 레버를 먼저 찾는다
        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        int leverTime = 0;
        boolean foundLever = false;

        while (!queue.isEmpty()) {
            // 큐에서 하나의 요소를 꺼냄
            Point current = queue.poll();

            if (current.x == leverX && current.y == leverY) {
                leverTime = current.time;
                foundLever = true;
                break; // 레버를 찾으면 종료
            }

            // 네 방향으로의 이동을 탐색
            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                // 다음 위치가 유효하고, 벽이 아니며 아직 방문하지 않았다면 큐에 추가하고 방문 처리
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    queue.offer(new Point(nx, ny, current.time + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        // 레버를 찾지 못한 경우 -1 반환
        if (!foundLever) {
            return -1;
        }

        // 출구까지의 최단 거리 계산
        visited = new boolean[n][m];
        queue.clear();
        queue.offer(new Point(leverX, leverY, leverTime));
        visited[leverX][leverY] = true;

        while (!queue.isEmpty()) {
            // 큐에서 하나의 요소를 꺼냄
            Point current = queue.poll();

            // 출구에 도착하면 시간 반환
            if (current.x == exitX && current.y == exitY) {
                return current.time;
            }

            // 네 방향으로의 이동을 탐색
            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                // 다음 위치가 유효하고, 벽이 아니며 아직 방문하지 않았다면 큐에 추가하고 방문 처리
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    queue.offer(new Point(nx, ny, current.time + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        // 출구로 갈 수 없는 경우 -1 반환
        return -1;
    }
}
