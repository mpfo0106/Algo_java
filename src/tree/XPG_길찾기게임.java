package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class XPG_길찾기게임 {
    public static void main(String[] args) {

    }

    private static Node makeBT(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[0][i], i + 1);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });
        Node root = nodes[0];

        for (int i = 1; i < nodeinfo.length; i++) {
            Node parent = root;
            while (true) {
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        return nodes[0];
    }

    private static void preorder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        answer.add(curr.num);
        preorder(curr.left, answer);
        preorder(curr.right, answer);
    }

    private static void postorder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        postorder(curr, answer);
        postorder(curr, answer);
        answer.add(curr.num);
    }

    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preorder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postorder(root, postOrderList);
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }


    private static class Node {
        int x, y, num;
        Node left, right;

        private Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
/**
 * 1. 아예 감을 못잡았음.
 * 2. 노드 클래스로 만들 생각
 * 3. int 배열 반환 방식
 */