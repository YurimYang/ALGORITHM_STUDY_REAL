package part6.graph;

import java.util.*;

public class AdjacencyListGraph implements IGraph{

    private List<List<Node>> graph; //이중연결리스트
    private Set<Integer> vertexes;
    private Map<Integer, Integer> indegress;

    public AdjacencyListGraph(int numOfVertex){
        this.vertexes = new HashSet<>();
        this.indegress = new HashMap<>();
        this.graph = new ArrayList<>(numOfVertex);
        for(int i = 0; i< numOfVertex; i++){
            this.graph.add(new ArrayList<>());
        }
    }
    @Override
    public void add(int from, int to) {
        vertexes.add(from);
        vertexes.add(to);

        int count = indegress.getOrDefault(to, 0);
        indegress.put(to, count+1);

        //0 -> [1,2,3] : 0번 노드는 1, 2, 3번 노드를 가리키고 있다.
        //1 -> [2] : 1번 노드는 2번 노드를 가리키고 있다.
        //2 -> [0,1] : 2번 노드는 0, 1번 노드를 가리키고 있다.
        //3 -> [] : 3번 노드는 아무것도 가리키고 있지 않다.

        List<Node> neighbors = this.graph.get(from); //해당 from노드가 가리키고 있는 노드들을 가져옴
        neighbors.add(new Node(from, to)); //재귀적으로 진행되는 구조

    }

    @Override
    public void add(int from, int to, Integer distance) {
        vertexes.add(from);
        vertexes.add(to);

        int count = indegress.getOrDefault(to, 0);
        indegress.put(to, count+1);

        //0 -> [1,2,3] : 0번 노드는 1, 2, 3번 노드를 가리키고 있다.
        //1 -> [2] : 1번 노드는 2번 노드를 가리키고 있다.
        //2 -> [0,1] : 2번 노드는 0, 1번 노드를 가리키고 있다.
        //3 -> [] : 3번 노드는 아무것도 가리키고 있지 않다.

        List<Node> neighbors = this.graph.get(from); //해당 from노드가 가리키고 있는 노드들을 가져옴
        neighbors.add(new Node(from, to, distance)); //재귀적으로 진행되는 구조
    }

    @Override
    public Integer getDistance(int from, int to) {
        //from이 가리키고 있는 노드 중 to 노드의 weight를 반환
        for(Node node: this.graph.get(from)) {
            if(node.to.equals(to)){
                return node.weight;
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Integer> getIndegress() {
        return this.indegress;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    //매개변수로 입력받은 vertex가 가리키고 있는 노드들을 리스트로 반환
    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> nodes = new ArrayList<>();
        for(Node node : this.graph.get(vertex)) {
            nodes.add(node.to);
        }
        return nodes;
    }

    private class Node{
        Integer from;
        Integer to;
        int weight; //각 노드의 가중치

        Node(int from, int to){
            this.from = from;
            this.to = to;
            this.weight = 1;
        }

        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
