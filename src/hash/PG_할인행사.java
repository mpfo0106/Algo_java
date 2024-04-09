package hash;

import java.util.HashMap;

/**
 * HashMap 에 want 저장해두고
 * discount 를 돌면서 연속으로 되는지 확인
 * <p>
 * O(N + M) 이라 가능할것같음
 */
public class PG_할인행사 {
    public static void main(String[] args) {

    }

    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discount10 = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10.put(discount[j], discount10.getOrDefault(discount[j], 0) + 1);
                }
            }
            if (wantMap.equals(discount10)) {
                answer += 1;
            }
        }
        return answer;
    }
}
/**
 * HashMap 으로 접근 하는건 알았지만, 효율적 접근법이 생각나지 않았음.
 * <p>
 * map 의 equals 를 사용하자
 * <p>
 * 2트
 * 1. map 의 equals 를 사용하자.
 * 2. getOrDefault의 사용법을 잘 보자
 * 3. hashMap을 어디서 초기화하는지 잘보자
 * 4. int i와 j의 범위를 잘보자!!!
 */

/**
 * 2트
 * 1. map 의 equals 를 사용하자.
 * 2. getOrDefault의 사용법을 잘 보자
 * 3. hashMap을 어디서 초기화하는지 잘보자
 * 4. int i와 j의 범위를 잘보자!!!
 */