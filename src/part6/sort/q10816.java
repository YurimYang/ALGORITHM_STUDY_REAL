package part6.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            hm.put(num,hm.getOrDefault(num,0) + 1);
        }


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int j =0; j<m;j++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(hm.getOrDefault(key,0)+" ");
        }

        System.out.println(sb);

    }
}
