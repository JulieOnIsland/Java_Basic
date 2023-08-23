package live.algorithm.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static Edge[] edgeList;
	static int V, E;  // vertex, edge
	static int[] parents;
	
	// Union Find ----------------------------------------------------------
	private static void makeSet() {
		parents = new int[V];
		for (int i=0; i<V; i++) {
			parents[i] = i;  // 각 정점이 그 정점의 부모가 되는 최소 단위 서로소 집합 
		}
	}
	
	private static int findParent(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findParent(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		if (aRoot == bRoot) return false;  // 사이클 발생 체크
		parents[bRoot] = aRoot;
		return true;
	}
	// ----------------------------------------------------------------------
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// Make an edgeList
		edgeList = new Edge[E];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight); 
		}
		
		// 간선리스트를 가중치 기준으로 오름차순 정렬
		Arrays.sort(edgeList);
		
		// V개의 정점으로 make set 작업
		makeSet();
		
		int result = 0;  // MST 비용
		int count = 0;   // 연결된 간선 개수
		for (Edge edge: edgeList) {
			if (union(edge.from, edge.to)) {
				// 사이클이 발생하지 않았으므로 간선 가중치 누적
				result += edge.weight;
				if (++count == V-1) break;
			}
		}
		System.out.println(result);
		
	}

}
