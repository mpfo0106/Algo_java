/*
1. 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다
2. 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
3. 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료

# 1. 스택에 한개씩 떨어트리면서 겹치면 2개 붙으면 pop
# 2. 더이상 제거할게 없는지는 어떻게 알까 => pop 이 안나오면. 스택이 완선되어버리면 더이상 푸시가 없을때
 */

package programmers.level2;

import java.util.Stack;

public class PG_짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else { //비어있으면
                stack.push(ch);
            }
        }
        return (stack.isEmpty()) ? 1 : 0;
    }

}
