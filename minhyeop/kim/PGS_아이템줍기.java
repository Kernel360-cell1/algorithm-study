package minhyeop.kim;

import java.util.*;

public class PGS_아이템줍기 {
    int[][] gone = new int[52][52];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Set<String> lines = new HashSet<>();
        for (int[] rect : rectangle) {
            for (int i = 0; rect[3] - i != rect[1]; i++) {
                float value = rect[3] - i - 0.5f;
                lines.add((float)rect[0] + " " + value);
                lines.add((float)rect[2] + " " + value);
            }
            for (int i = 0; rect[2] - i != rect[0]; i++) {
                float value = rect[2] - i - 0.5f;
                lines.add(value + " " + (float)rect[1]);
                lines.add(value + " " + (float)rect[3]);
            }
        }

        ArrayList<String> removeList = new ArrayList<>();
        for (String line : lines) {
            float tx = Float.valueOf(line.split(" ")[0]);
            float ty = Float.valueOf(line.split(" ")[1]);
            for (int[] rect : rectangle) {
                if (rect[0] < tx && tx < rect[2] && rect[1] < ty && ty < rect[3]) {
                    removeList.add(line);
                }
            }
        }
        for (String rem : removeList) {
            lines.remove(rem);
        }

        int answer = bfs(characterX, characterY, itemX, itemY, lines);;
        return answer;
    }

    private int bfs(int characterX, int characterY, int itemX, int itemY, Set<String> lines) {
        int count = -1;
        boolean find = false;

        Queue<int[]> nows = new LinkedList<>();
        Queue<int[]> nexts = new LinkedList<>();
        nows.add(new int[]{characterX, characterY});
        gone[characterX][characterY] = 1;

        while (!find) {
            count++;

            while(!nows.isEmpty()) {
                int[] now = nows.poll();

                int x = now[0];
                int y = now[1];
                gone[x][y] = 1;

                if (x == itemX && y == itemY) {
                    find = true;
                    break;
                }

                int[] dx = new int[]{0, 0, 1, -1};
                float[] fx = new float[]{0, 0, +0.5f, -0.5f};
                int[] dy = new int[]{1, -1, 0, 0};
                float[] fy = new float[]{+0.5f, -0.5f, 0, 0};

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    float nfx = x + fx[i];
                    float nfy = y + fy[i];

                    if (0 < nx && nx < 51 && 0 < ny && ny < 51 && gone[nx][ny] != 1 && lines.contains(nfx + " " + nfy)) {
                        if (nexts.contains(new int[]{nx, ny})) continue;
                        nexts.add(new int[]{nx, ny});
                    }
                }
            }

            nows = new LinkedList<>(nexts);
            nexts = new LinkedList<>();
        }
        return count;
    }
}
