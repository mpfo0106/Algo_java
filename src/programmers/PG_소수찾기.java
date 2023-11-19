//package programmers;
//
//import java.util.*;
//
///**
// * 일단 만들수 있는 경우의 수를 다 넣어보고, 소수판정
// * 소수 판정 => 제곱근 까지만 따져보면돼.
// * 공통: 우선 경우의 수를 다 만들어야해. => 백트래킹 하자.
// 1. 에라토스테네스의 채를 이용하자
// * 배열 돌면서
// 2. 얼마 안되니까 깡으로 노가다하자
// */
//public class PG_소수찾기 {
//    public int solution(String numbers) {
//        String[] str = numbers.split("");
//        Arrays.sort(str, Comparator.reverseOrder());
//        Set<Integer> hashSet = new HashSet<>();
//        generateNumbers(numbers,"",hashSet);
//        int maxi = Integer.parseInt(String.valueOf(str));
//        boolean[] chae = new boolean[maxi + 1];
//        for (int i = 1; i < Math.sqrt(maxi) + 1; i++) {
//            if (!chae[i]) {
//                int j = 2;
//                while (i * j <= maxi) {
//                    chae[i * j] = true;
//                    j += 1;
//                }
//            }
//        }
//        for(int i=0; i<chae.length; i++){
//            if(!chae[i]){
//
//            }
//        }
//
//        int answer = 0;
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        PG_소수찾기 pg_소수찾기 = new PG_소수찾기();
//        String numbers = "";
//        System.out.println(pg_소수찾기.solution(numbers));
//    }
//}
