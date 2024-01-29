package com.example.programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20058 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, Q;
    static int[] L;
    static int[][] arr;
    static boolean[][] visited;
    static int total, max;
    static final int[][] MOVE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        input();
        solution();
        System.out.println(sb);
        br.close();
    }

    private static void solution() {
        for (int i = 0; i < L.length; i++) {
            arr = rotate(L[i]);
            arr = fireBreath();
        }
        findtotal();
    }

    private static void findtotal() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += arr[i][j];
                if (arr[i][j] <= 0 || visited[i][j]) continue;
                q.add(i);
                q.add(j);
                visited[i][j] = true;
                int cnt = 1;

                while (!q.isEmpty()) {
                    int y = q.poll();
                    int x = q.poll();

                    for (int[] move : MOVE) {
                        int ny = y + move[0];
                        int nx = x + move[1];

                        if (outOfIndex(ny, nx)) continue;
                        if (arr[ny][nx] <= 0 || visited[ny][nx]) continue;

                        visited[ny][nx] = true;
                        q.add(ny);
                        q.add(nx);
                        ++cnt;
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        sb.append(total)
                .append('\n');
        sb.append(max);
    }

    private static int[][] fireBreath() {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmp[i] = Arrays.copyOf(arr[i], N);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) continue;
                int cnt = 0;

                for (int[] move : MOVE) {
                    int ny = i + move[0];
                    int nx = j + move[1];
                    if (outOfIndex(ny, nx)) continue;
                    if (arr[ny][nx] > 0) ++cnt;
                }
                if (cnt < 3) tmp[i][j]--;
            }
        }

        return tmp;
    }

    private static boolean outOfIndex(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    private static int[][] rotate(int level) {
        int[][] tmp = new int[N][N];
        level = (int) Math.pow(2, level);

        for (int i = 0; i < N; i += level) {
            for (int j = 0; j < N; j += level) {
                move(i, j, level, tmp);
            }
        }
        return tmp;
    }

    private static void move(int y, int x, int level, int[][] tmp) {
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                tmp[y + i][x + j] = arr[y + level - 1 - j][x + i];
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        L = new int[Q];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
    }
}
