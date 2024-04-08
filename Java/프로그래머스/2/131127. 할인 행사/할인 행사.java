/**
해시맵에 want, number 저장
want 맵과 일치하는 map 을 고르기

discount 를 돌면서 나오는 일치 map 의 개수
*/
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> basket = new HashMap<>();
  
        int answer = 0;
        for(int i=0; i< want.length; i++){
            basket.put(want[i],number[i]);
        }
        for(int i=0; i<discount.length-9; i++){
            HashMap<String,Integer> discountMap = new HashMap<>();
            if(basket.containsKey(discount[i])){
                for(int j=i; j<i+10; j++){
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j],0)+1);
    
                }
                if(basket.equals(discountMap)){
                    answer+=1;
                }
            }
        }
        
        return answer;
    }
}