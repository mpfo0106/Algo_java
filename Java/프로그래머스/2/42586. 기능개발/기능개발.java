import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            days[i] = (int)Math.ceil((100.0- progresses[i])/speeds[i]);
        }
        int cnt = 0;
        int maxDay = days[0];
        
    for(int i=0; i<n; i++){
        if(days[i] <= maxDay){
            cnt++;
        }
        else{
            answer.addLast(cnt);
            maxDay = days[i];
            cnt = 1;
        }
    }
        answer.addLast(cnt); 
        
    return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}