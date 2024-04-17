import java.util.*;
class Solution {
    static int[] island;
    public int solution(int n, int[][] costs) {
        island = new int[n+1];
        int result = 0;
        for(int i=0; i< island.length; i++){
            island[i] = i;
        }
        Arrays.sort(costs,(o1,o2)-> (o1[2]-o2[2]));
        
        for(int[] cost : costs){
            if(n ==1){
                return result;
            }
            int num1 = cost[0];
            int num2 = cost[1];
            if(find(num1) == find(num2))
                continue;
            union(num1,num2);
            result += cost[2];
            n--;
        }
        return result;
    }
    private static int find(int x){
        if(x != island[x]){
            island[x] =find(island[x]);
        }
        return island[x];
    }
    private static void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);
        island[Math.min(root1,root2)] = Math.max(root1,root2);
    }
}