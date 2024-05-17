package backTracking;

public class XPG_피로도 {
    private static int[][] Dungeons;
    private static int answer;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(80, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        Dungeons = dungeons;
        visited = new boolean[Dungeons.length];
        bt(k, 0);
        return answer;

    }

    private static void bt(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;

                bt(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }

    }
}
/**
 * 1트)
 * 뭔가 느낌은 알겠는데 아직도 bt가 코드로 나오지 않음. 재귀가 어려운거같다.
 * dfs 감도 못잡음 + 완탐이라 정렬 x
 */