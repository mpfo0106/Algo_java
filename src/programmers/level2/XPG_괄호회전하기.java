package programmers.level2;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 1. O가 나올때까지 돌려. O 가 나오면 몇개 파트인지 쪼개
 * 2. 앞에서부터 아구가 맞으면 popfirst 로 날려.
 */
public class XPG_괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";
        solution(s);
    }

    public static int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s;
        int answer = 0;

        A:
        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);

                if (!map.containsKey(c)) { //여는 괄호
                    stack.push(c);
                } else { //닫는괄호
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty())
                answer += 1;

        }
        return answer;
    }
}


/**
 * 1. deque 을 이용해서 첫번째와 마지막이 만나면 pop을 하려했음 => 일부 정답이지만 nullpointer 에러
 * switch case 문을 이용하기.
 * <p>
 * <p>
 * 1. hashMap 으로 저장을 다 해두고 containsKey 를 사용해서 코드 양을 줄이기.
 * 2. A: 같은 label 문법의 사용
 */
