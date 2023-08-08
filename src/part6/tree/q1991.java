package part6.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q1991 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Node root = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());


        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // A B C를 st에 다 넣음
            char parent = st.nextToken().charAt(0); //A란 토큰 중 첫번째 : A
            char left = st.nextToken().charAt(0); //동일
            char right = st.nextToken().charAt(0); //동일

            BuildingTree(root,parent,left,right);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void BuildingTree(Node root, char parent, char left, char right){
        if(root.value == parent){
            root.left = (left == '.' ? null : new Node(left, null, null));
            root.right = (right == '.'? null : new Node(right, null,null));
        } else {
            if(root.left!= null) BuildingTree(root.left, parent, left, right);
            if(root.right!= null) BuildingTree(root.right, parent, left, right);
        }
    }

    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);

    }
}
