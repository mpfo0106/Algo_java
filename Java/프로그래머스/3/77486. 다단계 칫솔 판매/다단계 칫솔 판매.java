import java.util.HashMap;
class Solution {
       public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //enroll : referral
        HashMap<String, String> tree = new HashMap<>();
        HashMap<String, Integer> moneyMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], referral[i]);
            moneyMap.put(enroll[i], 0);
        }
        for (int i = 0; i < seller.length; i++) {
            String person = seller[i];
            int sum = 100 * amount[i];
            while (!person.equals("-")) {
                if (sum < 10) {
                    moneyMap.put(person, moneyMap.get(person) + sum);
                    break;
                }
                int percent10 = (int) Math.floor(0.1 * sum);
                int money = sum - percent10;
                moneyMap.put(person, moneyMap.get(person) + money);
                person = tree.get(person);
                sum = percent10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = moneyMap.get(enroll[i]);
        }
        return answer;
    }
}