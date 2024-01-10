package programmers.level1;

/**
 * 가로,세로 중 가장 큰거에 맞추자.
 * 1. 큰걸 가로에 몰아주자.
 */

public class PG_최소직사각형 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxLength = 0;
        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int length = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            maxLength = Math.max(maxLength, length);
        }

        return maxWidth * maxLength;

    }

    public static void main(String[] args) {
        PG_최소직사각형 pg_최소직사각형 = new PG_최소직사각형();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(pg_최소직사각형.solution(sizes));
    }
}
