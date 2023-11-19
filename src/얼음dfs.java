import java.util.Scanner;

public class 얼음dfs {
    private static int N, M;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        // Initialize and read the graph
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0'; // Convert char to int
            }
        }

        // Apply DFS and count regions
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
        scanner.close();
    }

    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
