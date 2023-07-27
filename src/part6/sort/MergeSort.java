package part6.sort;

public class MergeSort implements ISort{
    //InPlace Sort (OutofPlace보다 어려우므로!)

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    // 분할
    private void mergeSort(int[] arr, int low, int high){
        //종료조건(배열 크기가 1일때까지)
        if(low >= high){
            return; //서브리스트의 크기가 1인 경우
        }
        int mid = low + ((high -low)/2);
        //재귀호출 진행
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);

        merge(arr, low, mid, high);
    }

    // 합병
    private void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1]; //보조배열
        int idx = 0;

        int left = low; //분할된 왼쪽 리스트의 시작 인덱스
        int right = mid +1; //분할된 오른쪽 리스트의 시작 인덱스
        while(left<=mid && right <= high) {
            if (arr[left] <= arr[right]){
                temp[idx] = arr[left];
                left++;
            }else{
                temp[idx] = arr[right];
                right++;
            }
            idx++;
        }
        //왼쪽 리스트에 값이 남아 있는 경우
        while(left <= mid){
            temp[idx] = arr[left];
            idx++;
            left++;
        }

        //오른쪽 리스트에 값이 남아 있는 경우
        while(right <= high){
            temp[idx] = arr[right];
            idx++;
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = temp[i - low];
        }
    }
}
