package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_토마토 {
    static boolean visited[][];
    static int map[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); //6
        N = Integer.parseInt(st.nextToken()); //4

        int days = 0;

        visited = new boolean[N][M];
        map = new int[N][M]; //int[4][6]

        int zeroCount = 0;
        queue = new LinkedList<>();

        // 맵 초기화
        // 1인 경우(익은 토마토) 시작점이므로 큐에 넣기
        for (int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j< M; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 0) zeroCount++;
                else if (value == 1) {
                    visited[i][j] = true;
                    queue.add(new Tomato(i,j,0)); // 좌표값을 담는다.
                }
                // 1,5 (N,M)
            }
        }

        // 최초 초기화된 맵에 0이 없는 경우 : 0 출력
        if(zeroCount == 0) {
            System.out.println(0);
            return;
        }else if(queue.isEmpty()){ // 익은 토마토(1)가 입력되지 않은 경우
            System.out.println(-1);
            return;
        }

        // 큐에 담길 때마다 기존 큐 day++;
        while (!queue.isEmpty()){
            Tomato tomato = queue.poll();
            bfs(tomato);
            if (queue.isEmpty()) days = tomato.day;
        }

        for (int i = 0; i<N; i++){
            for (int j =0; j<M; j++){
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);
    }

    static void bfs(Tomato tomato){
        int x = tomato.x;
        int y = tomato.y;
        int day = tomato.day;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 탐색 좌표가 조건에 만족한다면 (탐색좌표가 0<= 좌표 <N/M , visited가 false, 좌표에 해당하는 값이 0 )
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 0){
                map[nx][ny] = 1;
                visited[nx][ny] = true;
                queue.add(new Tomato(nx, ny, day+1));
            }
        }
    }

    static class Tomato{
        int x, y, day;

        public Tomato(int x,int y,int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
