import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int MAX = 100_000;
    static int[] time = new int[MAX + 1];
    static int N, K;


    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        inputs();
        solv();
        br.close();
    }

    private static void solv() {
        if (N >= K) {
            sb.append(N - K);
        } else {
            bfs();
            sb.append(time[K]);
        }
        System.out.println(sb);
    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(time, MAX);
        time[N] = 0;
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (time[now.idx] < now.time) continue;
            int pre = now.idx - 1;
            int post = now.idx + 1;
            int teleport = now.idx * 2;

            if (!isException(pre) && time[pre] > now.time + 1) {
                time[pre] = now.time + 1;
                q.add(new Node(pre, time[pre]));
            }
            if (!isException(post) && time[post] > now.time + 1) {
                time[post] = now.time + 1;
                q.add(new Node(post, time[post]));
            }
            if (!isException(teleport) && time[teleport] > now.time) {
                time[teleport] = now.time;
                q.add(new Node(teleport, time[teleport]));
            }
        }
    }

    private static boolean isException(int idx) {
        return idx < 0 || idx > MAX;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static class Node implements Comparable<Node> {
        public int idx;
        public int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
}
