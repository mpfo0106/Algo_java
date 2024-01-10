/* n이 어떤 양의 정수 x의 제곱인지 아닌지 판별

n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
n이 양의 정수 x의 제곱이 아니라면 -1을 리턴

제곱근 때린게 정수면 리턴
아니면 -1
 */

package programmers.level1;

public class PG_정수_제곱근_판별 {
    public static void main(String[] args) {
        int n= 3;
        System.out.println(solution(n));
    }


    public static long solution(long n) {
        double sqrtN = Math.sqrt(n);
        long answer = 0;
        if (sqrtN % 1 != 0) { //나머지가 있다면 제곱근 X
            answer = -1;
        } else {
            answer = (long) Math.pow((sqrtN) + 1, 2);
        }
        return answer;
    }

}
//sqrtN % 1 에 대해 1을 사용하여 모듈로 연산을 수행하면 기본적으로 해당 double의 소수 부분을 확인