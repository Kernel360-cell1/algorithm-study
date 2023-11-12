import java.util.*;
import java.io.*;

class BOJ_벽부수고이동하기 {
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int a, b;
    static final int INF = (int) 1e9;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, dist, cons;

        public Node(int x, int y, int dist, int cons) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cons = cons;
        }
    }

    //너비 우선 탐색을 응용한 구현
    private static int bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y] = 0;
        // 큐에 노드가 남아있는 동안
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            // 만약에 마지막에 도착했을 경우
            if (now.x == a - 1 && now.y == b - 1) {
                return now.dist;
            }

            // 4방향 모두 확인
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i], ny = now.y + dy[i];
                // 지도 밖을 벗어 났을 경우
                if (nx < 0 || nx >= a || ny < 0 || ny >= b) continue;
                // 현재 방문하는 곳의 벽돌 공사 공사 횟수가 더 많으면
                if (visited[nx][ny] > now.cons) {
                    // 현재 방문하는 곳의 길이 열려 있으면
                    if (graph[nx][ny] == 0) {
                        visited[nx][ny] = now.cons;
                        q.add(new Node(nx, ny, now.dist + 1, now.cons));

                    }
                    // 현재 가려는 곳이 벽이라면
                    else if (graph[nx][ny] == 1 && now.cons == 0) {
                        visited[nx][ny] = now.cons + 1;
                        q.add(new Node(nx, ny, now.dist + 1, now.cons + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        graph = new int[a][b];
        visited = new int[a][b];
        for (int i = 0; i < a; i++) {
            String now = sc.next();
            for (int j = 0; j < b; j++) {
                // 초기 지도 설정
                graph[i][j] = Character.getNumericValue(now.charAt(j));
                // 모든 방문을 INF로 설정
                visited[i][j] = INF;
            }
        }

        System.out.println(bfs(0, 0));
    }
}