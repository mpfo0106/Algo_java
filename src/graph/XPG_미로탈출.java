package graph;

import java.util.ArrayDeque;

public class PG_미로탈출 {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int N = maps.length;
        int M = maps[0].length();
        String[] tmp = maps;
        char[][] charMap = new char[N][M];
        int[][] dist = new int[N][M];
        Node lever = null;
        Node exit = null;

        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[i].length; j++) {
                charMap[i][j] = maps[i].charAt(j);
                if (charMap[i][j] == 'S') {
                    queue.add(new Node(i, j));
                    dist[i][j] = 1;
                }
                if (charMap[i][j] == 'L') {
                    lever = new Node(i, j);
                }
                if (charMap[i][j] == 'E') {
                    exit = new Node(i, j);
                }
            }
        }


        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (charMap[nx][ny] == 'X')
                    continue;
                if (dist[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
        }
        int answer = dist[lever.x][lever.y] + dist[exit.x][exit.y];


        if (answer == 0) {
            return -1;
        }
        return answer;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/**
 *
 */