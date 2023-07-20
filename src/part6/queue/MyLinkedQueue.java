package part6.queue;

public class MyLinkedQueue<T> implements IQueue<T>{
    private Node head;
    public Node tail;
    private int size;

    public MyLinkedQueue(){
        this.size = 0;
        this.head = new Node(null); //dummy Node
        this.tail = this.head;
    }

    @Override
    public void offer(T data) {
        Node node = new Node(data);
        this.tail.next = node;
        this.tail = this.tail.next;
    }

    @Override
    public T poll() { //dequeue연산을 하는 과정
        if(this.isEmpty()){
            throw new IllegalStateException(); //비어있을 경우는 데이터를 뺄 수 없음
        }
        Node node = this.head.next;
        this.head.next = node.next;
        this.size--;

        if(this.head.next == null){
            this.tail = this.head;
        }
        return node.data;
    }

    @Override
    public T peek() {
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        return this.head.next.data;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = head;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
