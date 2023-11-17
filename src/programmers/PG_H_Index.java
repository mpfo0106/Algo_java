package programmers;

import java.util.Arrays;
import java.util.Collections;

/**
 * 우선 논문 인용수를 역정렬해야해.
 * 그리고 for 문 타고 하나씩 내려가면서 검사.
 * if(논문수> 인용수) 이면 stop  논문수 < 인용수 일때까지!
 */

public class PG_H_Index {
    public int solution(int[] citations) {
        Integer[] citationsObj = new Integer[citations.length];
        int h = 0;
        for (int i = 0; i < citationsObj.length; i++) {
            citationsObj[i] = citations[i];
        }
        Arrays.sort(citationsObj, Collections.reverseOrder());
        for (int idx = 0; idx < citationsObj.length; idx++) {
            if (idx + 1 <= citationsObj[idx])
                h = idx + 1;
            else {
                break;
            }
        }

        return h;
    }

    public static void main(String[] args) {
        PG_H_Index pg_h_index = new PG_H_Index();
        int[] citations = {10, 10, 10, 10, 10};
        System.out.println(pg_h_index.solution(citations));
    }
}
