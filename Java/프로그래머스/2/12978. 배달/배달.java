import java.util.*;
class Solution {
    private static boolean[] visited;
    private static int[] dist;
    private static ArrayList<Node>[] adj;
    public int solution(int N, int[][] road, int K) {
        adj = new ArrayList[N+1];
        for(int i=1;i<N+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : road){
            adj[edge[0]].add(new Node(edge[1],edge[2]));
            adj[edge[1]].add(new Node(edge[0],edge[2]));
        }
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        visited = new boolean[N+1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.c,o2.c));
        pq.add(new Node(1,0));
        dist[1] = 0;
        while(!pq.isEmpty()){
            Node now =pq.poll();
            if(visited[now.dst])
               continue;
            visited[now.dst] = true;
            for(Node next : adj[now.dst]){
                int newC =now.c + next.c;
                if (newC >K){
                    continue;
                }
                if(dist[next.dst] >newC){
                    dist[next.dst] = newC;
                    pq.add(new Node(next.dst, newC));
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<dist.length; i++){
            if(dist[i] <=K)
                answer++;
        }
        
        return answer;
    }
    private static class Node{
        private int dst,c;
        Node(int dst,int c){
            this.dst = dst;
            this.c = c;
        }
    }
}