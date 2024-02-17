package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_꿀아르바이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		long sum = 0;
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i<m) sum += arr[i];
		}
		long answer = sum;
		for (int i=m; i<n; i++) {
			sum += (arr[i] - arr[i-m]);
			answer = Math.max(sum, answer);
		}

		// 처음에 이렇게 풇었으나 위 방법으로 더 짧게 만들 수 있음
		// int lt = 0, rt = m-1;
		// while (rt < n-1) {
		// 	sum -= arr[lt];
		// 	sum += arr[rt+1];
		// 	answer = Math.max(answer, sum);
		// 	lt++;
		// 	rt++;
		// }

		System.out.println(answer);
	}
}
