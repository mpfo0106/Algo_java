package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1번이 찍는 방식 1~5 반복
 * 2번이 찍는 방식 2.{1}.2.{3}.2.{4}.2.{5}
 * 3번이 찍는 방식 33 -> 11 -> 22 -> 44 -> 55 -> 33
 * <p>
 * % 를 이용한 문제같음.
 */
public class PG_모의고사 {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] answer = {};

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % 5]) {
                score[0]++;
            }
            if (answers[i] == student2[i % 8]) {
                score[1]++;
            }
            if (answers[i] == student3[i % 10]) {
                score[2]++;
            }
        }
        int max = 0;
        for (int s : score) {
            if (s > max) {
                max = s;
            }
        }
        List<Integer> maxScores = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                maxScores.add(i + 1);
            }
        }
        // mapToInt 스트림에서 각 정수요소 i를 가져와 정수로 변환
        // toArray : 스트림 요소를 배열로 수집
        return maxScores.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        PG_모의고사 pg_모의고사 = new PG_모의고사();
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(pg_모의고사.solution(answers));
    }
}
