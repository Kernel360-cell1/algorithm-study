package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_도키도키간식드리미 {
	public static void main(String[] args) throws IOException {
		String answer = "Nice";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>(); // 대기열
		Stack<Integer> stack = new Stack<>(); // 추가대기열
		while (st.hasMoreTokens()) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}

		int number = 1;
		while (!queue.isEmpty()) {
			if (queue.peek() == number) {
				// 대기열중에 가장 적은 번호표라면 꺼냄
				queue.poll();
				number++;
			} else if (!stack.empty() && stack.peek() == number) {
				stack.pop();
				number++;
			} else {
				// 아니라면 추가 대기열에 넣음
				stack.push(queue.poll());
			}
		}

		while (!stack.isEmpty()) {
			// 추가 대기열의 가장 윗 사람이 번호표라면
			if (stack.peek() == number) {
				// 추가 대기열중에 가장 적은 번호표라면 꺼냄
				stack.pop();
				number++;
			} else {
				// 추가 대기열의 가장 윗 사람이 번호표 순서가 아니면 잘못된 순서로 판단
				answer = "Sad";
				break;
			}
		}

		System.out.println(answer);
	}
}
