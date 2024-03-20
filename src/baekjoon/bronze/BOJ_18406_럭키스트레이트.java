package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N/2 해서 왼쪽 오른쪽 합 비교
 */
public class BOJ_18406_럭키스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split("");
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < list.length / 2; i++) {
            leftSum += Integer.parseInt(list[i]);
        }
        for (int j = list.length / 2; j < list.length; j++) {
            rightSum += Integer.parseInt(list[j]);
        }
        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] c = br.readLine().toCharArray();
//        int leftSum =0;
//        int rightSum =0;
//        for(int i=0; i<c.length/2; i++){
//            leftSum +=c[i] - '0';
//        }
//        for(int j=c.length/2; j<c.length; j++){
//            rightSum+=c[j] -'0';
//        }
//        System.out.println(leftSum == rightSum ? "LUCKY"  : "READY");
//    }
}
