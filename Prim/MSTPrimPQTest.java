package live.algorithm.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MSTPrimPQTest {

	static class Vertex implements Comparable<Vertex>{
		int no, weight;  // 정점 번호, 트리정점과 연결했을 때의 간선 비용 

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, adjMatrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		adjMatrix = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문정점(트리정점표시)
		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V];   // 자신과 트리의 정점들 간 최소 간선 비용
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);  // 최솟값 갱신 위해 큰 값으로 세팅
		
		minEdge[0] = 0;  // 임의로 시작 정점 세팅. 0 정점을 트리 구성의 시작으로 세팅.
		
		// 큐에 넣기
		pq.offer(new Vertex(0, minEdge[0]));
		
		int result = 0;  // 최소 신장 트리 비용
		int min = 0, minVertex = 0;
		int cnt = 0; // 방문한 정점의 개수
		
		while (!pq.isEmpty()) {  
			
			// step1: 미방문(비트리) 정점 중 최소간선비용의 정점을 선택: 힙을 써서 관리하자
			Vertex current = pq.poll();
			minVertex = current.no;
			min = current.weight;
			
			if (visited[minVertex]) continue;  // 힙에 남아있던 흔적들. 무시해야 함.
			
			// step2: 방문(트리) 정점에 추가 
			visited[minVertex] = true;  // 방문처리
			result += min;  // 신장트리 비용 누적
			if (++cnt == V) break;  // 방문한 정점의 개수가 V개가 되면 STOP
			
			// step3: 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선 비용 고려 (aka 영업타임)
			for (int i = 0; i < V; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					// 비트리 정점이면서, 인접해있어야 하고, 이전까지 저장되어 있는 최소 간선 비용보다 나랑 연결하는 게 더 유리한 경우에
					minEdge[i] = adjMatrix[minVertex][i];  // 업데이트
					pq.offer(new Vertex(i, minEdge[i]));   // 큐에 넣어주기 
				}
			}
			
		}
		
		System.out.println("output==>"+result);
		
	}

}
