package programmers;

import java.util.Arrays;

/**
 * 1. Arrays.copyOfRange 로 배열을 자르고 정렬하자
 * 2. 정렬하기
 * 3. 정렬한것중 k 번째 뽑기
 * 4. command 반복
 */

public class PG_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int i, j, k;
        int[] result = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            i = commands[idx][0];
            j = commands[idx][1];
            k = commands[idx][2];

            int[] subArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(subArr);
            result[idx] = subArr[k - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        PG_K번째수 pg_k번째수 = new PG_K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println();
    }
}
