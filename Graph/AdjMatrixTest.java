package live.algorithm.basic;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 무향그래프
public class AdjMatrixTest { 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V]; // 초기값 0, 간선이 있는 자리만 1로 표시하면 됨
		// 간선이 있으면 1, 없으면 0.
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
			
		}
		
//		bfs(adjMatrix);
		dfs(adjMatrix, new boolean[V], 0);
		 

	}
	
	private static void bfs(int[][] adjMatrix) {
		int size = adjMatrix.length; // 인접행렬의 크기가 정점의 개수
		Queue<Integer> queue = new ArrayDeque<>(); // 큐에 넣는 값은 방문대상을 관리할 값과 그 밖의 값들을 넣을 수 있다
		boolean[] visited = new boolean[size]; 
		
		// 탐색의 시작점 정점을 0으로 하자.
		queue.offer(0);
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.println(current);
			System.out.println((char)(current+65));
			
			// 현 정점의 인접정점들 체크하며 대기열에 넣기
			for (int i = 0; i < size; i++) {
				if (adjMatrix[current][i] != 0 && !visited[i]) {
					// 인접한 정점이고, 아직 visited 되지 않았다면
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

	}
	
	private static void dfs(int[][] adjMatrix, boolean[] visited, int current) {  // 바뀌는 정점을 매개변수로 설계
		// 매개변수로 넣지 않고 싶으면 static 변수로 만들면 됨.
		
		visited[current] = true;
		System.out.println((char)(current+65));

			
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[current][i] != 0 && !visited[i]) {
				dfs(adjMatrix, visited, i);
	
			}
		}
	

	}

}

