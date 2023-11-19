package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 첫줄에 배열 개수, a+b =  x 를 만족하는 a,b 를 구해라.
 * 투포인터로 접근
 * 1.정렬 때리고
 * while(left < n-1):
 * right ++ & asw ++ 하고 맞으면 else 로 left++ 후 반복.
 * <p>
 * 중복 없어서 검사안해도돼
 */
public class BOJ_3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);
        int left = 0, right = n-1, result = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                left++;
                right--;    // 중복 없음으로 left 를 증가시켰음으로 sum ==x 되려면 Right 를 감소시켜야 hit 확률 up
                result++;
            } else if (sum < x) {
                left++;
            } else {  //더 크다면
                right--;
            }
        }
        System.out.println(result);
    }
}

/**  방법2. x 보다 큰 값들은 다 날려버리고, 그 안에 가능성있는애들 중에 돌리기
 * for (int i = 1; i < arr.length; i++) {
 * 			if (i > x) break;
 *
 * 			if (arr[i] != 0 && arr[x-i] != 0) cnt++;
 *                }	// end of for loop
 *
 */

