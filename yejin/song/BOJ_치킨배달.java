package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_치킨배달 {
    static int N;
    static int M;
    static ArrayList<int[]> home;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> comb;

    static int[][] dist;

    public static void main(String[] args) throws IOException {

        // 맵 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        comb = new ArrayList<>();


        // 1(집)의 배열 따로 담기
        // 2(치킨집)의 배열 따로 담기
        for (int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j< N; j++){
                int value = Integer.parseInt(st.nextToken());
                // 0이면 반복문 탈출하도록
                if (1 == value) {
                    home.add(new int[]{i,j});
                }
                else if (2 == value){
                    chicken.add(new int[]{i,j});
                }
            }
        }

        // 모든 치킨집-집 거리 구하기
        dist = new int[chicken.size()][home.size()];
        for (int i = 0; i< chicken.size(); i++){
            for (int j = 0; j< home.size(); j++){

                int chic[] = chicken.get(i);
                int hom[] = home.get(j);

                int sero = Math.abs(chic[0] - hom[0]);
                int garo= Math.abs(chic[1] - hom[1]);

                dist[i][j] = sero + garo;
            }
        }

        // 치킨집 인덱스 기준으로 M개 뽑기 (조합)
        int[] result = new int[M];
        combination(chicken.size(), result,0,0);

        // 각 조합별 최소거리 결과 담을 배열
        int result_dist[] = new int[comb.size()];

        // comb.size()만큼 돌면서 최소 거리 구하기
        for (int i = 0; i< comb.size(); i++){
            int pick[] = comb.get(i);
            int min_dist[] = new int[home.size()];
            Arrays.fill(min_dist, 100); //큰 수로 초기화

            // 각 집 인덱스 (0,...) 별로 dist 돌아가며 비교
            for (int z = 0 ; z< home.size(); z++){
                for(int j = 0; j< pick.length; j++){
                    int index = pick[j];
                    int dist_value = dist[index][z];
                    min_dist[z] = Math.min(min_dist[z], dist_value);
                }
            }
            result_dist[i] = Arrays.stream(min_dist).sum();
        }

        // 각 조합 별로 구한 최소 거리를 오름차순 정렬 -> 즉, 최종적인 최소 거리 구함.
        Arrays.sort(result_dist);

        System.out.println(result_dist[0]);
    }

    static void combination(int index_size, int[] result, int start, int depth){
        // 종료 조건
        if (depth == result.length){
            int[] copy = Arrays.copyOf(result, result.length);
            comb.add(copy);
            return;
        }

        for (int i = start; i < index_size ; i++){ // 인덱스만큼 반복하기
            result[depth] = i;
            combination(index_size, result, i+1, depth+1);
        }
    }
}

