package part6.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q9012 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for(int i =0; i< cnt;i++){
            calStack(sc.next());
        }
    }
    public static void calStack(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c=='('){
                stack.push(c);
            }else{
                if(stack.empty()){
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        if(stack.empty()){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

}

//import java.util.*;
//
//public class q9012 {
//    public static void calStack(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (c == '(') {
//                stack.push(c);
//            } else {
//                if (stack.empty()) {
//                    System.out.println("NO");
//                    return;
//                }
//                stack.pop();
//            }
//        }
//
//        if (stack.empty()) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int cnt = sc.nextInt();
//
//        for (int i = 0; i < cnt; i++) {
//            calStack(sc.next());
//        }
//    }
//}


