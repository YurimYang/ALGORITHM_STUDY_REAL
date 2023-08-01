package part6.heap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {

    T[] data;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Comparable[maxSize + 1];
        this.size = 0;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return pos * 2;
    }

    private int rightChild(int pos){
        return pos * 2 + 1;
    }

    private boolean isLeaf(int pos){
        return (pos > (size/2) && pos <= size);
    }


    @Override
    public void insert(T val) {
        this.data[++this.size] = val; //마지막 노드자리에 삽입
        int current = this.size; //데이터가 삽입된 위치

        while(this.data[parent(current)] != null &&
                this.data[current].compareTo(this.data[parent(current)]) > 0){
            //현재 위치와 부모 위치의 데이터 확인
            Collections.swap(Arrays.asList(this.data), current, parent(current));
            current = parent(current);
        }

    }

    @Override
    public boolean contains(T val) {
        for(int i =1; i< this.size; i++){
            if(val.equals(this.data[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public T pop() {
        T top = this.data[1]; //인덱스 1번째 (fifo)
        this.data[1] = this.data[this.size--]; //완전이진트리의 속성 유지시키기
        heapify(1);//1번 위치의 heap
        return null;
    }

    private void heapify(int idx){
        if(isLeaf(idx)){
            return; //leaf일 경우 heapify를 할게 더이상 없음 !!
        }
        T current = this.data[idx];
        T left = this.data[leftChild(idx)];
        T right = this.data[rightChild(idx)];

        //둘 중 하나라도 값이 크면 안됨
        if(current.compareTo(left) < 0 || current.compareTo(right) <0){
            if(left.compareTo(right) > 0){ //left가 큰 경우 left와 바꿔줌
                Collections.swap(Arrays.asList(this.data), idx, leftChild(idx));
                heapify(leftChild(idx));
            } else { //right가 큰 경우 right와 바꿔줌
                Collections.swap(Arrays.asList(this.data), idx, rightChild(idx));
                heapify(leftChild(idx)); // 바뀐 위치도 heap을 만족하는지 !
            }
        }
    }

    @Override
    public T peek() {
        if(this.size < 1){
            throw new RuntimeException(); //구체적으로 어떤 에러가 났는지 표현해주는 것이 더 좋음 !
        }
        return this.data[1];
    }

    @Override
    public int size() {
        return this.size;
    }
}
