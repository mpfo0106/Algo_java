package codingTestBook;

/**
 * 1. 10진수를 %2 /2 를 계속해서 stack 에 넣고 다 넣으면 순서대로 pop
 */

import java.util.ArrayDeque;

/**
 * 1. while n>0 :
 * /2 %2 진행
 * 마지막에 pop 하면
 */
public class 문제09_10진수를_2진수로_변환하기 {
    public static void main(String[] args) {
        System.out.println(solution(13));

    }

    private static String solution(int decimal) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            int mod = decimal % 2;
            stack.push(mod);
            decimal /= 2;
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            sb.append(num);
        }
        return sb.toString();

    }
}
/**
 * 마지막에 string 맨앞 0 처리하는법에서 고민. => 0이 안나오니 고민할 필요가 없었음
 * sb.toString() 처리해서 반환.
 */