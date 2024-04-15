import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pkm = new HashSet<>();
        int answer = 0;
        int k = nums.length/2;
        for(int num : nums){
            pkm.add(num);
        }
        if(pkm.size() <k){
            answer = pkm.size();
        }
        else{
            answer = k;
        }
        return answer;
    }
}