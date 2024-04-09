package hash;

/**
 * 요구조건
 * 코스요리 = 최소 2가지 이상의 단품메뉴
 * 코스요리 후보 = 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합
 * 메뉴구성을 사전 오름차순 정렬
 * <p>
 * O()
 * 26개*2~10
 */

import java.util.*;

/**
 * 필요한것
 * 각 orders 에서 가능한 경우의 수를 세야해.
 * ContainsKey 를 이용해야해. => 돌면서 course개인 경우 HashMap 에 다넣기
 * if(containsKey) 를 통해서 중복인건 +1
 * <p>
 * HashMap 으로 order 조함 : 개수
 */
public class XPG_메뉴리뉴얼 {

    //메뉴구성 : 총 주문수
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public static void combinations(int idx, char[] order, String result) {
        if (!courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }

    public String[] solution(String[] orders, int[] course) {

        courseMap = new HashMap<>();
        //초기화
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            char[] parts = order.toCharArray();
            Arrays.sort(parts);
            combinations(0, parts, "");
        }
        ArrayList<String> answer = new ArrayList<>();

        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values().stream().max(Comparator.comparingInt(o -> o)).ifPresent(cnt -> count.entrySet().stream().filter(entry -> cnt.equals(entry.getValue()) && cnt > 1).forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}

/**
 * 풀이 방법은 대충 알았지만,조합을 구현하지 못했음.
 * hash 맵을 두개 쓰지말고 한개에 넣어서 쓸 생각을 못했다.
 * Stream 으로 복잡하게 푸는게 아직도 어렵다..
 */