///*
//현재 (1,1) 5,5
//
//흰색만 밟아 1만 밟아.
//
//길 안이어져있으면 못가.
//
// */
//
//package programmers.level2;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class PG_게임맵최단거리 {
//    static int[][] maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
//
//    public static void main(String[] args) {
//        int answer = 0;
//        for(int i=0; i<maps.length;i++){
//            for (int j =0; j<maps[i].length; j++){
//                dfs(i,j);
//            }
//        }
//
//        return answer;
//
//    }
//
//    public static boolean dfs(int x,int y) {
//
//
//    }