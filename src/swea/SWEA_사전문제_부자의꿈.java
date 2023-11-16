package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_사전문제_부자의꿈 {
    static int safe(int[][] mars){
        

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            int cnt = 0;
            String[] nmq = br.readLine().split(" ");
            int n = Integer.parseInt(nmq[0]);
            int m = Integer.parseInt(nmq[1]);
            int q = Integer.parseInt(nmq[2]);
            int[][] mars = new int[n + 1][m + 1];
            for (int i = 1; i < n + 1; i++) { // 곰팡이 개수 받기
                for (int j = 1; j < m + 1; j++) {
                    String[] line = br.readLine().split(" ");
                    mars[i][j] = Integer.parseInt(line[j - 1]);
                }
            }
            for (int i = 0; i < q; i++) { //바뀐 좌표
                String[] change = br.readLine().split(" ");
                int r = Integer.parseInt(change[0]);
                int c = Integer.parseInt(change[1]);
                int x = Integer.parseInt(change[2]);
                mars[r][c] = x;
                int tmp = safe(mars);
                cnt+= tmp;
            }
            sb.append("#").append(t+1).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
