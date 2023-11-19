package swea.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//선수들이 n 명주어지고, 선수들의 실력 차가 k 이하가 되도록 팀을 구성하라.
//다음 줄에는 선수들 각각의 실력이 주어진다.
//
//최대 몇팀까지 구성할 수 있는지를 출력하라.
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= T; idx++) {
            StringBuilder sb = new StringBuilder();
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String[] skills = br.readLine().split(" ");
            int[] people = new int[n];

            int maxi = 1;
            for (int i = 0; i < n; i++) {
                people[i] = Integer.parseInt(skills[i]);
            }
            Arrays.sort(people);
            for (int i = 0; i < people.length; i++) {
                int ans = 1;
                for (int j = i + 1; j < people.length; j++) {

                    if (people[j] - people[i] <= k) {
                        ans += 1;
                        if (ans == n) {
                            maxi = Math.max(ans, maxi);
                        }
                    } else {
                        maxi = Math.max(ans, maxi);
                        break;
                    }

                }
            }
            sb.append("#").append(idx).append(" ").append(maxi);
            System.out.println(sb);

        }

    }
}

/**
 * input을 받아서 input 값 중 최대값 - 최솟값 <=K
 * if(초과한다면) 한명씩 내리거나 올려야겠지. max 값을 두고 (하나를 올리는거, 하나를 내리는거)로.
 * 2346
 * 4
 * 1. for 로 0번부터 돌면서 몇개를 최대로 넣는지
 */
