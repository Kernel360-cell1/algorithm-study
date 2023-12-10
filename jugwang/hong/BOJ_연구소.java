package jugwang.hong;

import java.util.*;

public class BOJ_연구소 {

    static int n, m, result = 0;
    static int[][] map = new int[8][8];
    // 벽을 설치한 뒤의 맵 배열
    static int[][] wall_map = new int[8][8];


    //상, 하, 좌, 우
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    // BFS를 이용해 각 바이러스가 사방으로 퍼지도록 하기
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 초기 바이러스 위치 큐에 삽입
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                wall_map[i][j] = map[i][j];
                if (wall_map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS 진행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 퍼질 수 있는 범위 내이고, 빈 공간인 경우 바이러스 전파
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (wall_map[nx][ny] == 0) {
                        wall_map[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    // 벽 카운트
    static void wall(int cnt) {
        if (cnt == 3) {
            bfs();
            result = Math.max(result, getScore());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽 설치
                    wall(cnt + 1); // 다음 벽 설치 시도
                    map[i][j] = 0; // 되돌리기
                }
            }
        }
    }


    // 안전 영역 구하기
    static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wall_map[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 벽 설치 및 안전 영역 크기 계산
        wall(0);
        System.out.println(result);
    }

}
