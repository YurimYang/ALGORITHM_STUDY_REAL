package part6.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q_spicy {
    public static void main(String[] args) throws IOException {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        solution(scoville,K);
    }
    public static int solution(int[] scoville, int K) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0; //섞는 횟수
        K = Integer.parseInt(br.readLine()); //넘겨야하는 최소한의 스코빌지수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순으로 수를 꺼냄

        for(int s :scoville){
            pq.add(s);
        }
        int first = 0;
        int second = 0;

        while(pq.peek()<K && pq.size() > 1){
            answer++;
            first = pq.poll();
            second = pq.poll();
            int mixed = first + second * 2;
            pq.add(mixed);
        }
        //모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우 -1 return
        if(pq.peek() > K){
            return -1;
        }

        return answer;
    }
}


