package graph;

public class XPG_네트워크 {
    private static int[][] computer;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int n = 3;

        System.out.println(solution(n, computers));

    }

    private static void dfs(int now) {
        visited[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[now])
                dfs(i);
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

}

/**
 * 1트)
 * 행렬같은 adj를 채우지 못했다. + 모두 bfs 검사라는걸 놓침.
 */