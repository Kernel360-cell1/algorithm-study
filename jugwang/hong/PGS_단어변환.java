package jugwang.hong;

public class PGS_단어변환 {
    static int answer;
    static boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }

        //알파벳 한개만 다를 때 변경
        for (int i = 0; i< words.length; i++) {
            if (visit[i])
                continue;

            String word = words[i];
            int checkonediff = 0;

            for (int c = 0; c<begin.length(); c++) {
                if (begin.charAt(c) != word.charAt(c)) {
                    checkonediff += 1;
                }
            }

            if (checkonediff == 1) {
                visit[i] = true;
                dfs(word, target, words, count+1);
                visit[i] = false;
            }
        }
    }
}
