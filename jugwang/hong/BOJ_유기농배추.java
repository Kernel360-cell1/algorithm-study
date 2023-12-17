package jugwang.hong;
import java.io.*;
import java.util.*;


public class BOJ_유기농배추 {

    static int n, m, result;
    static int[][] cabbageField;
    static int[] cabbageX; // 양배추 위치 x 좌표를 저장하는 배열
    static int[] cabbageY; // 양배추 위치 y 좌표를 저장하는 배열
    static int cabbageCount; // 양배추 위치의 수를 저장하는 변수



    public static void main(String[] args) throws IOException {

        // Simulating the provided example
//        String exampleInput = "2\n" +
//                "10 8 17\n" +
//                "0 0\n" +
//                "1 0\n" +
//                "1 1\n" +
//                "4 2\n" +
//                "4 3\n" +
//                "4 5\n" +
//                "2 4\n" +
//                "3 4\n" +
//                "7 4\n" +
//                "8 4\n" +
//                "9 4\n" +
//                "7 5\n" +
//                "8 5\n" +
//                "9 5\n" +
//                "7 6\n" +
//                "8 6\n" +
//                "9 6\n" +
//                "10 10 1\n" +
//                "5 5";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Simulating input using exampleInput string instead of reading from System.in
//        br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(exampleInput.getBytes())));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수


        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 양배추 위치의 수

            n = M;
            m = N;
            result = 0;
            cabbageField = new int[M][N]; // 양배추 밭 생성
            cabbageX = new int[K]; // 양배추 x 좌표를 저장할 배열 생성
            cabbageY = new int[K]; // 양배추 y 좌표를 저장할 배열 생성
            cabbageCount = K; // 양배추 위치의 수 설정

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 양배추 위치 x 좌표
                int Y = Integer.parseInt(st.nextToken()); // 양배추 위치 y 좌표
                cabbageX[k] = X; // x 좌표를 배열에 저장
                cabbageY[k] = Y; // y 좌표를 배열에 저장
                cabbageField[X][Y] = 1; // 밭에서 양배추 위치를 1로 표시
            }


            // 양배추 밭 처리 (출력하거나 다른 작업 수행 가능)
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(cabbageField[i][j] + " "); // 양배추 밭 출력
//                }
//                System.out.println();
//            }

            // for 으로 양배추 좌표만 체크한다. cabbageField[X][Y] = 1 이면 bfs 를 돌린다
            for (int i = 0; i < cabbageCount; i++) {
                int a = cabbageX[i];
                int b = cabbageY[i];


                if (cabbageField[a][b] == 1) {
                    bfs(a,b);
                    result++;
                }
            }

            System.out.println(result);

        }
    }

    // 여기 bfs 메서드
    // 주변 칸이 1이고 배추밭을 넘지 않으면 0 으로 바꾼다
    static void bfs(int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        cabbageField[startX][startY] = 0;

        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && cabbageField[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    cabbageField[nx][ny] = 0;
                }
            }
        }
    }
}
