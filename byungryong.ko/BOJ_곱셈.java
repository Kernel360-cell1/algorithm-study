import java.util.*;
import java.io.*;

public class BOJ_곱셈 {
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
	}

	private static long fPow(long number, long times, long c) {
		if (times == 1) {
			return number % c;
		} else {
			long next = fPow(number, times / 2, c) % c;
			if (times % 2 == 0) {
				return next * next % c;
			} else {
				return (next * next) % c * number % c;
			}
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long a = fr.nextLong(), b = fr.nextLong(), c = fr.nextLong();
		System.out.println(fPow(a, b, c));
	}
}