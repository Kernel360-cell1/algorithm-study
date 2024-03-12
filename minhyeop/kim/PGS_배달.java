package minhyeop.kim;

import java.util.HashSet;

class PGS_배달 {
    static int[] answer;
    static int n;
    static int k;
    static int[][] arr;

    public int solution(int N, int[][] road, int K) {

        arr = new int[N + 1][];
        for (int i = 1; i <= N; i++) {
            arr[i] = new int[N + 1];
        }

        for (int[] roa : road) {
            if (arr[roa[0]][roa[1]] > roa[2] || arr[roa[0]][roa[1]] == 0) {
                arr[roa[0]][roa[1]] = roa[2];
                arr[roa[1]][roa[0]] = roa[2];
            }
        }

        answer = new int[N + 1];
        n = N;
        k = K;

        HashSet<Integer> gone = new HashSet<>();
        gone.add(1);
        deliver(1, 0, gone);

        int count = 1;
        for (int i = 2; i < n + 1; i++) {
            if (answer[i] != 0) count++;
        }

        return count;
    }

    private void deliver(int now, int time, HashSet<Integer> gone) {

        for (int i = 1; i < n + 1; i++) {
            if (!gone.contains(i) && arr[now][i] != 0) {
                if (time + arr[now][i] > k) continue;
                if (answer[i] > time + arr[now][i] || answer[i] == 0) {
                    answer[i] = time + arr[now][i];
                } else if (answer[i] != 0 && answer[i] < time + arr[now][i]) {
                    continue;
                }
                gone.add(i);
                deliver(i, time + arr[now][i], gone);
                gone.remove(i);
            }
        }
    }
}
