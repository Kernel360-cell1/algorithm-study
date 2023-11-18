package jugwang.hong;
import java.util.*;

public class PGS_게임맵최단거리 {
    // 상, 하, 좌, 우
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    //너비 탐색
    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // BFS를 위한 큐 생성
        Queue<Point> q = new LinkedList<>();
        // 방문 여부를 체크하기 위한 배열
        boolean[][] visited = new boolean[n][m];

        // 시작점 설정 (좌측 상단에서 시작)
        // offer 대신 add 도 가능
        q.offer(new Point(0, 0, 1));
        // 시작점 방문 처리
        visited[0][0] = true;

        while (!q.isEmpty()) {
            // 큐에서 하나의 요소를 꺼냄
            // poll 대신 removeFirst 넣어도 됨
            Point current = q.poll();

            if (current.x == n - 1 && current.y == m - 1) {
                // 목적지에 도달한 경우 최단 거리 반환
                return current.distance;
            }

            // 네 방향으로의 이동을 탐색
            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                // 다음 위치가 유효하고, 벽이 아니며 아직 방문하지 않았다면 큐에 추가하고 방문 처리
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new Point(nx, ny, current.distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        // 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
