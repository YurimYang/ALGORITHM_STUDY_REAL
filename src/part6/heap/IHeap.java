package part6.heap;

public interface IHeap<T>{
    void insert(T val);
    boolean contains(T val);
    T pop();
    T peek();

    int size();
}
