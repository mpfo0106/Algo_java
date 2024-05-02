package graph;

import java.util.ArrayDeque;

public class XPG_게임맵최단거리 {
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        int[][] dist = new int[N][M];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        dist[0][0] = 1;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + rx[i];
                int ny = now.y + ry[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (maps[nx][ny] == 0)
                    continue;
                if (dist[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

    private static class Node {
        int x, y;

        public Node(int r, int c) {
            this.x = r;
            this.y = c;
        }
    }
}

/**
 * 예외 케이스들을 if 로 체크하고 continue 로 뺴.
 * + dist와 rx,ry 놓는법. + dist 갱신하는거
 */
