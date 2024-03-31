package programmers.level2;

/**
 * 붙어있는것을 제거하자.
 */

import java.util.Stack;

/**
 * 1. stack 을 사용해서 한개씩 떨어트린뒤 붙으면 pop
 */

public class PG_짝지어제거하기 {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            answer = 1;
        }
        return answer;
    }

}

/**
 * 1. stack 이 pop 되는 조건을 먼저 검사하는게 좋은거같다. pop 케이스가 더 적으니
 * 2. Deque 을 쓸때는 항상 메소드 짝을 맞추자.
 */
