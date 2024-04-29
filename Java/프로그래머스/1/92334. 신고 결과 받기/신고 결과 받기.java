import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportedMap = new HashMap<>();
        HashMap<String, Integer> mailMap = new HashMap<>();
        for(String str : report){
            String[] part =str.split(" ");
            String reporting = part[0];
            String reported = part[1];
            if(!reportedMap.containsKey(reported)){
                reportedMap.put(reported,new HashSet<>());
            }
            reportedMap.get(reported).add(reporting);
        }
        
        for(Map.Entry<String, HashSet<String>> entry : reportedMap.entrySet()){
            String key = entry.getKey();
            if(reportedMap.get(key).size()>=k){
                for(String str : entry.getValue()){
                    mailMap.put(str, mailMap.getOrDefault(str,0) +1);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(String id : id_list){
            if(mailMap.containsKey(id))
                result.add(mailMap.get(id));
            else{
                result.add(0);
            }
            }
    return result.stream().mapToInt(Integer::intValue).toArray();    
    }
        
    }
