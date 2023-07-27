package part6.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();

        //1. hashMap에 대입하기
        String name;
        int cnt = 0;
        while((name = br.readLine()) != null && !name.isEmpty()){
            hm.put(name,hm.getOrDefault(name, 0) + 1);
            cnt++;
        }
        //2. 알파벳으로 정렬하기
        List<String> treeList = new ArrayList<>(hm.keySet());
        Collections.sort(treeList);

        //3. 백분율로 나타내기
        for (String tree : treeList){
            int count = hm.get(tree) * 100;
            System.out.println(tree + " " + String.format("%.4f", (double)count / (double)cnt) );
        }


    }
}
