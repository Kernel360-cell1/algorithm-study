package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_경쟁적전염 {
    static int map[][];
    static int N,K,S,X,Y;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        Queue<Virus> q = new LinkedList<>();

        Comparator<Virus> comparator = (v1, v2) -> v1.type - v2.type;
        ArrayList<Virus> list = new ArrayList<>();

        // 맵 초기화
        for (int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new Virus(map[i][j], i, j, 0));
                }
            }
        }
        Collections.sort(list, comparator);

        for (Virus virus : list){
            q.offer(virus);
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());


        // S 시간까지 진행
        while (!q.isEmpty() && q.peek().time < S) {
            Virus virus = q.poll();
            if (virus.time == S) break;
            bfs(virus, q);
        }

        System.out.println(map[X-1][Y-1]);
    }

    public static void bfs(Virus virus, Queue<Virus> q){

        for (int i = 0; i < 4; i++) {
            int nx = virus.x + dx[i];
            int ny = virus.y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                map[nx][ny] = virus.type;
                q.offer(new Virus(virus.type, nx, ny, virus.time + 1));
            }
        }
    }

    static class Virus {
        int type, x, y, time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
