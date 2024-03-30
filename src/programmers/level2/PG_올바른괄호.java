package programmers.level2;

/**
 * 1. 문자열은 십만
 */

import java.util.ArrayDeque;

/**
 * 1. () 을 스택에 넣어서 stack.../
 * 2. top이 이번에 들어오는것과 짝이 맞으면 기존꺼 pop 하고, 새로운거 continue
 * <p>
 * 3. 마지막에 stack isEmpty() 면 true
 */

public class PG_올바른괄호 {
    private boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
//    boolean solution(String s) {
//        boolean answer = false;
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
//                stack.pop();
//                continue;
//            }
//            stack.push(ch);
//        }
//        if (stack.isEmpty())
//            answer = true;
//        return answer;
//    }

}

/**
 * 1. stack.peek() 쓸때 항상 비어있는지 확인하자
 * <p>
 * 2. Stack 말고 ArrayDeque 을 사용하자
 * 3. toCharArray 를 써서 배열에 넣자
 * 4. stack Pop 으로 계속 다 쌓는게 아닌 stack.isEmpty 와 Pop 을 같이 써서 아닌경우를 체크하고 아니면 바로 return
 */