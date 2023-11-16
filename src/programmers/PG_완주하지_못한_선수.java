package programmers;//import java.util.HashMap;

import java.util.HashMap;

public class PG_완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        HashMap<String, Integer> marathon = new HashMap<>();
        for (String person : participant) {
            marathon.put(person,marathon.getOrDefault(person,0)+1);
        }
        for (String person : completion) {
            marathon.put(person, marathon.get(person) - 1);
        }
        for(String key : marathon.keySet()){
            if(marathon.get(key) != 0){
                System.out.println(key);
            }
        }
    }
}