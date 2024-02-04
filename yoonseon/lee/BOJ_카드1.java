package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_카드1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}

		while (queue.size() > 1) {
			sb.append(queue.poll()+" ");
			queue.offer(queue.poll());
		}
		sb.append(queue.poll());

		System.out.println(sb);
	}
}
