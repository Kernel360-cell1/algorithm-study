import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_피보나치수6 {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
	}

	// 모듈러 설정
	static BigInteger modular = new BigInteger("1000000007");
	//메모이제이션 활용하기,,, 아니면 시간복잡도 터짐
	static HashMap<BigInteger, BigInteger> map = new HashMap<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		String n = fr.next();
		BigInteger target = new BigInteger(n);
		// 기본 피보나치 값 2개 담기
		map.put(BigInteger.ONE, BigInteger.ONE);
		map.put(BigInteger.ZERO, BigInteger.ZERO);
		System.out.println(fibonacci(target));
	}

	// 분할 정복을 이용한 피보나치 수 찾기 구현..
	private static BigInteger fibonacci(BigInteger n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		// 새로운 BigInteger 선언
		BigInteger result;
		// 양수일 때
		if ((n.mod(BigInteger.TWO)).equals(BigInteger.ZERO)) {
			BigInteger half = n.divide(BigInteger.TWO);
			BigInteger fibonacci = fibonacci(half);
			BigInteger fibonacciSubtractOne = fibonacci(half.subtract(BigInteger.ONE));
			result = fibonacciSubtractOne.multiply(BigInteger.TWO)
				.add(fibonacci)
				.multiply(fibonacci)
				.mod(modular);
		} else {
			// 음수일 때
			BigInteger half = n.add(BigInteger.ONE).divide(BigInteger.TWO);
			BigInteger fibonacci = fibonacci(half);
			BigInteger fibonacciSubtractOne = fibonacci(half.subtract(BigInteger.ONE));
			result = fibonacci.pow(2).add(fibonacciSubtractOne.pow(2)).mod(modular);
		}

		map.put(n, result); // 메모이제이션
		return result;
	}
}