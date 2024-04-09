package hash;

/**
 * 요구조건
 * 1.한번에 한명 신고. 동일 유저 신고 횟수는 1회
 * 2. k번 이상 신고되면 정지. 정지 사실을 신고된 유저에게 발송
 * 3. 각 유저별 메일을 받은 횟수를 배열에 저장
 * 1000. 2십만 => O(N)
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 필요한것
 * 1. 누가 신고했는지 저장할 리스트
 * 2. id 별 신고횟수 누적 리스트
 * 피신고자 명단 돌면서 신고한 사람 뽑기
 * <p>
 * hashMap
 * 1. 정답용 피신고자: count
 * 2. String (피신고자) : ArrayList<String> (신고한 사람)
 */
public class XPG_신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        solution(id_list, report, 2);
    }

    static public int[] solution(String[] id_list, String[] report, int k) {
        //신고자 : 메일받은 횟수
        HashMap<String, Integer> mailCount = new HashMap<>();
        // 피신고자 : 신고자들
        HashMap<String, HashSet<String>> reportedBy = new HashMap<>();
        //초기화
        for (String id : id_list) {
            reportedBy.put(id, new HashSet<>());
            mailCount.put(id, 0);
        }
        for (String str : report) {
            String[] parts = str.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            reportedBy.get(reported).add(reporter);
        }
        // k 이상인것 찾기
        for (String reported : reportedBy.keySet()) {
            HashSet<String> reporters = reportedBy.get(reported);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}

/**
 * 거의 다 생각했었어. 다음엔 hashMap 그림을 그려봐.
 * 중복이 있으면 안된다는걸 보고 HashSet 을 생각해야해.
 * 신고당한 횟수는 따로 뺄 필요가 없어. 대신 정답 출력용 hashMap 이 필요해.
 * <p>
 * 1. nullPointer 오류 => 초기화 잘할것.
 * 2. .keySet() 으로 키만 잘 빼서 돌려. => 보다 entrySet()으로 돌려. 그럼 또 따로 HashSet 을 만들필요없이 키,밸류 컨트롤 가능
 * 3. 따로 처음에 초기화 안해도되고, !containsKey 로 빼도돼.
 */