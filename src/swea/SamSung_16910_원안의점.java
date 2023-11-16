package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SamSung_16910_원안의점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int x,y;
            x = y = (n*-1);
            int cnt = 0;
            while (x <= n && y<=n) {
                if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(n, 2)) {
                    cnt++;
                }
                y += 1;
                if (y > n) {
                    y = (n*-1);
                    x += 1;
                }
            }
            sb.append("#"+(i+1)+" "+cnt).append('\n');
        }
        System.out.print(sb);
    }
}
