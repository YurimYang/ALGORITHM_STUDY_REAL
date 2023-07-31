package part6.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;

public class q9934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();

        int k = Integer.parseInt(br.readLine());
        int depth = (int) (Math.pow(2, k) - 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < depth; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int root = list.get(list.size() / 2);
        System.out.println(root);
        list.remove(list.size() / 2);
        depth--;

        List<Integer> leftList = new ArrayList<>(list.subList(0, list.size() / 2));
        List<Integer> rightList = new ArrayList<>(list.subList(list.size() / 2, list.size()));


    }

    public void LevelCheck(List left, List right, int depth) {
        if (depth == 1) {
            System.out.println(left.toString() + right.toString());
        } else {

            LevelCheck(left, right, depth);
        }

    }
}
