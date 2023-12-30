package jugwang.hong;

import java.io.*;
import java.util.*;

public class BOJ_트리순회 {

    static Map<String, List<String>> map = new HashMap<>(); // 각 노드의 자식 정보를 저장하는 맵

    // 전위 순회
    private static void preorder(String v) {
        if (v.equals(".")) return; // 노드가 없는 경우 return

        System.out.print(v); // 노드 출력
        preorder(map.get(v).get(0)); // 왼쪽 자식 노드로 이동하여 전위 순회
        preorder(map.get(v).get(1)); // 오른쪽 자식 노드로 이동하여 전위 순회
    }

    // 중위 순회
    private static void inorder(String v) {
        if (v.equals(".")) return; // 노드가 없는 경우 return

        inorder(map.get(v).get(0)); // 왼쪽 자식 노드로 이동하여 중위 순회
        System.out.print(v); // 노드 출력
        inorder(map.get(v).get(1)); // 오른쪽 자식 노드로 이동하여 중위 순회
    }

    // 후위 순회
    private static void postorder(String v) {
        if (v.equals(".")) return; // 노드가 없는 경우 return

        postorder(map.get(v).get(0)); // 왼쪽 자식 노드로 이동하여 후위 순회
        postorder(map.get(v).get(1)); // 오른쪽 자식 노드로 이동하여 후위 순회
        System.out.print(v); // 노드 출력
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수 입력

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("\\s"); // 노드 정보 입력 및 공백으로 분리
            List<String> list = new ArrayList<>();

            list.add(tmp[1]); // 왼쪽 자식 노드 정보 저장
            list.add(tmp[2]); // 오른쪽 자식 노드 정보 저장
            map.put(tmp[0], list); // 현재 노드와 자식 노드 정보를 맵에 저장
        }

        // 저장되는 형태 Example
        // Key: "A"
        // Value(List): ["B", "C"]


        preorder("A"); // 전위 순회 시작
        System.out.println();
        inorder("A"); // 중위 순회 시작
        System.out.println();
        postorder("A"); // 후위 순회 시작
    }

}
