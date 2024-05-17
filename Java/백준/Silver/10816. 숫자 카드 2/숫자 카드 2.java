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
        int[] cards = new int[N];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(str1[i]);
        }
        int M = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");
        int[] myCard = new int[M];
        for (int i = 0; i < myCard.length; i++) {
            myCard[i] = Integer.parseInt(str2[i]);
        }
        for (int card : myCard) {
            hashMap.put(card, 0);
        }
        for (int card : cards) {
            if (hashMap.containsKey(card)) {
                hashMap.put(card, hashMap.getOrDefault(card, 0) + 1);
            }
        }
        for (int card : myCard) {
            sb.append(hashMap.get(card)).append(" ");
        }
        System.out.print(sb);
    }
}
