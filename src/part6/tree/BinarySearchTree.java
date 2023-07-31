package part6.tree;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    private Node root;
    private int size;

    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }

    public T min() {
        return this.minNode(this.root);
    }

    private T minNode(Node node){
        T minData = node.data;
        while(node.left!=null){
            minData = node.left.data;
            node = node.left;
        }
        return minData;
    }

    public T max() {
        return this.maxNode(this.root);
    }

    private T maxNode(Node node){
        T maxNode = node.data;
        while(node.right!=null){
            maxNode = node.right.data;
            node = node.right;
        }
        return maxNode;
    }

    @Override
    public void insert(T val) {
        this.root = this.insertNode(this.root, val);
        this.size++;
    }

    private Node insertNode(Node node, T val){
        //값 비교를 해서 추가하고자 하는 val이 node보다 작으면 왼쪽, 크면 오른쪽에 위치
        if(node == null){
            return new Node(val); //맨 아래 위치라면, 새롭게 node생성
        }
        if(val.compareTo(node.data) < 0){
            node.left = insertNode(node.left, val); //기존 루트보다 작을 경우
        } else if (val.compareTo(node.data) > 0){
            node.right = insertNode(node.right, val); //기존 루트보다 클 경우
        }

        return node;
    }

    @Override
    public void delete(T val) {
        this.deleteNode(this.root, val);
    }

    private Node deleteNode(Node node, T val){
        if(node == null){
            return null; //안해주면 nullPointException 발생함
        }
        //자식 노드가 0개 (leaf)인 경우
        if(val.compareTo(node.data) < 0){
            node.left = deleteNode(node.left, val);
        } else if (val.compareTo(node.data) > 0){
            node.right = deleteNode(node.right, val);
        } else {
            //자식 노드가 1개인 경우
            this.size--;
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }

            //자식 노드가 2개인 경우
            node.data = this.minNode(node.right);
            node.right = deleteNode(node.right, node.data);
        }

        return node;
   }

    //값이 위치하는지 체크용
    @Override
    public boolean contains(T val) {
        return this.containsNode(this.root, val);
    }

    private boolean containsNode(Node node, T val){
        //a.comparteTo(b)
        // a < b -> -1
        // a == b -> 0
        // a > b -> 1
        //트리에 값이 존재함

        if(node == null){
            return false;
        }
        if(val.compareTo(node.data) == 0) {
            return true;
        } else if(val.compareTo(node.data)<0){
            return containsNode(node.left, val);

        }
        // val.comparteTo(node.data) > 0 인 경우우
        return containsNode(node.right, val);

    }

    @Override
    public int size() {
        return this.size;
    }

    public List<T> preOrder() {
        return this.preorderTree(root, new ArrayList<>());
    }

    //재귀호출된 함수 내부에서 계속 재귀호출 진행
    private List<T> preorderTree(Node node, List<T> visited){
        if(node == null){
            return visited;
        }
        visited.add(node.data);
        preorderTree(node.left, visited);
        preorderTree(node.right, visited);

        return visited;
    }

    public List<T> inOrder() {
        return this.inorderTree(root, new ArrayList<>());
    }

    //재귀호출된 함수 내부에서 계속 재귀호출 진행
    private List<T> inorderTree(Node node, List<T> visited){
        if(node == null){
            return visited;
        }
        inorderTree(node.left, visited);
        visited.add(node.data);
        inorderTree(node.right, visited);

        return visited;
    }

    public List<T> postOrder() {
        return this.postOrderTree(root, new ArrayList<>());
    }

    //재귀호출된 함수 내부에서 계속 재귀호출 진행
    private List<T> postOrderTree(Node node, List<T> visited){
        if(node == null){
            return visited;
        }
        postOrderTree(node.left, visited);
        postOrderTree(node.right, visited);
        visited.add(node.data);

        return visited;
    }

    public class Node{
        T data;
        Node left;
        Node right;

        Node(T data){
            this.data = data;
        }

        Node(T data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
