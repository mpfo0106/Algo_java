package graph;

import java.util.ArrayList;

public class 문제_34_dfs {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        char start = 1;
        int n = 5;
        solution(graph, start, n);
        System.out.println(answer);
    }

    private static void solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }
        dfs(start);
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);
        for (int num : adjList[now]) {
            if (!visited[num])
                dfs(num);
        }
    }
}

/**
 * 인접그래프의 구현에서 부터 막혔다. Dfs 스택을 사용한다고 해서 스택부터 생각하고 있었다.
 * ArrayList<Integer>[] 을 처음 알았다.
 */