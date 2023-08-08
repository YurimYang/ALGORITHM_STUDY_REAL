package part6.graph;

import java.util.Arrays;

public class q_targetNumber {
    public void main(String[] args) {
        int[] numbers = {4,1,2,1};
        int target = 4;
        solution(numbers,target);
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(answer, numbers, 0,0,target);
        return answer;
    }

    private void dfs(int answer, int[] numbers, int idx, int sum, int target){
        if(sum==target && idx == numbers.length){
            answer++;
            return;
        }

        if(idx >= numbers.length){
            return;
        }

        dfs(answer,numbers,idx+1,numbers[idx]+sum, target);
        dfs(answer, numbers, idx+1, -numbers[idx]+sum, target);

    }
}
