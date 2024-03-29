package programmers.level2;

/**
 * 1. 명령어는 UDRL
 * 2. 내가 밟은 좌표를 기록해서 중복을 제거하자.
 * 3. 좌표 끝을 주의할것. -5~5
 * 선이 100개밖에 안됨
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 완탐
 * Hashset 으로 좌표저장.
 * 좌표를 객체로 넣자.
 */

public class XPG_방문길이 {
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }


    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValidMove(nx, ny))
                continue;
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }
        return answer.size() / 2;

    }


    class Spot {
        private final int x;
        private final int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/**
 * 실패 1. 음수좌표때문에 2차원배열을 못한다는걸 눈치 못챔 => 원점을 옮기기
 * 2. 구현문제이기때문에 기능별로 함수를 쪼개기
 */
