package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 문제35_bfs {
    private static ArrayList<Integer> answer;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
        int start = 1;
        int n = 5;
        solution(graph, start, n);
        System.out.println(answer);
    }

    private static void bfs(int now) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(now);
        visited[now] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            answer.add(num);
            
            for (int next : adjList[num]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }
        bfs(start);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 아직 adjList[] 와 visited 를 만드는게 익숙치 않다.
 */