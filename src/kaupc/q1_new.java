package kaupc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q1_new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[7];
        int[] ans = new int[n];
        int pos = 0;

        while(n-- > 0){
            for(int i=0; i<7; i++){
                arr[i] = sc.nextInt();
            }
            int idx = 2;
            Integer [] run = new Integer[idx];
            Integer [] trick = new Integer[arr.length - idx];

            for (int j = 0; j < arr.length; j++) {
                if (j < idx) {
                    run[j] = arr[j];
                } else {
                    trick[j - idx] = arr[j];
                }
            }
            Arrays.sort(run, Collections.reverseOrder());
            Arrays.sort(trick, Collections.reverseOrder());
            ans[pos] = run[0] + trick[0] + trick[1];


            arr = new int[7];
            run = new Integer[idx];
            trick = new Integer[arr.length - idx];
            pos++;
        }

        int max = Arrays.stream(ans).max().getAsInt();
        System.out.println(max);


    }
}
