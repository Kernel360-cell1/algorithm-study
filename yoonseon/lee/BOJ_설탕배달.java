package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_설탕배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		while (N%5!=0) {
			N -= 3;
			answer++;
		}
		if (N<0) {
			answer = -1;
		} else {
			answer += N/5;
		}
		System.out.println(answer);
	}
}
