package programmers;

import java.util.Arrays;

/**
 * 1. 숫자의 앞자리가 중요
 * 2. 앞자리가 같다면 두번째 자리 큰거.
 * 3. 0이 계속 오면 예외. ex) 0,0,0
 * <p>
 * #1-1. 배열 정렬을해. 아 문자열로 정렬하면돼!
 * #1-2. 문자열 역순으로 정렬하고 그냥 붙여.
 * #1-3문제 발생.
 * 앞자리 숫자가 같으면 무조건 짧은게 좋은게 아님 // 3 35 일때 처럼 뒷자리가 앞자리 보다 커야해.
 * <p>
 * 검사1. 양측 첫번째 자리 같나.
 * 2. 같으면 length 확인.
 */
public class PG_가장큰수 {
    public String solution(int[] numbers) {
        String[] stringArray = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringArray.length; i++) {    //문자열 배열로 만들고
            stringArray[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(stringArray, (a, b) -> (b + a).compareTo(a + b));

        if (stringArray[0].equals("0")) { //정렬 후에도 0이 맨앞이면
            return "0";
        }

        for (String s : stringArray) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PG_가장큰수 pg_가장큰수 = new PG_가장큰수();
        int[] numbers = {0, 0, 0};
        System.out.println(pg_가장큰수.solution(numbers));
    }
}
