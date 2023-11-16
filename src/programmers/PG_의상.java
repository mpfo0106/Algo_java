package programmers;

import java.util.HashMap;

/**
 * 1. hashmap 으로 옷개수를 받아
 * 2. 곱을 구해
 * 3. 아무것도 안입는 경우는 없어. 이걸 조심해.!
 */

public class PG_의상 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int total = 1;
        for (String[] item : clothes) { //hash 에 종류별로 넣기
            hashMap.put(item[1], hashMap.getOrDefault(item[1], 1) + 1);
        }
        for (String key : hashMap.keySet()) {
            total *= hashMap.get(key);
        }
        return total - 1;
    }

    public static void main(String[] args) {
        PG_의상 pg_의상 = new PG_의상();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        //String[][] clothes =  {{"a", "A"}, {"b", "B"}, {"c", "C"}};
        System.out.println(pg_의상.solution(clothes));
    }
}
