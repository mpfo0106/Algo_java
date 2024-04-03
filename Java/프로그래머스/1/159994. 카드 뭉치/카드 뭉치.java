import java.util.ArrayDeque;
import java.util.Arrays;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        for(String word: goal){
            String word1 = queue1.peek();
            String word2 = queue2.peek();
            if(word.equals(word1) || word.equals(word2)){
                if(word.equals(word1))
                    queue1.poll();
                else{
                    queue2.poll();
                }
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
}