import java.util.*;
import java.io.*;

public class BOJ_임시반장정하기 {
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	static int n;
	static ArrayList<HashSet<Integer>> students = new ArrayList<>();
	static int[][] graph;


	public static void main(String[] args) {
		FastReader fr = new FastReader();
		n = fr.nextInt();
		graph = new int[n][5];

		//입력 값 받기
		for (int i = 0; i < n; i++) {
			students.add(new HashSet<>());
			for (int j = 0; j < 5; j++) {
				graph[i][j] = fr.nextInt();
			}
		}

		//1학년 ~ 5학년까지
		for (int i = 0; i < 5; i++) {
			// 같은 반에 속했었는지 확인
			for (int j = 0; j < n; j++) {
				int classNumber = graph[j][i];
				for (int k = 0; k < n; k++) {
					//동일 인물이 아니고 같은 반일때
					if (j != k && classNumber == graph[k][i]) {
						students.get(j).add(k);
					}
				}
			}
		}

		System.out.println(students.stream()
			.max((set1, set2) -> set1.size() - set2.size())
			.map(students::indexOf)
			.orElse(1)
			+ 1);
	}
}