package part6.sort;

public class InsertionSort implements ISort{
    @Override
    public void sort(int[] arr) {
        for(int i =1; i< arr.length;i++){
            int key = arr[i]; //삽입 위치를 찾아줄 데이터
            int j = i-1;  //0~j까지 정렬된 서브 리스트

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1; //역순으로 진행
            }
            arr[j+1] = key;
        }
    }
}
