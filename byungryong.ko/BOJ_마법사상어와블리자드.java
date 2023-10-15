import java.util.*;
import java.io.*;

class Main {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[] answer = {0, 0, 0, 0};
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Node> nodes = new ArrayList<>();
    static ArrayList<Integer> ballNums = new ArrayList<>();

    private static void getNodes() {
        int x = n / 2, y = n / 2, timer = 0, direction = 1;
        while (x >= 0 && x < n && y >= 0 && y < n) {
            if (direction != 0) {
                for (int i = 0; i < timer * 2 + 1; i++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (x < 0 || x >= n || y < 0 || y >= n) break;
                    nodes.add(new Node(x, y));
                }
            } else {
                for (int i = 0; i < timer * 2; i++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (x < 0 || x >= n || y < 0 || y >= n) break;
                    nodes.add(new Node(x, y));
                }
            }

            if (direction == 3) {
                x += dx[direction];
                y += dy[direction];
                nodes.add(new Node(x, y));
            }
            direction++;
            if (direction > 3) {
                timer++;
                direction = 0;
            }
        }
    }

    private static void blizzard(int direction, int s) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int x = n / 2, y = n / 2;
        for (int i = 0; i < s; i++) {
            x += dx[direction];
            y += dy[direction];
            graph[x][y] = 0;
        }
    }

    private static void pull() {
        for (Node node : nodes) {
            if (graph[node.x][node.y] != 0) {
                ballNums.add(graph[node.x][node.y]);
            }
        }

        int length = nodes.size() - ballNums.size();
        for (int i = 0; i < length; i++) {
            ballNums.add(0);
        }

        for (int i = 0; i < nodes.size(); i++) {
            Node now = nodes.get(i);
            int number = ballNums.get(i);
            graph[now.x][now.y] = number;
        }
    }

    private static void burstBalls() {
        ArrayList<Integer> newBalls = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int curType = 0;
        for (int i = 0; i < ballNums.size(); i++) {
            if (curType != ballNums.get(i)) {
                if (temp.size() < 4) {
                    newBalls.addAll(temp);
                } else if (temp.size() >= 4){
                    answer[curType] += temp.size();
                }
                curType = ballNums.get(i);
                temp.clear();
                temp.add(curType);
            } else {
                temp.add(curType);
            }
        }
        if (!temp.isEmpty() && curType != 0) {
            if (temp.size() >= 4) {
                answer[curType] += temp.size();
            } else {
                newBalls.addAll(temp);
            }
        }
        ballNums = newBalls;
    }

    private static boolean checkBalls() {
        ArrayList<Integer> checks = new ArrayList<>();
        int curType = 0, size = 0;
        for (int i = 0; i < ballNums.size(); i++) {
            if (curType != ballNums.get(i)) {
                checks.add(size);
                curType = ballNums.get(i);
                size = 0;
            }
            size++;
        }
        if (curType != 0) {
            checks.add(size);
        }
        Collections.sort(checks);
        if (checks.isEmpty()) {
            return false;
        }
        return checks.get(checks.size() - 1) >= 4;
    }

    private static void changeBalls() {
        ArrayList<Integer> newBalls = new ArrayList<>();
        int curType = 0, size = 0;
        for (int i = 0; i < ballNums.size(); i++) {
            if (curType != ballNums.get(i)) {
                if (curType != 0) {
                    newBalls.add(size);
                    newBalls.add(curType);
                }
                curType = ballNums.get(i);
                size = 0;
            }
            size++;
        }
        if (curType != 0) {
            newBalls.add(size);
            newBalls.add(curType);
        }

        ballNums = newBalls;
    }

    private static void resetGraph() {
        int length = nodes.size() - ballNums.size();
        if (length >= 0) {
            for (int i = 0; i < length; i++) {
                ballNums.add(0);
            }
        } else {
            for (int i = 0; i < length; i++) {
                ballNums.remove(ballNums.size() - 1);
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            Node now = nodes.get(i);
            int cur = ballNums.get(i);
            graph[now.x][now.y] = cur;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        getNodes();

        for (int i = 0; i < m; i++) {
            int d = sc.nextInt() - 1, s = sc.nextInt();
            blizzard(d, s);
            pull();
            while (checkBalls()) {
                burstBalls();
            }
            changeBalls();
            resetGraph();
            ballNums = new ArrayList<>();

        }

        System.out.println(answer[1] * 1 + answer[2] * 2 + answer[3] * 3);
    }
}