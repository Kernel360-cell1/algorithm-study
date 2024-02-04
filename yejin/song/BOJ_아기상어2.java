package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_아기상어2 {
    // 전역 변수 선언
    static int map[][];
    static int N,M;
    static boolean visited[][];
    static int dx[] = {1, -1, -1, 1, 1, 0, -1, 0};
    static int dy[] = {1, 1, -1, -1, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        Queue<Shark> q = new LinkedList<>();

        // 맵 추기화, 큐 offer, 방문 처리
        for (int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    q.offer(new Shark(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Shark shark = q.poll();
            bfs(q, shark);
            if (q.isEmpty()){
                System.out.println(shark.length);
            }
        }
    }

    static void bfs(Queue<Shark> q, Shark shark){
        for (int i = 0; i<8; i++){
            int nx = dx[i] + shark.x;
            int ny = dy[i] + shark.y;

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]){
                q.offer(new Shark(nx,ny, shark.length + 1));
                visited[nx][ny] = true;
            }
        }
    }

    static class Shark {
        int x, y, length;
        Shark(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}
