package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_섬의개수 {
	static int[] dx = {-1, 1, 0, 0, -1,-1, 1, 1};
	static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
	static boolean[][] visited;
	static int W, H;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = "";
		while (!(str = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(str);
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			visited = new boolean[H][W];
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count+"\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i=0; i<8; i++) {
			int current_x = x + dx[i];
			int current_y = y + dy[i];

			if (current_x >= 0 && current_y >= 0 && current_x < H && current_y < W) {
				if (!visited[current_x][current_y] && map[current_x][current_y] == 1) {
					dfs(current_x, current_y);
				}
			}
		}
	}
}
