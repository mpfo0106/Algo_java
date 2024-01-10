package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * dfs 문제
 * 섬 안에 섬을 찾는게 관건. 1이 물
 *
 */
public class pro3 {
    static int[][] graph;
    static int roundCnt;
    static int totalCnt = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

    }
    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if (graph[x][y] == 1) {
            roundCnt++;
            graph[x][y] = 0;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}