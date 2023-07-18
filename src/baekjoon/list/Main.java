package baekjoon.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1~n까지의 수 입력받기
        int k = sc.nextInt(); // k번째 수 삭제하기
        LinkedList<Integer> LinkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            LinkedList.add(i+1); //리스트에 1~n까지 추가하기
        }
        int idx = 0;
        System.out.print("<");
        while (!LinkedList.isEmpty()) {
            idx = (idx + (k - 1)) % LinkedList.size();
            if(LinkedList.size() != 1) {
                System.out.print(LinkedList.remove(idx) + ", ");
            }else{
                System.out.print(LinkedList.remove(idx));
            }
        }
        System.out.print(">");
    }
}


