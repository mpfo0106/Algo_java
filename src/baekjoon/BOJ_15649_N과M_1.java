package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백트래킹 문제
 * 1~N 중에 중복없이 M 개 고르기
 * <p>
 * 1. HashMap
 */
public class BOJ_15649_N과M_1 {
    static int N, M;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        sequence = new int[M];
        visited = new boolean[N + 1];

        backtrack(0);

    }

    private static void backtrack(int length) {
        if (length == M) { //탈출조건
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[length] = i;
                backtrack(length + 1);
                visited[i] = false;
            }
        }
    }

}
