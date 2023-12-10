import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_바이러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] computers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        dfs(1);
        int result = 0;
        for (boolean virus : visited) {
            if (virus)
                ++result;
        }
        System.out.println(result - 1);
    }

    private static void dfs(int n) {
        visited[n] = true;

        for (int virus : computers[n]) {
            if (!visited[virus])
                dfs(virus);
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        computers = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            computers[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }
    }
}
