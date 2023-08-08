package part6.graph;


import part6.queue.IQueue;
import part6.queue.MyLinkedQueue;
import part6.stack.IStack;
import part6.stack.MyStack;

import java.util.*;

public class GraphAlgrotihms {
    //bfs
    public static List<Integer> bfs(IGraph iGraph, int from) {
        List<Integer> result = new ArrayList<>(); //최종 아웃풋
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>(); //BFS는 큐로

        queue.add(from); //시작위치
        visited.add(from); //시작위치가 VISITED 됐으므로 미리 추가

        while(!queue.isEmpty()){ //큐가 빌 때까지 진행
            Integer next = queue.poll(); //큐를 POLL하면서 진행
            result.add(next); //poll된걸 result에 추가
            for(Integer n : iGraph.getNodes(next)){
                //poll된 노드가 가리키는 노드들을 리스트로 가져와서 하나씩 출력
                if(!visited.contains(n)){
                    queue.add(n);
                    visited.add(n);
                }
            }
        }
        return result;
    }

    //위상정렬(큐)
    public static List<Integer> topologicalSortIndegree(IGraph graph){
        //1. 각 노드별 진입 차수 구하기
        Map<Integer, Integer> indegreeCounter = graph.getIndegress();

        List<Integer> result = new LinkedList<>();
        IQueue<Integer> queue = new MyLinkedQueue<>();

        //2. 노드들의 진입 차수 중 0 인 경우만 먼저 queue에 넣기
        for(int v : graph.getVertexes()) {
            int count = indegreeCounter.getOrDefault(v, 0);
            if (count == 0){
                queue.offer(v);
            }
        }

        //3. 차수가 0인 노드가 큐에 들어간 경우
        while(!queue.isEmpty()){
            //4. node를 한개씩 poll해서 result list에 추가
            int node = queue.poll();
            result.add(node);

            //5. poll한 노드와 연결된 노드를 가져와서 nn에 넣어주면
            for(int nn: graph.getNodes(node)){
                if(indegreeCounter.containsKey(nn)){
                    //해당 노드의 진입차수를 가져와서 -1씩 해줌
                    int count = indegreeCounter.get(nn);
                    //만약, -1을 했을 때 0이 된다면 queue에 넣어주기
                    if(count-1 == 0){
                        queue.offer(nn);
                    }

                    //-1을해서 0이 되지 않았더라도 다음에 진입차수를 구할 때 update되어야하므로
                    // put으로 indegreeCounter에 넣어준다.
                    indegreeCounter.put(nn, count-1);
                }
            }
        }
        return result;
    }

    //위상정렬(스택)
    public static List<Integer> topologicalSort(IGraph graph) {
        List<Integer> result = new ArrayList<>();
        IStack<Integer> stack = new MyStack<>(); //DFS탐색 결과를 넣기 위한 STACK
        Set<Integer> visited = new HashSet<>();


        Set<Integer> vertexes = graph.getVertexes();
        for(Integer vertex : vertexes) {
            //순서대로 모든 vertex를 돌음
            if(!visited.contains(vertex)){
                //dfs
                topologicalSort(graph, vertex, visited, stack);
            }
        }

        while(stack.size() > 0) {
            result.add(stack.pop());
        }

        return result;
    }


    private static void topologicalSort(IGraph graph, int vertex, Set<Integer> visited, IStack<Integer> stack){
        //vertex 한개씩 visited에 담기게 됨 (중복을 방지하기 위함)
        visited.add(vertex);
        //vertex와 연결된 노드들 가져오기
        List<Integer> nodes = graph.getNodes(vertex);
        //재귀호출로 dfs 탐색 진행
        for(Integer n : nodes) {
            if(!visited.contains(n)) {
                topologicalSort(graph, n, visited, stack);
            }
        }

        //dfs가 종료되는 시점에 vertex를 넣어야한다.
        //처음 노드인 A가 담기지 않기 위함
        //dfs가 역순으로 담기기 위함 ! 하나씩 마지막부터 stack에 들어가는 구조
        stack.push(vertex);
    }
}
