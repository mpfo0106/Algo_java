package backTracking;

import java.util.ArrayList;

public class 문제43_1부터N까지숫자합 {

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        backTrack(0, new ArrayList<>(), 1);
        return result;

    }

    private static void backTrack(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }
        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                // 독립적인 새로운 list를 파기 위해.
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backTrack(sum + i, list, i + 1);
            }
        }
    }
}
/**
 * 1트)
 * 감을 못잡음. 1. 재귀를 사용하고 2.독립리스트를 계속 넣어준뒤 완전탐색을 기억하자.
 */