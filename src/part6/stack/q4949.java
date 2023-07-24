package part6.stack;

import java.util.Scanner;
import java.util.Stack;

public class q4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stk = new Stack<>();

        while(true){
            String str = sc.nextLine();
            if(str.equals(".")){
                break;
            }else{
                for(int i =0; i<str.length();i++){
                    char c = str.charAt(i);
                    if(c == '(' || c == '['){
                        stk.push(c);
                    }
                    else if(c == ')'){
                        if(stk.isEmpty() || stk.peek() != '('){
                            System.out.println("no");
                            break;

                        }else{
                            stk.pop();
                        }
                    }
                    else if(c == ']'){
                        if(stk.isEmpty() || stk.peek() != '['){
                            System.out.println("no");
                            break;

                        }else{
                            stk.pop();
                        }
                    }
                }
                if(stk.isEmpty()){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }

        }

    }
}
