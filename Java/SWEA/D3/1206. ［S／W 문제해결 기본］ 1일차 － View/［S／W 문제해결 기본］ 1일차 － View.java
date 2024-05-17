
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] building = new int[N];
            String[] line = br.readLine().split(" ");
            //초기화
            for (int j = 0; j < N; j++) {
                building[j] = Integer.parseInt(line[j]);
            }
            int count = 0;
            for (int j = 2; j < N - 2; j++) {
                int maxB = Math.max(Math.max(building[j - 2], building[j - 1]), Math.max(building[j + 1], building[j + 2]));
                if (building[j] > maxB) {
                    count += building[j] - maxB;
                }
            }
            sb.append("#").append(i).append(" ").append(count).append("\n");

        }
        System.out.println(sb);
    }
}