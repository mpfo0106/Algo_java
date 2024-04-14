package parent;

import java.util.ArrayList;

public class 문제30_유니온파인드_알고리즘 {
    private static int[] parent;

    public static void main(String[] args) {
        int[][] operations = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        int k = 3;
        Boolean[] res = solution(operations, k);
        for (boolean a : res) {
            System.out.print(a + " ");
        }
    }

    private static Boolean[] solution(int[][] operations, int k) {
        parent = new int[k];
        //자기 자신 root
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }
        ArrayList<Boolean> result = new ArrayList<>();
        for (int[] op : operations) {
            int x = op[1];
            int y = op[2];
            //union
            if (op[0] == 0) {
                union(x, y);
            }
            //find
            if (op[0] == 1) {
//                if (find(x) == find(y)) {
//                    result.add(true);
//                } else {
//                    result.add(false);
//                }
                result.add(find(x) == find(y));
            }
        }
        return result.toArray(new Boolean[0]);
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}

/**
 * find 좌표 압축 코드 암기
 */

