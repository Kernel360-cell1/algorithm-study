package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCaseNum = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		for (int i=0; i<testCaseNum; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 인쇄할 문서가 몇번째에 있는지

			st = new StringTokenizer(br.readLine());
			Queue<int[]> queue = new LinkedList<>();
			for (int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(new int[]{j, num});
			}

			int count = 0;
			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				boolean isMax = true;

				for (int[] q : queue) {
					if (current[1] < q[1]) {
						isMax = false;
						break;
					}
				}

				if (isMax) {
					count++;
					if (current[0] == M) {
						sb.append(count+"\n");
						break;
					}
				} else {
					queue.offer(current);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
