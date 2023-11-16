package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO 탑다운으로 접근. 재귀
public class BOJ_2630_색종이만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(br.readLine().strip());
        int [][] paper = new int[N][N];
        for(int i=0; i<N; i++){ //색종이 받기
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[] result = count_paper(paper,0,0,N-1,N-1);
        sb.append(result[0]).append("\n").append(result[1]);
        System.out.print(sb);
    }
    static int[] count_paper(int[][] paper,int x1,int y1, int x2, int y2){//왼쪽 상단좌표와 오른쪽 하단 좌표를 기록
        int[] result =new int[2]; // result0 : 화이트, result1 : 블루
        int n = x2-x1+1;
        boolean isAllBlue = true;
        boolean isAllWhite = true;
        for(int i= x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(paper[i][j] != 1){
                    isAllBlue = false;
                }
                else { // 흰색이 아닐때
                    isAllWhite = false;
                }
            }
            if(!isAllBlue && !isAllWhite) break; //두 색상 모두 통일이 아니면 빨리 탈출하기 위함
        }
        if (isAllBlue){ // 전부 블루일때
            result[1] = 1;

        } else if (isAllWhite) { //전부 화이트일때
            result[0] = 1;
        } else if (n ==1) { // 색종이가 가장 작은 최소단위일 경우
            return result;
        }
        else {
            int midX =(x1+x2)/2; //절반
            int midY =(y1+y2)/2;
            int[] topLeft = count_paper(paper,x1,y1,midX,midY);
            int[] topRight = count_paper(paper,midX+1,y1,x2,midY);
            int[] bottomLeft = count_paper(paper,x1,midY+1,midX,y2);
            int[] bottomRight= count_paper(paper,midX+1,midY+1,x2,y2);

            result[0] = topLeft[0] + topRight[0] + bottomLeft[0]+ bottomRight[0];
            result[1] = topLeft[1] + topRight[1] + bottomLeft[1]+ bottomRight[1];
        }
        return result;
    }
}


