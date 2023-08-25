package live.algorithm.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];  // 인접 리스트
		int[] distance = new int[V];  // 시작점에서 자신으로 오는 최단거리
		boolean[] visited = new boolean[V];  // 방문 처리 리스트

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);  // 무향 그래프
		}
		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		
		distance[start] = 0;  // 자기가 자기로 오는 비용은 0
		int min = 0; 
		int stopOver = 0;  // 경유지 변수
		
		for (int i = 0; i < V; i++) { // 모든 정점을 다 처리할 때까지 반복
			
			// step 1: 미방문 정점 중에 출발지에서 가장 가까운 정점을 선택
			stopOver = -1;
			min = INF;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					stopOver = j;
				}
			}
			if (stopOver == -1) break;  
			
			// step 2: 방문 처리
			visited[stopOver] = true;
			// 상황에 따라 처리: 경유지가 곧 도착지면 끝내기 (optional)
			// 출발지에서 모든 정점으로의 최단거리를 구하는 게 아니라 도착지까지의 최단거리를 구하는 경우
//			if (stopOver == end) break;
			
			// step 3: 경유지를 이용하여 미방문 정점들의 출발지에서 자신으로의 최소비용 고려
			for (Node temp = adjList[stopOver]; temp != null; temp=temp.next) {
				// 해당 정점이 방문 정점이 아니고 현재 정점에서 갈 수 있는 정점의 경우
				// 최소거리 정점을 거쳐서 해당 정점을 갈 경우의 total 가중치와 기존까지 계산된 해당 정점까지의 total 가중치 비교하여 갱신
				if (!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight) {
					distance[temp.vertex] = min+temp.weight;
				}
			}		
			
		}
		System.out.println(distance[end] != INF ? distance[end] : -1);
		
	}

}
