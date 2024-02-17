package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_우당탕탕영화예매 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] seats = new String[N];
		for (int i=0; i<N; i++) {
			seats[i] = br.readLine();
		}
		String emptySeat = "";
		for (int i=0; i<K; i++) {
			emptySeat += "0";
		}

		int answer = 0;
		for (String seat : seats) {
			int rt = K;
			String temp = seat.substring(0, K);
			if (temp.equals(emptySeat))
				answer++;
			while (rt < M) {
				temp = temp.substring(1, K);
				temp += seat.charAt(rt);
				if (temp.equals(emptySeat))
					answer++;
				rt++;
			}
		}
		System.out.println(answer);
	}
}
/*
문제
도은이는 동아리 문화의 날을 맞이하여 동아리원들과 함께 좌석이 M행 N열의 직사각형 모양으로 배치되어 있는 영화관에서 영화를 보기로 했다. 도은이는 동아리원의 유대감을 중요하게 생각하기 때문에 이미 예매가 완료된 좌석을 피해 동아리원들이 모두 가로로 이어서 앉을 수 있도록 자리를 예매하고 싶어 한다. 도은이를 도와 모든 동아리원들이 가로로 이어서 앉을 수 있도록 예매하는 경우의 수는 총 몇 가지가 있을지 구해보자. 단, 예매한 좌석은 동일하지만, 각 사람이 앉는 위치만 바뀌는 경우는 한 가지로 본다.

입력
첫째 줄에 영화관 세로줄의 개수 N(1 <= N <= 1000)과 가로줄의 개수 M(1 <= M <= 5000), 영화를 관람할 동아리원의 수 K(1 <= K <= 10)가 주어진다.
둘째 줄부터 N 개의 줄에 걸쳐 그중 i번째 줄에는 i번째 열의 좌석 예매 현황이 길이 M인 문자열로 주어진다. 이 문자가 '0'이라면 예매 가능한 빈 좌석을, 이 문자가 '1'이라면 예매가 완료되어 예매가 불가능한 좌석을 나타낸다.

출력
동아리원들이 모두 가로로 이어서 앉을 수 있도록 영화를 예매하는 경우의 수를 출력한다. 단, 문제에서 주어진 조건에 맞게 영화를 예매할 수 있는 방법이 없다면
0을 출력한다.

예제 입력

3 5 3
11000
01010
10000

예제 출력
3
 */
