package codingTestBook;

/**
 * 1~N명의 사람. 원형태로. K번째 수가 주어짐.
 * 1. 1번부터 K번째 사람을 제거.
 * 2. 제거한 사람 다음사람이 기준
 * 3. 또 K번째 사람 제거...
 */

import java.util.ArrayDeque;

/**
 * 원형 큐를 이용.
 * + k 번째 제거
 */
public class 문제15_요세푸스문제 {
    private int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                int n = queue.pollFirst();
                queue.addLast(n);
            }
            queue.pollFirst();
        }
        return queue.pollFirst();
    }
}
