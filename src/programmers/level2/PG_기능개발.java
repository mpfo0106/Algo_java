//package programmers.level2;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * 1.앞 기능이 배포되어야 뒤기능 배포 가능
// * 2. 맨 앞 배포될때 몇개 배포되는지를 살펴보면된다
// * 3. 큐 peek 로 검사
// * 93 + 1* x = 100- 93/
// */
//public class PG_기능개발 {
//    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
//        solution(progresses, speeds);
//    }
//
//    public static int[] solution(int[] progresses, int[] speeds) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        Queue<Integer> queue = new LinkedList<>();
//        int cnt = 1;
//        for (int num : progresses) {
//            queue.offer(num);
//        }
//        if (queue.peek() < 100) {
//            int days = 100 - queue.get(0) / speeds[0];
//        }
//
//        int[] answer = {};
//        return answer;
//    }
//
//}
