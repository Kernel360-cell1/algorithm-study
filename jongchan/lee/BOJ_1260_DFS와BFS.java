import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        dfs(V);
        sb.append('\n');
        Arrays.fill(visited, false);
        bfs(V);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int item = q.poll();
            sb.append(item).append(' ');
            for (int i = 1; i <= N; i++) {
                if (arr[item][i] == 0 || visited[i]) continue;
                q.add(i);
                visited[i] = true;
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');
        for (int i = 1; i <= N; i++) {
            if (arr[v][i] == 0 || visited[i]) continue;
            dfs(i);
        }
    }


    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];
        Arrays.fill(visited, false);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr[n][m] = 1;
            arr[m][n] = 1;
        }
    }
}
