package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1859_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");

            long sum = 0;
            long maxPrice = 0;

            int[] prices = new int[line.length];
            for (int j = n - 1; j >= 0; j--) {
                int currentPrice = Integer.parseInt(line[j]);
                if (maxPrice < currentPrice) {
                    maxPrice = currentPrice;
                } else {
                    sum += maxPrice - currentPrice;
                }
            }


            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
