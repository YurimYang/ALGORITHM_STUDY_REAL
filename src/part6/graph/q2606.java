package part6.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.StringTokenizer;

public class q2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        int[][] line = new int[edge][2];

        for(int i = 0; i< edge; i++){
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken())-1;
            line[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        boolean[] done = new boolean[node];
        int[][] mp = new int [node][node];

        for(int i =0; i<edge; i++){
            int f = line[i][0];
            int s = line[i][1];

            mp[f][s] = mp[s][f] = 1;
        }

        for(int j = 0;j<node;j++){
            mp[j][j] = 1;
        }

        int ans = BFS(node, done, mp, 0);
        System.out.println(ans);

    }

    private static int BFS(int node, boolean[] done, int[][]mp, int n){
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        done[n] = true;

        while(!q.isEmpty()){
            int s = q.poll();

            for(int i = 0; i<s;i++){
                if(mp[s][i] != 1 || done[i] == true) {
                    continue;
                }

                q.add(i);
                done[i] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
