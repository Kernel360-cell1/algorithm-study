import java.util.*;

public class BOJ_이진검색트리 {
    //순회에 사용할 노드 클래스 생성
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
        }

        // 전위 순회는 부모 -> 왼쪽 -> 오른쪽 순으로 돌기 때문에 제일 처음 노드는 루트 노드임
        public void addRoot(int data) {
            root = new Node(data);
        }

        // 노드 추가 구현, 부모 보다 작으면 왼쪽, 크면 오른쪽으로 배정
        public void add(Node root, int data){
            if (root == null) {
                root = new Node(data);
            } else if (data < root.data) {
                if (root.left == null) {
                    root.left = new Node(data);
                } else {
                    add(root.left, data);
                }
            } else if (data > root.data) {
                if (root.right == null) {
                    root.right = new Node(data);
                } else {
                    add(root.right, data);
                }
            }
        }

        // 후위 순회 구현
        public void postOrder(Node root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.println(root.data);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        while (true) {
            try {
                int now = sc.nextInt();
                if (binaryTree.root == null) {
                    binaryTree.addRoot(now);
                } else {
                    binaryTree.add(binaryTree.root, now);
                }
            } catch (Exception e) {
                break;
            }
        }

        binaryTree.postOrder(binaryTree.root);
    }
}