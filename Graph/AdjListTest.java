package live.algorithm.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

// 무향그래프
public class AdjListTest { 
	
	static class Node{
		int vertex;  // 관계를 맺고 있는 타 정점 정보
		Node next;    // 연결리스트 유지를 위한 다음 노드 참조, 다음 노드로 가는 링크
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node adjList[] = new Node[V];  // 헤드리스트  // 연결리스트가 정점 수만큼 관리되고 있음.
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);  // 첫 원소 삽입
			adjList[to] = new Node(from, adjList[to]);
			
		}
		
//		bfs(adjList); 
		dfs(adjList, new boolean[V], 0);

	}
	
	private static void bfs(Node adjList[]) {
		int size = adjList.length; // 인접행렬의 크기가 정점의 개수
		Queue<Integer> queue = new ArrayDeque<>(); // 큐에 넣는 값은 방문대상을 관리할 값과 그 밖의 값들을 넣을 수 있다
		boolean[] visited = new boolean[size];
		
		// 탐색의 시작점 정점을 0으로 하자.
		queue.offer(0);
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.println(current);
			System.out.println((char)(current+65));
			
			
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex]) {
					// 인접 여부를 체크할 필요 없고, 방문 체크만 하면 된다!
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}

	}
	
	private static void dfs(Node adjList[], boolean[] visited, int current) {
		
		visited[current] = true;
		System.out.println((char)(current+65));

			
		for (Node temp = adjList[current]; temp != null; temp = temp.next) {
			if (!visited[temp.vertex]) {
				dfs(adjList, visited, temp.vertex);
	
			}
		}

	}

}
