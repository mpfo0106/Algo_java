package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * <p>
 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
 * <p>
 * 1. 1~N 을 정렬한다.
 * a. 근데 stages 에서 가장 많이 나온 순서대로.
 * b. 도달 유저 없으면 실패율은 0. 가장 앞에
 * <p>
 * 2. 실패율 공식에 넣어서 계산할것.
 * <p>
 * 3. 실패율을 담은 배열을 리턴해야해. + 역정렬해서
 * <p>
 * -----
 * 1. 정렬한다
 * 2. 해쉬맵을 사용해서 1번의 실패율 ... 이렇게 저장
 * a. 처음부터 다음수와 비교한뒤에 개수를 세고 / 토탈 => 개수 센거 저장 tmp
 * b. 두번째도 다음수와 비교한뒤에 개수를 세고 / 토탈-tmp
 * <p>
 *
 * <p>
 * <p>
 * 1 2 2 2 3 3 4 6
 */
public class XPG_실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(N, stages);
    }

    public static int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        Map<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }

}

/**
 * * 1. 정렬한다
 * * 2. 해쉬맵을 사용해서 1번의 실패율 ... 이렇게 저장
 * * a. 처음부터 다음수와 비교한뒤에 개수를 세고 / 토탈 => 개수 센거 저장 tmp
 * * b. 두번째도 다음수와 비교한뒤에 개수를 세고 / 토탈-tmp
 * <p>
 * 문제점=====
 * 1. 마지막에 해쉬맵으로 정리한걸 배열로 못바꾸겠다... => map 을 stream 처리하기
 * 2. prevTotal, total, prev, now 변수를 너무 많이 쓰다보니 초기화하고 더하고 헷갈림. => 도전자 수를 받고 도전자 수의 i 로 제거하면돼.
 */