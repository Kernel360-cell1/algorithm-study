package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_타일링 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n < 3) {
			System.out.println(n);
			return;
		}

		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for (int i=2; i<n; i++) {
			int result = arr[i-1] + arr[i-2];
			arr[i] = result % 10_007;
		}

		System.out.println(arr[n-1]);
	}
}
