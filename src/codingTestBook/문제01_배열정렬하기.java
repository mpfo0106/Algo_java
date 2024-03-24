package codingTestBook;

import java.util.Arrays;

/**
 * 1. 정수 배열 입력받기
 * 2. 정렬하기
 */

public class 문제01_배열정렬하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }


    public static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
