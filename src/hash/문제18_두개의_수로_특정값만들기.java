package hash;

/**
 * N arr
 * 합이 target 인 두 수가 arr에 있는지 찾기
 * 있/없으면 => true/ false
 */

import java.util.HashSet;

/**
 * hash 로 arr 를 담아서
 * for 하나 돌면서O(N)
 * 합계 - 현재값 = 나머지 값에 해당하는 key 가 있는지 찾기!
 */
public class 문제18_두개의_수로_특정값만들기 {
    public static void main(String[] args) {

    }

    private boolean solution(int[] arr, int target) {
        HashSet<Integer> HashSet = new HashSet<>(arr.length);
        for (int num : arr) {
            HashSet.add(num);
        }
        for (int num : arr) {
            if (HashSet.contains(target - num)) {
                return true;
            }
        }
        return false;
    }

}

/**
 * hashSet 을 이용하자.
 * <p>
 * 정답풀이)
 * 1. 탈락한 놈들만 hashSet.add를 해서 계산을 줄인다.
 */
