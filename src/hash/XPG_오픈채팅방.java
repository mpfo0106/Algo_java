package hash;

/**
 * 문자열 record 배열 십만
 * uid 로 해시맵 사용하자.
 * 단어는 enter, leave, change
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * record 돌면서 uid, 이름 : string string 으로 해시맵
 * <p>
 * 1. 처음에 record 를 다 읽고 hashmap 으로 정확한 이름 다 저장하기
 * 그리고 다른 arrayList 에 hashmap 을 넣어서 uid1234 -> enter 이렇게 저장하기.
 * <p>
 * 후에 저장한 두 해시맵으로 enter
 */
public class XPG_오픈채팅방 {

    public String[] solution(String[] record) {

        //ex) uid1234 : Muzi
        HashMap<String, String> name = new HashMap<>();

        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        for (String str : record) {
            String[] parts = str.split(" ");
            if (parts.length == 3) {
                name.put(parts[1], parts[2]);
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String str : record) {
            String[] parts = str.split(" ");
            if (msg.containsKey(parts[0])) {
                answer.add(name.get(parts[1]) + msg.get(parts[0]));
            }
        }
        return answer.toArray(new String[0]);
    }
}

/**
 * 답안리뷰:
 * <p>
 * 1. 접근은 비슷했으나, 메세지포멧도 hashmap 에 저장해서 깔끔하게 사용할줄 몰랐음.
 * 2. 또 언제 값이 변하는지, 어떤값이 안변하는지를 처음에 분석하면 쓸데없는 코드를 줄일 수 있음.
 * 3. 겁이 너무 많았던게 문제.
 * 4. ArrayList 를 toArray(new String[0]) 으로 변환하는법
 */
