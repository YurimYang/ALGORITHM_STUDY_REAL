package kaupc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.Math.max;

public class q1 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringBuilder sb = new StringBuilder();
//            ArrayList<Integer> run = new ArrayList<>();
//            ArrayList<Integer> trick = new ArrayList<>();
//            ArrayList<Integer> arr = new ArrayList<>();

            int n = Integer.parseInt(br.readLine()); //사람의 수
            int[] arr = new int[7];
//            int[] run = new int[2];
//            int[] trick = new int[5];
//            int idx = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i =0; i<7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                int idx = 2;
                int[] run = new int[idx];
                int[] trick = new int[arr.length - idx];

                for (int j = 0; j < arr.length; j++) {
                    if (j < idx) {
                        run[j] = arr[j];
                    } else {
                        trick[j - idx] = arr[j];
                    }
                }

                System.out.println(Arrays.toString(run));
                System.out.println(Arrays.toString(trick));

//                for(int j =0; j<2; j++){
//                    run[j] = arr[j];
//                }
//                for(int k = 0; k<5; k++){
//                    trick[k] = arr[k+2];
//                }
//
//                Arrays.sort(run);
//                Arrays.sort(trick);
//                for(int num:run){
//                    System.out.print(num + " ");
//                }
//                System.out.println("ok");
//                for(int num2:trick){
//                    System.out.print(num2+ " ");
//                }

            }




//                for(int i = 0; i<2 ; i++){
//                    run[i] = Integer.parseInt(st.nextToken());
////                    int num = Integer.parseInt(st.nextToken());
////                    run.add(num);
//                }
//                st = new StringTokenizer(br.readLine());
//                for(int i =0; i<5;i++){
//                    trick[i] = Integer.parseInt(st.nextToken());
////                    int num2 = Integer.parseInt(st.nextToken());
////                    trick.add(num2);
//                }
//                Arrays.sort(run);
//                Arrays.sort(trick);
//                System.out.println(run[0]);
//                System.out.println(trick[0]);
//
////                int ans = 0;
////                ans = run[-1] + trick[-1] + trick[-2];
////
////                arr[idx] = ans;
////                idx++;
//            }
//
////            System.out.println(arr);



        }
}
