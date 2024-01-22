import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_수들의합5 {
	static int N;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		int[] nums = new int[N + 1];

		nums[0] = 0;
		for (int i = 1; i <= N; i++) {
			nums[i] = nums[i - 1] + i;
		}
		int head = 0;
		int tail = 1;
		int answer = 0;

		while (head < tail) {
			int now = nums[tail] - nums[head];
			if (now == N) {
				answer++;
				head++;
			} else if (now < N) {
				tail++;
			} else {
				head++;
			}
		}

		System.out.println(answer);
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

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
