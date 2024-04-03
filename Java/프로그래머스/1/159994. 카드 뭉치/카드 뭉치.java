import java.util.Queue;
import java.util.ArrayDeque;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque();
        Queue<String> queue2 = new ArrayDeque();
        String answer = "No";
        for(String card1 : cards1){
            queue1.add(card1);
        }
        for(String card2 : cards2){
            queue2.add(card2);
        }
        
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
                return answer;
            }
        }
        answer = "Yes";
        
        return answer;
    }
}