/**
 * 1. 순서 유지해서 중복제거하기 2. 한개씩 스택으로 받고 중복이면 Pop
 */

package programmers.level1;

import java.util.Stack;

public class PG_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        Solution solution = new Solution();

        solution.solution(arr);
    }

    public static class Solution {
        public int[] solution(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (stack.isEmpty() || stack.peek() != arr[i]) {
                    stack.push(arr[i]);
                }
            }
            int[] answer = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                answer[i] = stack.pop();
            }
            return answer;

        }
    }
}
