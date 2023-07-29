package kaupc;
import java.io.*;
import java.util.StringTokenizer;

public class q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        int even = 0;
        int odd = 0;
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        for(int i =0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int j =0; j<n;j++){
            if((j%2) == 0){
                odd += arr[j];
            } else{
                even += arr[j];
            }
        }
        if(n<=3){
            while(even!=odd){
                if(even>odd){
                    even +=1;
                    odd +=2;
                    ans++;
                } else {
                    ans = -1;
                    break;
                }
            }
            System.out.println(ans);
        } else {
            while(even != odd){
                if(even<odd){
                    even +=2;
                    odd +=1;
                    ans++;
                } else{
                    even +=1;
                    odd +=2;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

