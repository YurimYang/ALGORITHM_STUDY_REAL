package part6.graph;

import java.util.*;

//인접행렬(이차원배열)
public class AdjacencyMatrixGraph implements IGraph{
    private Integer[][] matrix; //연결정보
    private Set<Integer> vertexes; //vertex정보
    private Map<Integer, Integer> indegrees;
    //차수(노드에서 뻣어나가는 선 개수) 형으로 갖고 있기 위함
    //indegrees.get(3) = 5 -> 노드 3을 가리키는 노드의 개수 : 5 (노드 3의 차수)

    public AdjacencyMatrixGraph(int numOfVertex){
        this.vertexes = new HashSet<>();
        this.indegrees = new HashMap<>();
        this.matrix = new Integer[numOfVertex][];
        for(int i =0; i<numOfVertex; i++){
            this.matrix[i] = new Integer[numOfVertex];
        }
    }


    //디폴트로 이중배열에 추가해주는 함수
    @Override
    public void add(int from, int to) {
        //노드 정보 추가
        this.vertexes.add(from);
        this.vertexes.add(to);

        //차수가 0일경우 0 출력
        //해당 노드의 차수가 존재한다면 차수 가져와서 +1 시키기기
        int count = this.indegrees.getOrDefault(to, 0);
        indegrees.put(to,count+1);

        //distance를 따로 입력받지 않으므로 default인 1을 넣음
        matrix[from][to] = 1;

        //만약 양방향일 경우
        //matrix[to][from] = 1;

        //더이상 from~to가 연결되지 않을경우
        //matrix[from][to] = null;

    }

    @Override
    public void add(int from, int to, Integer distance) {
        //노드 정보 추가
        this.vertexes.add(from);
        this.vertexes.add(to);

        //차수가 0일경우 0 출력
        //해당 노드의 차수가 존재한다면 차수 가져와서 +1 시키기기
       int count = this.indegrees.getOrDefault(to, 0);
        indegrees.put(to,count+1);

        //노드의 from~ to의 길이와 함께 저장
        matrix[from][to] = distance;

        //만약 양방향일 경우
        //matrix[to][from] = distance;
    }

    @Override
    public Integer getDistance(int from, int to) {
        return this.matrix[from][to];
    }

    @Override
    public Map<Integer, Integer> getIndegress() {
        return this.indegrees;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< this.matrix[vertex].length; i++){
            if(this.matrix[vertex][i] !=null){
                result.add(i);
            }
        }
        return result;
    }
}
