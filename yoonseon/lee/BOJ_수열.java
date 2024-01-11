package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String[] split = s1.split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);

		String s2 = br.readLine();
		int[] arr = Arrays.stream(s2.split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int lt = 0;
		int rt = K;
		ArrayList<Integer> sums = new ArrayList<>();
		while(rt<=N) {
			int sum = 0;
			for (int i=lt; i<rt; i++) {
				sum += arr[i];
			}
			sums.add(sum);
			lt++;
			rt++;
		}

		Integer max = sums.stream()
			.max(Integer::compare)
			.get();

		System.out.println(max);
	}
}
