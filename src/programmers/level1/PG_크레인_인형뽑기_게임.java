package programmers.level1;

/**
 * moves 한개씩 돌면서 배열의 열을 뽑아서 스택에 쌓아.
 * 사라진 인형의 개수를 return
 */

import java.util.Stack;

/**
 * 1. 열에 해당하는 숫자를 뽑는다
 * a. 위에서부터 확인 ex) 1번칸이라면 [n][0] 번째 위에서부터 [0][0] ~ [4][0]  까지 뒤지기.
 * b. 뽑으면 0 으로 바꾸고!! stack 에 넣기
 * 2. 스택에서 두개가 같으면 pop 하고 +2 올린다
 */
public class PG_크레인_인형뽑기_게임 {
    public static void main(String[] args) {

    }

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int num = board[i][move - 1];
                if (num != 0) {
                    if (!stack.isEmpty() && stack.peek() == num) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(num);
                    }
                    board[i][move - 1] = 0; //뽑으면 0으로 변경
                    break;
                }
            }
        }
        return answer;
    }

}
/**
 * 1.뽑기해서 pop 되면 +2 안되면 push 로 구현 =>  테케까지는 통과..
 * 2차시도. break 문의 위치 실수, 뽑으면 0으로 바꿔야하는걸 까먹었다! => 해결!
 */