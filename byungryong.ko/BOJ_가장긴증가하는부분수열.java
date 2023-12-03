import java.util.*;
import java.io.*;

public class BOJ_가장긴증가하는부분수열 {
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

	static int n;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		n = sc.nextInt();
		ArrayList<Integer> nums = new ArrayList<>();
		int[] result = new int[n];
		Arrays.fill(result, 1);
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			nums.add(a);
		}

		for (int i = 0; i < n; i++) {
			int a = nums.get(i);
			for (int j = 0; j <= i - 1; j++) {
				int b = nums.get(j);
				if (a > b) {
					result[i] = Math.max(result[j] + 1, result[i]);
				}
			}
		}

		System.out.println(Arrays.stream(result).max().orElse(0));
	}
}