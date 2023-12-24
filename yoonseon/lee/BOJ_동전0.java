package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] readLine = br.readLine().split(" ");
		int N = Integer.parseInt(readLine[0]);
		int K = Integer.parseInt(readLine[1]);
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		for(int i=N-1; i>=0; i--) {
			if (K >= arr[i]) {
				count += (K/arr[i]);
				K -= (K/arr[i]) * arr[i]; // K = K % arr[i]와 동일
			}
		}

		System.out.println(count);
	}
}
