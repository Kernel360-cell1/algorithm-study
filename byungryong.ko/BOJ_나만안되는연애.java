import java.io.*;
import java.util.*;

public class BOJ_나만안되는연애 {
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

	static int n, m ;
	static String[] types;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	// 다음 대학교의 정보와 대학교 사이의 거리를 담고 있는 노드 객체 생성
	static class Node {
		int next, dist;

		public Node(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
	}

	private static int connect(int start) {
		//어느 학교에 방문한지 알기 위해서 visited 배열 사용
		boolean[] visited = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
		pq.add(new Node(start, 0));
		visited[start] = true;
		int distance = 0;


		while (!pq.isEmpty()) {
			Node node = pq.poll();
			String gender = types[node.next];
			//이미 방문 했다면 다음으로
			if (visited[node.next] && node.next != start) {
				continue;
			}
			distance += node.dist;
			visited[node.next] = true;
			//인접 리스트에서 노드를 꺼내온뒤에
			for (Node next : graph.get(node.next)) {
				//다른 성별이고 방문하지 않았다면 체크하고 거리에 더함
				if (!gender.equals(types[next.next]) && !visited[next.next]) {
					pq.add(new Node(next.next, next.dist));
				}
			}
			System.out.println(pq);
		}

		System.out.println(Arrays.toString(visited));

		// 만약에 방문하지 않은 대학교가 있다면
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				return -1;
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		// 입력 받기, 사용의 편의성을 위해 1 ~ n + 1까지로 지정
		n = fr.nextInt();
		m = fr.nextInt();
		types = new String[n + 1];
		for (int i = 1; i < n + 1; i++) {
			types[i] = fr.next();
		}

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 인접 리스트 생성
		for (int i = 0; i < m; i++) {
			int u = fr.nextInt(), v = fr.nextInt(), d = fr.nextInt();
			graph.get(u).add(new Node(v, d));
			graph.get(v).add(new Node(u, d));
		}

		// 생성 후 정렬
		for (int i = 1; i < n + 1; i++) {
			graph.get(i).sort((o1, o2) -> o1.dist - o2.dist);
		}

		System.out.println(connect(1));
	}
}
