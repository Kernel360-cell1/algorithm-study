package yejin.song;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_트리의부모찾기{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) // tree 초기화 -> 노드 번호 = 인덱스로 하기 위해 n+1로 생성
            tree.add(new ArrayList<>());

//        System.out.println(tree);

        // tree에 그래프를 입력한다.
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
//            System.out.println("i" + i);
//            System.out.println("for: " +tree);
        }

        boolean[] visited = new boolean[n+1]; // 방문 여부 확인용 배열
        int[] parentNode = new int[n+1]; // 부모 노드 저장 배열

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int node : tree.get(v))
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    parentNode[node] = v; // 부모 노드 찾은 후 저장
                }
        }

        // 루트 노드를 제외한 나머지 노드의 부모 노드 출력
        for (int i = 2; i < n+1; i++)
            System.out.println(parentNode[i]);
    }
}

