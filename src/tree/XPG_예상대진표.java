package tree;

/**
 * 요구조건
 * 토너먼트.
 * 라운드 갈때마다 N/2 번 ex) 3/2 =2
 * <p>
 * 제한사항
 * N<= 2^20 = 백만. O(NlogN)까지 가능
 */

/**
 * n-1 , n /2
 * <p>
 * <p>
 * 2 vs  2  5/6 7
 * 1,2,3,4,5,6,7,8
 */
public class XPG_예상대진표 {
    public int solution(int n, int a, int b) {
        int answer;
        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
}

/**
 * 시간초과.
 * 아이디어 생각을 못함. 그림을 그려보자.
 */