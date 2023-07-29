package part6.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11399_re {
    //counting sort 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[10];

        while(n-- > 0){
            arr[Integer.parseInt(st.nextToken())]++;
            //굳이 for문을 쓸 필요 없이 한줄로 쓰는 방법
        }
        for(int num : arr){
            System.out.print(num);
        }

        int prev = 0;
        int sum = 0;

        for (int i =0; i< 1001; i++){
            while(arr[i]-- > 0){
                sum += (i + prev);

                prev += i;
            }
        }
        System.out.println(sum);

    }
}
