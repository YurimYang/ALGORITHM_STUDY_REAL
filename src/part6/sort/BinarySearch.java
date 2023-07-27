package part6.sort;

public class BinarySearch {
    public int search(int[] arr, int target){
        int l = 0; //array의 가장 왼쪽
        int r = arr.length -1; //array의 가장 오른쪽
        int m; //중간값

        while(l <= r){
            //m = (l+r)/2; //이렇게 하면 l+r에서 오버플로우가 발생할 수 있음
            m = l + ((r-1)/2); //이렇게 바꿀 수 있다.

            if(arr[m] == target){
                return m;
            }
            if(arr[m] < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return -1;
    }
}
