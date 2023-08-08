package part6.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

//제네릭 타입 구현 x
//구현의 단순성을 위해서 Int타입만 진행
public interface IGraph {
    void add(int from, int to); //from : 출발노드 to : 도착노드
    void add(int from, int to, Integer distance); //distance : 가중치
    Integer getDistance(int from, int to); // from~to 까지의 가중치
    Map<Integer, Integer> getIndegress(); // 그래프 상의 indegree 개수 <Node, Indegree(차수의 수>
    Set<Integer> getVertexes(); //그래프 상의 노드 집합 찾기
    List<Integer> getNodes(int vertex); //outDegree가 가리키고 있는 노드들의 집합

}
