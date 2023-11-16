package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileInputStream;

public class SWEA_사전문제_민석이의마니또 {
    final static int INF = 99999;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/sample_input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int ca=0; ca<t; ca++){
            String[] nm = br.readLine().split(" ");
            int n =Integer.parseInt(nm[0]);
            int m =Integer.parseInt(nm[1]);
            int[][] graph = new int[n+1][n+1];
            for(int a=0; a<n+1; a++){ //그래프 초기화
                for(int b=0; b<n+1; b++){
                    graph[a][b] = INF; //나로 돌아오는걸 세야함으로 전부 INF로 둔다.
                }
            }
            for(int j = 0; j<m; j++) {
                String[] xyc = br.readLine().split(" ");
                int x =Integer.parseInt(xyc[0]);
                int y =Integer.parseInt(xyc[1]);
                int c =Integer.parseInt(xyc[2]);
                graph[x][y] = c;
            }
            int[][] dist = new int[n+1][n+1];
            for (int i = 0; i < n+1; i++) //결과 저장할 dist 초기화
                dist[i] = Arrays.copyOf(graph[i], n+1);

            for(int k = 1; k<n+1; k++) { // Floyd Warshall 알고리즘
                for (int i = 1; i < n + 1; i++)
                    for (int j = 1; j < n + 1; j++) {
                        if (dist[i][k] + dist[k][j] < dist[i][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
            }
            int minCycleCost = INF;
            for(int i=0; i<n+1; i++) {
                if(dist[i][i]<minCycleCost)
                    minCycleCost = dist[i][i];
            }
            if (minCycleCost == INF)
                minCycleCost = -1;
            sb.append("#").append(ca+1).append(" ").append(minCycleCost).append("\n");
        }
        System.out.print(sb);
    }
}
