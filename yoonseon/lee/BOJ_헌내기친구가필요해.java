package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_헌내기친구가필요해 {
	static int N, M, person_count;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] visited;
	static Point doyeon_position;
	static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		input_BufferedReader();

		Queue<Point> q = new LinkedList<>();
		q.offer(doyeon_position);
		visited[doyeon_position.x][doyeon_position.y] = true;

		while(!q.isEmpty()) {
			Point current_point = q.poll();
			for (int i=0; i<4; i++) {
				// 현재위치 기준 동서남북으로 이동할 다음좌표를 확인한다.
				int next_x = current_point.x + dx[i];
				int next_y = current_point.y + dy[i];

				// 이동할 다음좌표가 이동할 수 있는 좌표인지 확인한다.
				if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < M) {

					// 다음좌표가 이미 방문했던 곳 또는 벽 이라면 방문하지 않는다.
					if (visited[next_x][next_y] || map[next_x][next_y] == 'X')
						continue;

					// 다음좌표가 'P' 라면 count를 증가시킨다.
					if (map[next_x][next_y] == 'P')
						person_count++;

					// 다음좌표로 이동하면 해당 좌표의 동서남북 좌표를 queue에 넣는다.
					q.offer(new Point(next_x, next_y));
					visited[next_x][next_y] = true;
				}
			}
		}

		if (person_count == 0)
			System.out.println("TT");
		else
			System.out.println(person_count);

	}

	public static void input_Scanner() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i=0; i<N; i++) {
			String s = sc.nextLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I') {
					doyeon_position = new Point(i, j);
				}
			}
		}
	}

	public static void input_BufferedReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s_input[] = br.readLine().split(" ");
		N = Integer.parseInt(s_input[0]);
		M = Integer.parseInt(s_input[1]);
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I')
					doyeon_position = new Point(i, j);
			}
		}
	}
}
