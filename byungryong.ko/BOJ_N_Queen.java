import java.io.*;
import java.util.*;

public class BOJ_N_Queen{
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
	static int answer = 0;
	static int n;

	//chessBoard를 통해 퀸의 위치를 확인 i번째 행에 있는 수가 열임
	//chessBoard[i] = 4, i == 1 일때 퀸은 (4, 1)의 좌표에 존재
	static int[] chessBoard;

	private static void nQueen(int count) {
		// 보드위에 놓은 퀸의 개수가 n과 같으면 재귀 끝
		if (count == n) {
			answer++;
			return;
		}

		for (int i = 0; i < n; i++) {
			//check를 통해 퀸을 놓을 수 있는지 확인함
			boolean check = true;
			for (int j = 0; j < count; j++) {
				//이미 배치가 끝난 퀸의 자리를 참고해서 i번째 칸에 퀸을 놓을 수 있는 지 확인
				if (chessBoard[j] == i || Math.abs(count - j) == Math.abs(i - chessBoard[j])) {
					// j번째 줄에 있는 퀸과 같은 칸에 있거나, 대각선에 같은 곳에 있다면, i번째 칸에 대한 탐색을 중단
					check = false;
					break;
				}
			}
			if (check) {
				chessBoard[count] = i;
				nQueen(count + 1);
			}
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		n = fr.nextInt();
		chessBoard = new int[n];
		nQueen(0);
		System.out.println(answer);
	}
}
