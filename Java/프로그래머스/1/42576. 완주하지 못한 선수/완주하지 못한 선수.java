/**
완주자를 HashMap<String,Integer>
참가자 돌면서 hashMap 에 있는 Integer 를 -1
hashMap 에 없거나 -1 인 선수 출력
*/
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> people = new HashMap<>();
        for(String person : completion){
            people.put(person, people.getOrDefault(person,0)+1);
        }
        for(String person : participant){
            if(people.containsKey(person) && people.get(person)>=1){
                people.put(person,people.get(person)-1);
            }
            else{
                return person;
            }
        }
        return "";
    
    }
}