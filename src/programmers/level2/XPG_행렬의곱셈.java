package programmers.level2;

/**
 * arr1 에 arr2 를 곱한다.
 * 만들어지는건 arr1 3*2 2*2 => 3*2
 * arr1 의 length * arr2[0].length
 */
public class XPG_행렬의곱셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        return answer;
    }
}

/**
 * 행렬곱까지는 잘 떠올렸지만, 더하기 부분에서 for 문 추가를 잊어버림..
 */