package src.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//[G3] 주사위 굴리기2
public class BOJ_23288 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static int N, M, K;
    static int[][] MOVE = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 북, 동, 남, 서
    static Dice dice;
    static int dir = 1;
    static int answer = 0;
    static boolean[][] visited;

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
        System.out.println(answer);
    }

    private static void solv() {
        int y = 0, x = 0;
        while (K-- > 0) {
            if (isException(y + MOVE[dir][0], x + MOVE[dir][1])) {
                dir = (dir + 2) % 4;
            }
            y += MOVE[dir][0];
            x += MOVE[dir][1];

            rollDice();
            answer += bfs(y, x);
            dir = nextDirection(map[y][x]);
        }
    }

    public static int nextDirection(int n) {
        if (dice.bottom > n) {
            return (dir + 1) % 4;
        } else if (dice.bottom < n) {
            return (dir + 3) % 4;
        } else return dir;
    }

    private static int bfs(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        visited[y][x] = true;
        int target = map[y][x];
        int cnt = 1;

        while (!q.isEmpty()) {
            y = q.poll();
            x = q.poll();

            for (int[] move : MOVE) {
                int ny = y + move[0];
                int nx = x + move[1];

                if (isException(ny, nx)) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != target) continue;

                visited[ny][nx] = true;
                ++cnt;
                q.add(ny);
                q.add(nx);
            }
        }
        return cnt * target;
    }

    private static void rollDice() {
        Dice nextDice = new Dice();
        if (dir == 1) { // 오른쪽 방향으로 굴릴 경우
            nextDice = new Dice(dice.left, dice.front, dice.back, dice.bottom, dice.top, dice.right);
        } else if (dir == 4) { // 왼쪽 방향으로 굴릴 경우
            nextDice = new Dice(dice.right, dice.front, dice.back, dice.top, dice.bottom, dice.left);
        } else if (dir == 0) { // 위쪽 방향으로 굴릴 경우
            nextDice = new Dice(dice.front, dice.bottom, dice.top, dice.left, dice.right, dice.back);
        } else if (dir == 2) { // 아래쪽 방향으로 굴릴 경우
            nextDice = new Dice(dice.back, dice.top, dice.bottom, dice.left, dice.right, dice.front);
        }
        dice = nextDice;
    }

    private static boolean isException(int y, int x) {
        return x < 0 || y < 0 || x >= M || y >= N;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new Dice(0, 1, 2, 3, 4, 5);
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Dice {
        int top, front, back, left, right, bottom;

        public Dice(int top, int front, int back, int left, int right, int bottom) {
            this.top = top;
            this.front = front;
            this.back = back;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }

        public Dice() {
        }
    }
}
