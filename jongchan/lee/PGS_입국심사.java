package com.example.programmers.level3;

import java.util.Arrays;

public class PGS_입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1; //최소 시간
        long right = times[times.length - 1] * (long) n; // 최대 시간
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2; // 중간 시간
            long sum = 0;
            System.out.println("left: " + left + ", right: " + right);
            System.out.println("mid: " + mid);

            for (int time : times) {
                sum += mid / time;
                if (sum >= n) break;
            }
            if (sum < n) {
                left = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PGS_입국심사 solv = new PGS_입국심사();
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solv.solution(n, times));
    }
}
