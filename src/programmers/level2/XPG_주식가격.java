package programmers.level2;

/**
 * 0. 이중 for 는 시간초과
 * 1. 뒤 숫자와 비교해서 b-a
 * 2. 정렬해서 내 숫자가 몇위인지 알아야할까?
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 1. n = prices.length
 */
public class XPG_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));

    }

    //스택을 사용해보자
    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - (idx + 1);
        }
        return answer;
    }

}

/**
 * 실패1.  문제 어떻게 풀어야하는지 접근을 못함. => 처음에 O(N^2) 을 떠올리기는 쉽지만, 스택으로 효율성을 높이는걸 생각못함
 * 실패 2. for (int j = i - 1; j >= 0; j--) 범위가 잘못되었음.    while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) 으로 깔끔하게 한번에 잡자
 */
