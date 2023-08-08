package part6.graph;

public class q_Network_Re {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers =  {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(n,computers);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] check = new boolean[n];

        for(int i = 0; i<n;i++){
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }
    private static boolean[] dfs(int[][] computers, int i, boolean[] check){
        for(int j = 0; j<computers.length; j++){
            if(i!=j && computers[i][j] ==1 && check[j] == false){
                check = dfs(computers, j, check);
            }
        }
        return check;
    }
}
