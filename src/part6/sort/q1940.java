package part6.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1940 {
    public static void main(String[] args) throws IOException {
        //1, 재료의 개수 : n
        //2. 2개로 m이 되는지 check : 갑옷을 만드는데 필요한 수 : m
        //3. n개의 재료들이 가진 고유한 번호들
        // 2 7 4 1 5 3  => 2+7 || 4+5
        //[two-pointer]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
//        int[] arr = new int[0];
//
//        for(int i =0; i<n ; i++){
//            int num = Integer.parseInt(st.nextToken());
//            arr[i] = num;
//        }
//
//        int ans = 0;
//        for(int i =0; i<n;i++){
//            int key = arr[i];
//            int search = m - arr[i];
//            int newNum = n-1;
//            while(newNum-- > 0){
//                if(arr[newNum] == search){
//                    ans+=1;
//                }
//            }
//        }
//
//        System.out.println(ans/2);
        for(int i =0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //1 2 3 4 5 7
        int i = 0;
        int j = n-1;
        int ans = 0;

        while(i<j){
            if(arr[i]+arr[j] == m){
                ans++;
                i++;
                j--;
            }else if(arr[i] + arr[j] > m){
                j--;
            }else if(arr[i] + arr[j] < m){
                i++;
            }
        }

        System.out.println(ans);




    }
}
