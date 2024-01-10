package programmers.level2;

import java.util.HashSet;


/**
 * 일단 만들수 있는 경우의 수를 다 넣어보고, 소수판정
 * 소수 판정 => 제곱근 까지만 따져보면돼.
 * 공통: 우선 경우의 수를 다 만들어야해. => 백트래킹 하자.
 * 1. 에라토스테네스의 채를 이용하자
 * 배열 돌면서
 * 2. 얼마 안되니까 깡으로 노가다하자
 */
public class PG_소수찾기 {
    static HashSet<Integer> hashSet = new HashSet<>();
    static char[] arr; //종이조각
    static boolean[] visited; // 사용여부

    public int solution(String numbers) {
        int answer = 0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        recursion("", 0);
        answer = hashSet.size();
        return answer;
    }

    public void recursion(String str, int idx) {
        int num;
        if (!str.equals("")) {  // 비어있다면
            num = Integer.parseInt(str);
            if (isPrime(num)) {
                hashSet.add(num);
            }
        }
        if (idx == arr.length)   //끝까지 다 돌면 return
            return;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])  //방문했으면 넘어가
                continue;
            visited[i] = true;  //방문안헀으면 방문 체크하고
            recursion(str + arr[i], idx + 1);
            visited[i] = false; //재귀 다 돌았으면 다시 원래대로 돌려놔.
        }
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PG_소수찾기 pg_소수찾기 = new PG_소수찾기();
        String numbers = "";
        System.out.println(pg_소수찾기.solution(numbers));
    }
}
