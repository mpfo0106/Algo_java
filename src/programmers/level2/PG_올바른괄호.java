package programmers.level2;

/**
 * 1. 문자열은 십만
 */

import java.util.Stack;

/**
 * 1. () 을 스택에 넣어서 stack.../
 * 2. top이 이번에 들어오는것과 짝이 맞으면 기존꺼 pop 하고, 새로운거 continue
 * <p>
 * 3. 마지막에 stack isEmpty() 면 true
 */

public class PG_올바른괄호 {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        if (stack.isEmpty())
            answer = true;
        return answer;
    }
}

/**
 * stack.peek() 쓸때 항상 비어있는지 확인하자
 */