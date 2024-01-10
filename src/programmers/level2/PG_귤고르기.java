/*
귤 k 개를 골라 상자 하나에 담아 판매
귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화

1 2 2 3 3 4 5 5

k개의 귤을 담을때
서로 다른 종류의 수의 최솟값을 return 하도록
최대한 중복이 많이

개수 max를 알아내서 k 에서 빼고 그다음 max 를 뺴고

1. map 으로 묶고 stream 으로 value 비교
2. 계수 정렬  천만 XX
 */

package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class PG_귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        HashMap<Integer, Integer> tgr = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            tgr.put(tangerine[i], tgr.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(tgr.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return tgr.get(o2).compareTo(tgr.get(o1)); //내림차순
            }
        });

        for (Integer key : keySet) {
            int n = tgr.get(key);
            if (n >= k) {
                return answer;
            } else {
                k -= n;
                answer += 1;
            }
        }
        return answer;
    }
}

