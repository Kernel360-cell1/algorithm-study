package yejin.song;

import java.io.*;

public class BOJ_NQueen {
    static int N;
    static int count;
    static int[][] map;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        count = 0;
        map = new int[N][N];

        //dfs
        // N*N map 만든 후, map[0][i] 선택했을 때, 위치하면 안되는 곳 map[][] -> ture 같이 만들어서 접근 못하게 하기
        // 재귀한 다음에는 map true-> false로 다시 바꿔주기

        // 다음 map[1][i] 접근해서 접근가능하면 동일하게 반복
        // 한 줄씩 끝날 때마다, 남은 줄 중 다 x가 있어서 가지 못하는 줄이 있는지 검사 -> 접근 못하면 return
        // depth == N 될 때까지 선택완료 했다면, count++;

        dfs(0);

        System.out.println(count);

    }

    static void dfs(int depth){ // depth == start_index
        // depth 종료조건 여부 체크
        if(depth == N){
            count ++;
            return;
        }

        for (int j = 0; j < N; j++){
            if(map[depth][j] == 0){ // 접근 가능하면
                // 자기 포함한 모든 가로, 세로, 대각선 노드 ++;
                changeMap(true,depth,j);

                // 재귀 함수 호출
                dfs(depth+1);

                // 다시 자기 포함한 모든 가로, 세로, 대각선 노드 --;
                changeMap(false,depth,j);
            }
        }

    }

    static void changeMap(boolean status, int x , int y){
        if(status){
            // 가로 세로
            for(int i =0 ; i<N; i++){
                map[x][i]++;
                map[i][y]++;
            }
            map[x][y]--;
            // 대각선

            int x_max = Math.max(N-x,x);
            int y_max = Math.max(N-y,y);
            int search_max = Math.max(x_max, y_max);

            for(int i = 1; i < search_max; i++){
                int plus = i;
                int minus = -i;

                if (x + plus >= 0 && x + plus < N && y + plus >= 0 && y + plus < N) map[x+plus][y+plus]++;
                if (x + plus >= 0 && x + plus < N && y + minus >= 0 && y + minus < N) map[x+plus][y+minus]++;
                if (x + minus >= 0 && x + minus < N && y + plus >= 0 && y + plus < N) map[x+minus][y+plus]++;
                if (x + plus >= 0 && x + plus < N && y + minus >= 0 && y + minus < N) map[x+plus][y+minus]++;
            }

        }else {
            for(int i =0 ; i<N; i++){
                map[x][i]--;
                map[i][y]--;
            }
            map[x][y]++;
            // 대각선

            for(int i = 1; i < N; i++){
                int plus = i;
                int minus = -i;

                if (x + plus >= 0 && x + plus < N && y + plus >= 0 && y + plus < N) map[x+plus][y+plus]--;
                if (x + plus >= 0 && x + plus < N && y + minus >= 0 && y + minus < N) map[x+plus][y+minus]--;
                if (x + minus >= 0 && x + minus < N && y + plus >= 0 && y + plus < N) map[x+minus][y+plus]--;
                if (x + plus >= 0 && x + plus < N && y + minus >= 0 && y + minus < N) map[x+plus][y+minus]--;
            }

        }

//        if (status) {
//            for (int i = 0; i < N; i++) {
//                if (i != x) map[x][i]++;
//                if (i != y) map[i][y]++;
//            }
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (i == x || j == y || i + j == x + y || i - j == x - y) {
//                        if (i != x || j != y) map[i][j]++;
//                    }
//                }
//            }
//        } else {
//            for (int i = 0; i < N; i++) {
//                if (i != x) map[x][i]--;
//                if (i != y) map[i][y]--;
//            }
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (i == x || j == y || i + j == x + y || i - j == x - y) {
//                        if (i != x || j != y) map[i][j]--;
//                    }
//                }
//            }
//        }

    }
}
