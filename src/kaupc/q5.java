package kaupc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        Integer[][] query = new Integer[q][2];

        st = new StringTokenizer(br.readLine());

        //숫자열 잘 넣어줌 !!
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        //query 잘 넣어줌 !!
        for(int j = 0; j<q; j++){
            query[j][0] = Integer.parseInt(st.nextToken());
            query[j][1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
        }
        int ans = 0;
        for(int z = 0; z<q; z++){
            if(query[z][0] == 1){
                Loop:
                for(int a = 0; a<n-1; a++){
                    for(int b = a+1 ; b<n; b++){
                        if(arr[a] * arr[b] == query[z][1]){
                            System.out.println(1);
                            ans++;
                            break Loop;
                        }
                    }
                }
                if(ans==0){
                    System.out.println(0);
                }
                ans = 0;
            } else {
                int i = query[z][1];
                arr[i-1] = 0;
            }
        }
    }
}
