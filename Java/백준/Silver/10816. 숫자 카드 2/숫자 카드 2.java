import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(str1[i]);
            hashMap.put(card, hashMap.getOrDefault(card, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(str2[i]);
            sb.append(hashMap.getOrDefault(card, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
