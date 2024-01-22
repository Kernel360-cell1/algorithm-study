import java.io.*;
import java.util.*;

public class BOJ_쇠막대기 {
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

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static void main(String[] args) {
		FastReader fr = new FastReader();

		LinkedList<Character> stack = new LinkedList<>();

		String input = fr.next();
		int answer = 0;

		if (input.length() == 2) {
			System.out.println(0);
		} else {
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c == '(') {
					if (input.charAt(i + 1) == ')') {
						answer += stack.size();
					} else {
						stack.add(c);
					}
				} else if (c == ')' && input.charAt(i - 1) != '(') {
					stack.removeLast();
					answer++;

				}
				System.out.println("stack = " + stack);
			}
			System.out.println(answer);
		}
	}
}