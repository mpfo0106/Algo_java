//package softeer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///**
// *  그리디문제
// * 최대 이익을 낼 수 있는 마을까지 경로
// * 최종 보유금액, 잔여 연료량
// *
// * 첫번째 마을 빼고 기름 +10
// * 특산품 판매 +300, 구매 -100
// *
// */
//public class pro2 {
//
//    static int n, oil;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        n = Integer.parseInt(br.readLine());
//        round = new ArrayList<>();
//        graph = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < n; j++) {
//                graph[i][j] = line.charAt(j) - '0';
//            }
//        }
//    }
//}
