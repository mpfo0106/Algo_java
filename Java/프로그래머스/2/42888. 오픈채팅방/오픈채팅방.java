/**
닉네임이 생기거나 변화하는 경우 : Enter,Change 
1. HashMap 으로 uid : 이름 저장해두기.
2. 메세지 포멧도 HashMap으로
*/
import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> msg = new HashMap<>();
        HashMap<String,String> name = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        msg.put("Enter","님이 들어왔습니다.");
        msg.put("Leave","님이 나갔습니다.");
        
        for(String rcd : record){
            String[] cmd =rcd.split(" ");
            if(cmd.length ==3){
                name.put(cmd[1],cmd[2]);
            }
        }
        
        for(String rcd : record){
            String[] cmd =rcd.split(" ");
            if(msg.containsKey(cmd[0])){
                result.add(name.get(cmd[1])+msg.get(cmd[0]));
            }
        }
        
        return result.toArray(new String[0]);
    }
}