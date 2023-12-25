import java.io.*;
import java.util.*;

public class BOJ_리그오브레게노 {
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

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	static int N;
	static int cnt;
	// 인접 리스트를 해시 맵으로 지정,,,
	static HashMap<String, ArrayList<String>> graph = new HashMap<>();
	// 진입 차수를 해시 맵으로 지정,,,
	static HashMap<String, Integer> inDegree = new HashMap<>();
	// StringBuilder에 담아서 한 번에 출력
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		for (int i = 0; i < N; i++) {
			String item1 = fr.next();
			String item2 = fr.next();
			// 인접 리스트에 없으면 새로 담고, 연관 관계 이어주기
			graph.putIfAbsent(item1, new ArrayList<>());
			graph.putIfAbsent(item2, new ArrayList<>());
			graph.get(item1).add(item2);

			//진입차수에도 없으면 담고 새로 이어주기
			inDegree.putIfAbsent(item1, 0);
			inDegree.put(item2, inDegree.getOrDefault(item2, 0) + 1);
		}
		// 위상 정렬 구현
		topologySort();

		// 산 아이템의 수와 전체 아이템의 수가 다르면 -1
		if (cnt != graph.size()) {
			System.out.println(-1);
		} else {
			System.out.println(answer.toString());
		}
	}

	// 정점이 V, 간선이 E 라고 할때 위상 정렬을 O(V + E) 시간 복잡도를 갖고 있음
	private static void topologySort() {
		// 기본 큐, 우선 순위 큐를 사용해서 따로 문자열 정렬을 하지 않아도 됨
		PriorityQueue<String> q = new PriorityQueue<>();
		// 임시로 담을 큐
		PriorityQueue<String> temp = new PriorityQueue<>();

		// 처음에 진입 차수가 0인 아이템을 모두 우선순위 큐에 담음
		for (String key : inDegree.keySet()) {
			if (inDegree.get(key) == 0) {
				q.offer(key);
			}
		}

		// 큐가 비어있지 않은 동안
		while (!q.isEmpty()) {
			// 우선 순위 큐에서 첫 번째 아이템을 꺼내고
			String now = q.poll();
			// 답변 StringBuilder에 추가
			answer.append(now + "\n");
			// 산 아이템 갯수 증가
			cnt++;
			// 이 아이템 다음으로 살 수 있는 아이템들의 진입 차수를 1씩 감소
			for (String next : graph.get(now)) {
				inDegree.put(next, inDegree.get(next) - 1);
				// 진입차수가 다음으로 0인 아이템들을 임시 큐에 담음
				if (inDegree.get(next) == 0) {
					temp.offer(next);
				}
			}

			// 만약에 기본 큐가 비었다면
			if (q.isEmpty()) {
				// 임시 큐에 있는 아이템들을 기본 큐로 다시 담고 임시 큐를 비움
				q.addAll(temp);
				temp.clear();
			}
		}
	}
}
