package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_주식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			long result = 0;
			int max = 0;
			for (int j=N-1; j>=0; j--) {
				max = Math.max(max, arr[j]);
				if (j == N-1) continue;
				if (max - arr[j] > 0) {
					result += max-arr[j];
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
