package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 문제35_bfs {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            answer.add(now); // 한번으로 가능
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {


    }

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; ) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}

/**
 * 아직 adjList[] 와 visited 를 만드는게 익숙치 않다.
 */