package part6.stack;

public interface IStack<T> {
    void push(T data);
    T pop();
    T peek();
    int size();
}
