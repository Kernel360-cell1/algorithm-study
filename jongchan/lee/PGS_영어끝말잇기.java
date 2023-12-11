package com.example.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class PGS_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int player = 1;
        int step = 1;
        Set<String> set = new HashSet<>();
        String prev = "";
        for (String word : words) {
            if (set.contains(word)) {
                return new int[]{player, step};
            } else if (!set.isEmpty() && prev.charAt(prev.length() - 1) != word.charAt(0)) {
                return new int[]{player, step};
            }
            set.add(word);
            prev = word;
            player++;
            if (player > n) {
                player = 1;
                step++;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        PGS_영어끝말잇기 solv = new PGS_영어끝말잇기();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = solv.solution(n, words);
        System.out.println(answer[0] + ", " + answer[1]);
    }
}
