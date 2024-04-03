import java.util.ArrayDeque;
import java.util.ArrayList;
class Solution {
          public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayDeque<Integer> speedDeque = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int days = 0;
        for (int progress : progresses) {
            deque.addLast(progress);
        }
        for (int speed : speeds) {
            speedDeque.addLast(speed);
        }
        while (!deque.isEmpty()) {
            int cnt = 0;
            while (!deque.isEmpty() && deque.peekFirst() + speedDeque.peekFirst() * days >= 100) {
                deque.pollFirst();
                speedDeque.pollFirst();
                cnt += 1;
            }
            if (cnt > 0) {
                answer.add(cnt);
            }
            days += 1;
        }
        return answer;
    }
}