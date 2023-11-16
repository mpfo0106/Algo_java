package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2072_홀수만더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int sum = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(num -> num % 2 != 0)
                    .sum();
            sb.append('#').append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
