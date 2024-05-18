package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class XBOJ_1260_DFS_BFS {
    private static ArrayList<Integer>[] adj;
    private static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        V = Integer.parseInt(str[2]);
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        ArrayList<Integer> answer1 = dfs();
        ArrayList<Integer> answer2 = bfs();
        for (int num : answer1) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
        for (int num : answer2) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static ArrayList<Integer> bfs() {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(V);
        visited[V] = true;
        answer.add(V);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int n : adj[num]) {
                if (!visited[n]) {
                    visited[n] = true;
                    answer.add(n);
                    queue.add(n);
                }
            }
        }
        return answer;
    }

    private static ArrayList<Integer> dfs() {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        dfsHelper(V, visited, answer);
        return answer;
    }

    private static void dfsHelper(int V, boolean[] visited, ArrayList<Integer> answer) {
        visited[V] = true;
        answer.add(V);
        for (int n : adj[V]) {
            if (!visited[n]) {
                dfsHelper(n, visited, answer);
            }
        }
    }

}
/**
 * 1트)
 * 1. 간선이 양방향인거 놓침.
 * 2. adj sort 는 Collections.sort()인거 잊음.
 * 3. dfs 로직 잘못. 방문하고 stack 에 넣으면 안돼. 꺼낸 뒤에 스택에 넣어야해.+ 재귀로 하는게 더 쉬워.
 */