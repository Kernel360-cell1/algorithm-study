package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_쉬운최단거리 {
    static int N,M;
    static int map[][];
    static boolean visited[][];
    static int start[];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // 맵 초기화
        for (int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new int[]{i,j};
                }
            }
        }
        bfs(start);

        for (int i = 0 ; i< N; i++){
            for (int j = 0; j<M; j++){
                if (!visited[i][j] && map[i][j]==1){
                    System.out.print("-1 ");
                }
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        map[start[0]][start[1]] = 0;
        q.add(start);

        while (!q.isEmpty()){
            int current[] = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i =0 ; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny]!=0){
                    map[nx][ny] = map[x][y] + 1;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }

    }
}
