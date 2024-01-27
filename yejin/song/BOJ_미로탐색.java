package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_미로탐색 {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 미로 배열 초기화
        map = new int[n][m];

        // map에 저장
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                // 정수 변환
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 방문 배열 초기화
        visited = new boolean[n][m];

        // 시작 노드 방문표시
        visited[0][0] = true;

        // 함수 호출하여 최단 거리 계산하기
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y) {

        // 좌표(0,0)를 담기위해 int[] 를 담는 큐 생성
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            // 모든 가능한 방향(상,하,좌,우) 반복
            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 다음 위치 유효한지 확인 : 방문한 적 없고 벽이 아니어야 함, 값이 1 이어야함.
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                // 다음 위치를 큐에 추가
                q.add(new int[] {nextX, nextY});
                // 거리 정보 업데이트
                map[nextX][nextY] = map[nowX][nowY] + 1;

//                System.out.println("q:");
//                printQueue(q);
//                System.out.println("i:" + i);
//                System.out.println("map:");
//                printMap(map);
                // 방문한 위치로 추가
                visited[nextX][nextY] = true;
            }
        }
    }

//    // 큐의 내용을 출력하는 함수
//    public static void printQueue(Queue<int[]> queue) {
//        System.out.print("q: ");
//        for (int[] element : queue) {
//            System.out.print(Arrays.toString(element) + " ");
//        }
//        System.out.println();
//    }
//
//    // 배열의 내용을 출력하는 함수
//    public static void printMap(int[][] arr) {
//        for (int[] row : arr) {
//            System.out.println(Arrays.toString(row));
//        }
//    }

}

