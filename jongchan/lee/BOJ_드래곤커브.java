package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 변수를 입력받는다.
 * 2. 점을 찍는다.
 * 3. 정사각형의 개수를 구한다.
 */
public class BOJ_드래곤커브 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int x, y, d, g;
    static boolean[][] graph = new boolean[101][101];
    static final int[][] MOVE = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 0,1,2,3
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            inputs(); //1
            drawDots(); //2
        }
        countSquare(); //3
        System.out.println(answer);
        br.close();
    }

    //정사각형 개수 구하기
    private static void countSquare() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (graph[i][j] && graph[i + 1][j] && graph[i][j + 1] && graph[i + 1][j + 1]) ++answer;
            }
        }
    }

    //점 찍기
    private static void drawDots() {
        List<Integer> directions = getDirections();
        graph[y][x] = true;
        directions.forEach(idx -> {
            y += MOVE[idx][0];
            x += MOVE[idx][1];
            graph[y][x] = true;
        });
    }

    //방향 구하기
    private static List<Integer> getDirections() {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int dir = (directions.get(i) + 1) % 4;
                directions.add(dir);
            }
        }
        return directions;
    }

    //입력 받기
    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
    }
}
