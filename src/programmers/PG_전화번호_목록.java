package programmers;


/**
 * 1. 전부다 해쉬에 넣고
 * 2. 검사할때 for 문으로 해당하는 해쉬 길이 만큼 substring 검사.
 */

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(phone_book));
        for (String phone : phone_book) { //전체
            for (int i = 1; i < phone.length(); i++) { //
                String prefix = phone.substring(0, i);
                if (hashSet.contains(prefix)) {
                    answer = false;
                }
            }


        }
        return answer;
    }
}

public class PG_전화번호_목록 {
    public static void main(String[] args) {
        Boolean answer;
        Solution solution = new Solution();
        String[] phone_book = {"123", "456", "789"};
        answer = solution.solution(phone_book);
        System.out.println(answer);
    }
}