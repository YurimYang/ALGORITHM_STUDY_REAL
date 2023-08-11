package part6.graph;

import java.util.*;
import java.util.stream.IntStream;

public class q_make0 {
    static List<List<Integer>> graph;
    static int[] forCheckEdges;
    static Queue<Integer> queue;
    static int[] a;
    static int[][] edges;
    public static void main(String[] args) {
        a = new int[]{-5, 0, 2, 1, 2};
        edges = new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}};
        solution(a,edges);

    }

    public static long solution(int[] a, int[][] edges) {
        if(Arrays.stream(a).sum() != 0){
            return -1;
        }
        long answer = 0;
        OptionalInt root = Arrays.stream(a).min(); //가장 작은 값을 root로 한다.

        //그래프 생성하기
        graph = new ArrayList<>();
        for(int i = 0; i<a.length; i++){
            graph.add(new ArrayList<>());
        }
        forCheckEdges = new int[a.length];
        //무선형이므로 둘 다 연결해주기
        for(int j = 0; j<edges.length; j++){
            graph.get(edges[j][0]).add(edges[j][1]);
            graph.get(edges[j][1]).add(edges[j][0]);
            forCheckEdges[edges[j][0]]++;
            forCheckEdges[edges[j][1]]++;
        }

        //간선연결이 1개인 노드들이 leaf노드들부터 위상정렬 시작
        queue = new LinkedList<Integer>();
        for(int i =0; i< a.length; i++){
            if(forCheckEdges[i] == 1){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int num = queue.poll(); //1번째 - 2번째
            System.out.println("num " + num);
            for (int v : graph.get(num)){ //1번이 가리키는 0번- 3번
                System.out.println("V " + v);
                if(a[v] > 0){ //0번은 -5이므로 탈락 - 3번은 통과
                    System.out.println("a[num] : "+ a[num]);
                    answer += Math.abs(a[num]);
                    a[v]+=a[num];
                    a[num]=0;
                    System.out.println("answer "+ answer);
                }
                forCheckEdges[v]--;
                if(forCheckEdges[v] == 1){
                    queue.add(v);
                }
            }

        }
        return answer;
    }

}
