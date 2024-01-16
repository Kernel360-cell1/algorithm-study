import java.io.*;
import java.util.*;

public class BOJ_봄버맨 {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	static int R, C, N;
	static char[][] graph;
	static int[][] time;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void boom(int x, int y, int count) {
		graph[x][y] = '.';
		time[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if (count - time[nx][ny] != 3) {
					graph[nx][ny] = '.';
					time[nx][ny] = -1;
				}
			}
		}
	}

	private static void plant(int count) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (graph[i][j] != 'O') {
					graph[i][j] = 'O';
					time[i][j] = count;
				}
			}
		}
	}

	private static void activate(int count) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (graph[i][j] == 'O' && count - time[i][j] == 3) {
					boom(i, j, count);
				}
			}
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		R = fr.nextInt();
		C = fr.nextInt();
		N = fr.nextInt();

		graph = new char[R][C];
		time = new int[R][C];
		for (int i = 0; i < R; i++) {
			String line = fr.next();
			Arrays.fill(time[i], -1);
			for (int j = 0; j < line.length(); j++) {
				graph[i][j] = line.charAt(j);
				time[i][j] = 0;
			}
		}

		int count = 1;

		while (count < N) {
			count++;
			if (count % 2 == 0) {
				plant(count);
			} else {
				activate(count);
			}
			// printG();
		}

		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(graph[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void printG() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("____________________");
	}
}