package part6.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedHashTable<K, V> implements IHashTable<K, V>{
    private static final int DEFAULT_BUCKET_SIZE = 1024;

    private List<Node>[] buckets;
    private int size;
    private int bucketSize;

    //이미 지정된 bucket 사이즈를 선택할 때
    public MyLinkedHashTable(){
        this.buckets = new List[DEFAULT_BUCKET_SIZE];
        this.bucketSize = DEFAULT_BUCKET_SIZE;
        this.size = 0;

        for(int i =0; i<bucketSize;i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    //사용자가 bucket 사이즈를 지정할 경우
    public MyLinkedHashTable(int bucketSize){
        this.buckets = new List[bucketSize];
        this.bucketSize = bucketSize;
        this.size = 0;

        for(int i =0; i<bucketSize;i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        //중복된 키를 넣으면 update를 함
        for (Node node: bucket){
            if(node.key.equals(key)){
                node.data = value;
                return;
            }
        }
        Node node = new Node(key, value);
        bucket.add(node);
        size++;
    }

    @Override
    public V get(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for(Node node : bucket){
            if(node.key.equals(key)){
                return node.data; //같을 경우, 차후의 값을 return
            }
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        //data 집합에서 값을 하나씩 꺼내오는 것
        for(Iterator<Node> iter = bucket.iterator();iter.hasNext();){
            //data가 남아있지 않을 때 까지!!
            Node node = iter.next();
            if(node.key.equals(key)){
                iter.remove();
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for(Node node : bucket){
            if(node.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hash(K key){
        int hash = 0;
        for(Character ch : key.toString().toCharArray()){
            //문자열을 한 글자씩 순환
            hash += (int) ch; //아스키로 바꿔서 hash에 더함
        }
        return hash % this.bucketSize; //bucketSize보다 커질 수 없음음
   }

    //데이터는 노드로 key와 value 쌍으로 저장
    private class Node{
        K key;
        V data;

        Node(K key, V data){
            this.key = key;
            this.data = data;
        }
    }
}
