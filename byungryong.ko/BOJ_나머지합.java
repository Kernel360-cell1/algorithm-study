import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_나머지합 {
	static int N, M;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		HashMap<Long, Long> sumMaps = new HashMap<>();
		long[] sumArr = new long[N];
		long total = 0;
		long answer = 0;
		for (int i = 0; i < N; i++) {
			long now = fr.nextLong();
			total += now % M;
			sumMaps.put(total % M, sumMaps.getOrDefault(total % M, 0L) + 1);
			sumArr[i] = total;
		}

		for (long key : sumMaps.keySet()) {
			if (key == 0) {
				answer += sumMaps.get(key);
			}
			answer += comb(sumMaps.get(key));
		}

		System.out.println(answer);
	}

	private static long comb(long n) {
		if (n < 2) {
			return 0;
		}
		return n * (n - 1) / 2;
	}

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

		long nextLong() {
			return Long.parseLong(next());
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
