package jugwang.hong;

public class PGS_피로도 {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int cnt, int health, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] || dungeons[i][0] > health) continue;
            visited[i] = true;
            dfs(cnt+1, health-dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(cnt, answer);
    }

}
