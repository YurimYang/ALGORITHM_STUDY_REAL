package part6.queue;

public class MyCircularQueue<T> implements IQueue<T> {
    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    public MyCircularQueue(int size){
        this.elements = (T[]) new Object[size+1]; //dummy공간 1개를 추가해놈
        this.front = 0;
        this.rear = 0;
        this.maxSize = size + 1;
    }

    @Override
    public void offer(T data) {
        if(this.isFull()){
            throw new IllegalStateException();
        }
        this.rear = (this.rear + 1) % this.maxSize; //큐의 인덱스 범위를 넘기지 않기 위해
        this.elements[this.rear] = data; //해당 위치를 옮겨두고 데이터를 넣음
    }

    @Override
    public T poll() {
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        this.front = (this.front + 1) % this.maxSize;
        return this.elements[this.front];
        //굳이 값을 넣어주는 작업을 하진 않아도 괜찮다 !
    }

    @Override
    public T peek() {
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        return this.elements[this.front + 1]; //front + 1의 위치의 내용을 확인할 수 있음
    }

    @Override
    public int size() {
        if(this.front <= this.size()){
            return this.rear - this.front;
        }
        return this.maxSize - this.front + this.rear;
    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }
    private boolean isFull(){
        return (this.rear + 1) % this.maxSize == this.front; //모듈러 연산까지 추가
    }
}
