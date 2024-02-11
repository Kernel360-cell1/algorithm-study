package minhyeop.kim;

import java.util.ArrayList;

public class PGS_순위 {
    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> winList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> loseList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            winList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }
        for (int[] temp : results) {
            int win = temp[0];
            int lose = temp[1];

            winList.get(lose).add(win);
            loseList.get(win).add(lose);
        }

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            ArrayList<Integer> winNow = new ArrayList<>(winList.get(i));
            ArrayList<Integer> loseNow = new ArrayList<>(loseList.get(i));
            ArrayList<Integer> winBef = new ArrayList<>(winList.get(i));
            ArrayList<Integer> loseBef = new ArrayList<>(loseList.get(i));

            while(!winNow.isEmpty() || !loseNow.isEmpty()) {
                ArrayList<Integer> winNext = new ArrayList<>();
                ArrayList<Integer> loseNext = new ArrayList<>();

                for (Integer k : winNow) {
                    ArrayList<Integer> winTemp = winList.get(k);
                    for (int j : winTemp) {
                        if (!winBef.contains(j)) {
                            winNext.add(j);
                            winBef.add(j);
                        }
                    }
                }

                for (Integer k : loseNow) {
                    ArrayList<Integer> loseTemp = loseList.get(k);
                    for (int j : loseTemp) {
                        if (!loseBef.contains(j)) {
                            loseNext.add(j);
                            loseBef.add(j);
                        }
                    }
                }

                winNow = new ArrayList<>(winNext);
                loseNow = new ArrayList<>(loseNext);
            }

            if (winBef.size() + loseBef.size() == n - 1) answer++;
        }

        return answer;
    }
}

// 플로이드 와샬(Floyd-warshall algorithm) 풀이
/*class Solution {
    public int solution(int n, int[][] results) {

        int[][] floyd = new int[n][n];
        for (int i = 0; i < n; i++) {
            floyd[i][i] = 2;
        }
        for (int[] result : results) {
            int win = result[0] - 1;
            int lose = result[1] - 1;

            floyd[win][lose] = 1;
            floyd[lose][win] = -1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(floyd[i][k] == 1 && floyd[j][k] == -1){
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    if(floyd[i][k] == -1 && floyd[j][k] == 1){
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0 ; i < n; i++) {
            boolean canRate = true;
            int index = 0;
            while (index < n) {
                if (floyd[index++][i] == 0) {
                    canRate = false;
                    break;
                }
            }
            if (canRate == true) answer++;
        }

        return answer;
    }
}*/
