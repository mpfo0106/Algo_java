//package softeer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * arr[i][j] 시계방향 1 = arr[i][j-1]// if j-1  < 0 => i+1 j==0 // if
// * 시계방향 기준
// * 서쪽은 j-1 . j<0 이면 i= i+1(기존 0) j==0 하고 북로 넘겨.
// * 북쪽은 i+1. i==n 이면 i=n-1(기존 유지) 하고, j= j+1(기존 0) 로 동으로 넘겨
// * 동쪽은 j+1. j==n 이면 i= n-2(기존 n-1) 하고, j= n-1 (유지)
// * 남쪽은 i-1. i<0 이면 i= 0(기존 유지) 하고, j= n-2 (기존 n-1)
// *
// *
// * 5 -2
// * 강미나 김도연 김세정 김소혜 김청하
// * 유연정 임나영 전소미 정채연 주결경
// * 최유정 강시라 기희현 김나영 김소희
// * 박소연 윤채경 이해인 전소연 정은우
// * 한혜리 강예빈 권은빈 김다니 김서경
// *
// * 김세정 김소혜 김청하 주결경 김소희
// * 김도연 윤채경 강시라 임나영 정은우
// * 강미나 이해인 기희현 전소미 김서경
// * 유연정 전소연 김나영 정채연 김다니
// * 최유정 박소연 한혜리 강예빈 권은빈
// */
//public class pro7 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] tmp = br.readLine().split(" ");
//        int n = Integer.parseInt(tmp[0]);
//        int turn = Integer.parseInt(tmp[1]);
//        String[][] idol = new String[n][n];
//        for(int i=0; i<n; i++){
//            String[] line = br.readLine().split(" ");
//            for(int j =0; j<n; j++){
//                idol[i][j] = line[j];
//            }
//        }
//        int x1, y1, x2, y2;
//        for(int k = 0; k < Math.abs(turn); k++){
//            x1 = idol[k][0] - 1;
//            y1 = idol[k][1] - 1;
//            x2 = idol[k][2] - 1;
//            y2 = idol[k][3] - 1;
//
//            int x1y1_val = idol[x1][y1];   // (x1,y1) 임시저장
//            int min_val = x1y1_val;     // 최솟값
//
//            // ↑ 방향
//            for(int i = x1; i < x2; i++){
//                m[i][y1] = m[i + 1][y1];
//                min_val = Math.min(min_val, m[i][y1]);
//            }
//            // ← 방향
//            for(int j = y1; j < y2; j++){
//                m[x2][j] = m[x2][j + 1];
//                min_val = Math.min(min_val, m[x2][j]);
//            }
//            // ↓ 방향
//            for(int i = x2; i > x1; i--){
//                m[i][y2] = m[i - 1][y2];
//                min_val = Math.min(min_val, m[i][y2]);
//            }
//            // → 방향 ((x1,y1+1)은 따로)
//            for(int j = y2; j > y1 + 1; j--){
//                m[x1][j] = m[x1][j - 1];
//                min_val = Math.min(min_val, m[x1][j]);
//            }
//            m[x1][y1 + 1] = x1y1_val;
//
//            // 가장 작은 숫자 배열에 담기
//            answer[k] = min_val;
//        }
//
//        return answer;
//
//    }
//}
