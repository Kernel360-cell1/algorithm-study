package com.example.programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int L, C;
    static char[] alpabet;
    static boolean[] visited;
    static final char[] VOWEL = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        input();
        solution();
        br.close();
    }

    private static void solution() {
        for (int i = 0; i < alpabet.length; i++) {
            dfs(i, String.valueOf(alpabet[i]), 0, 0);
            Arrays.fill(visited, false);
        }
    }

    private static void dfs(int idx, String str, int v, int c) {
        visited[idx] = true;
        if (alpabetCheck(alpabet[idx])) ++v;
        else ++c;

        if (v + c == L) {
            if (v >= 1 && c >= 2)
                System.out.println(str);
            return;
        }

        for (int i = idx; i < alpabet.length; i++) {
            if (visited[i]) continue;
            dfs(i, str + alpabet[i], v, c);
            visited[i] = false;
        }
    }

    private static boolean alpabetCheck(char c) {
        for (char value : VOWEL) {
            if (value == c) return true;
        }
        return false;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        alpabet = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < alpabet.length; i++) {
            alpabet[i] = st.nextToken()
                    .charAt(0);
        }

        Arrays.sort(alpabet);
    }
}
