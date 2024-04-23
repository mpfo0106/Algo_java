import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        char last = words[0].charAt(0);
        int[] answer = {0,0};
        for(int i=0; i<words.length; i++){
            String word =words[i];
            //틀릴경우
            if(wordSet.contains(word) || word.charAt(0) != last){
                answer[0] = i%n +1;
                answer[1] = (i/n)+1;
                return answer;
            }
            wordSet.add(word);
            last = word.charAt(word.length()-1);
        }
        return answer;
    }
}