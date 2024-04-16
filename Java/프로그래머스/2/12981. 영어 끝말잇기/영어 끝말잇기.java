import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        int[] answer = {0,0};
        int cnt = 1;
        int who = 1;
        char lastWord = words[0].charAt(0);
        for(String word : words){
            if(who >n){
                who =1;
                cnt++;
            }
            if(wordSet.contains(word) || word.charAt(0) != lastWord){
                answer[0] = who;
                answer[1] = cnt;
                return answer;
            }
            wordSet.add(word);
            who++;
            lastWord = word.charAt(word.length() - 1);
        }
        return answer;
    }
}