package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 문제36_다익스트라 {
    private static ArrayList<Node>[] adjList;
    private static ArrayList<Integer> answer;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        int start = 0;
        int n = 3;
        solution(graph, start, n);
    }

    static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n];
        visited = new boolean[n];
        answer = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.dst]) {
                continue;
            }

            visited[now.dst] = true;

            for (Node next : adjList[now.dst]) {
                if (dist[next.dst] > now.weight + next.weight) {
                    dist[next.dst] = now.weight + next.weight;
                    pq.add(new Node(next.dst, dist[next.dst]));
                }
            }
        }
        return dist;
    }

    static class Node {
        int dst;
        int weight;

        Node(int dst, int weight) {
            this.dst = dst;
            this.weight = weight;
        }
    }


}
/**
 * 우선 순위 큐 구현을 잊어버림
 * 생각보다 이해하기 어려워서 다시 천천히 ㄱ
 * <p>
 * 2트. dist와 visit 배열을 만들어서 관리하는것과 뭐랑 뭐를 비교하는지 혼란스러웠음
 */