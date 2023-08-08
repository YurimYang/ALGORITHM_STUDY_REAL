package part6.graph;

import java.util.Arrays;

public class q_Network {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers =  {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(n,computers);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;
        int tmp = 0;
        for(int i = 0; i<computers.length;i++){
            for(int j = 0; j<computers.length;j++){
                tmp = dfs(tmp,computers,i,j);
            }
        }
        tmp /=2;
        if(tmp == n){
            return 1;
        } else {
            n -= tmp;
            answer = n;
        }
        return answer;
    }
    private static int dfs(int tmp, int[][] computers, int i, int j){
        if(i!=j && computers[i][j] == 1 && computers[j][i] == 1){
            tmp++;
        }
        return tmp;
    }
}
