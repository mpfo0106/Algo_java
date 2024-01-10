//package softeer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * dfs
// * N줄 이 주어지면 1씩만 가는
// * 영역의 개수와 각 영역의 크기를 오름차순으로 출력
// * <p>
// * <p>
// * 풀이 1. 전체 행렬에서 dfs 를 돌리고, dfs 후에 0으로 변경시켜,
// * 한번 dfs 들어갔을때 0으로 바꿀때마다 영역의 각 개수cnt++
// * dfs 재귀 전체 종료되면 전체 cnt ++
// */
//public class pro4 {
//    static int[][] graph;
//    static List<Integer> round;
//    static int roundCnt;
//    static int totalCnt = 0;
//    static int n;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        n = Integer.parseInt(br.readLine());
//        round = new ArrayList<>();
//        graph = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < n; j++) {
//                graph[i][j] = line.charAt(j) - '0';
//            }
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (dfs(i, j)) {
//                    totalCnt++;
//                    round.add(roundCnt);
//                    roundCnt = 0;
//                }
//            }
//        }
//        Collections.sort(round);
//        sb.append(totalCnt).append("\n");
//        for (int e : round) {
//            sb.append(e).append(" ");
//        }
//        System.out.println(sb);
//    }
//
//    private static boolean dfs(int x, int y) {
//        if (x < 0 || x >= n || y < 0 || y >= n) {
//            return false;
//        }
//
//        if (graph[x][y] == 1) {
//            roundCnt++;
//            graph[x][y] = 0;
//            dfs(x - 1, y);
//            dfs(x + 1, y);
//            dfs(x, y - 1);
//            dfs(x, y + 1);
//            return true;
//        }
//        return false;
//    }
//}
