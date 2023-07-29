package part6.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        //삽입정렬로 진행
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            /**
            for(int j =0; j<i;j++){
                if(arr[j]<num){
                    break;
                }else{
                    arr[j+1] = arr[j];
                    arr[j] = num;
                }
                arr[j+1] = num;
            }**/
        }
        int sortedArr[] = InsertSort(arr);
        ArrSum(sortedArr);

    }

    //삽입정렬로 진행
    public static int[] InsertSort(int[] arr){
        for(int i =1; i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public static void ArrSum(int[] arr){
        int sum = arr[0];
        int finalSum = sum;
        for(int i =1; i<arr.length ; i++){
            sum+=arr[i];
            finalSum += sum;
        }
        System.out.println(finalSum);
    }

}

