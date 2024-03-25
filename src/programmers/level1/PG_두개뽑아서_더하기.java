package programmers.level1;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. numbers 에서 다른 두수 뽑아서 더해.
 * b. 중복을 제거해야해
 * 2. 모든 가능성을 오름차순으로 return
 */
public class PG_두개뽑아서_더하기 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 1. set으로 반환했는데, 이걸 int[] 로 바꾸는거에서 걸렸음.
 * stream 의 유연한 사용법을 좀 더 공부하자. 특히 Integer::intValue 메소드 참조
 * <p>
 * 2.stream 에서 sort 하자. 정렬 후 set 은 순서 보장X
 * <p>
 * 3. treeSet 을 사용하면 정렬이 된다.
 * <p>
 * 4. 시간복잡도.
 * O(N^2) + 정렬 임으로 => O(N^2 log(N^2))
 */
