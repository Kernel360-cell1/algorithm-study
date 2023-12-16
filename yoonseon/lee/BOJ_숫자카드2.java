package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());
		int M = Integer.parseInt(br.readLine());
		int[] targetArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
		}

		for (int i=0; i<M; i++) {
			if (map.containsKey(targetArr[i])) {
				sb.append(map.get(targetArr[i])+" ");
			} else {
				sb.append("0 ");
			}
		}

		System.out.println(sb.substring(0,sb.length()-1));

	}
}
