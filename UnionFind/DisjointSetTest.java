package live.algorithm.basic;

import java.util.Arrays;

public class DisjointSetTest {

	static int N;  // 초기 집합의 개수
	static int parents[];
	
	private static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;   // 모든 요소를 자기만 원소로 갖는 단위 서로소 집합이 되게 한다 (자신이 곧 대표자인 루트로 표현)
		}

	}
	
	private static int findSet(int a) {
		if (a == parents[a]) return a;  // 자신이 곧 루트인 대표자 
//		return findSet(parents[a]);     // 자신이 대표자가 아닌 상황에서는 부모를 찾으러 간다
		return parents[a] = findSet(parents[a]);  // path compression 최적화 
	}
	
	private static boolean union(int a, int b) {  // a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고, TRUE 반환, 아니면 FALSE
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;  // 서로의 대표자가 같은, 즉 같은 집합에 속한 상황이므로 union하지 않음
		// union 처리 (bRoot를 aRoot 아래로 붙이기!)
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) {
		N = 5;
		makeSet();
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(parents)); 
		System.out.println(union(4, 3));
		System.out.println(Arrays.toString(parents)); 
 
		System.out.println("=============find=============");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents)); 
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents)); 
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents)); 
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents)); 
		System.out.println(findSet(0)); // 모두 같은 집합으로 묶인 상황 
		// path compression 할 때와 하지 않을 때 parents 배열의 값이 달라짐.
		
		// rank가 높은 트리에 낮은 트리를 붙임
		// rank 관리를 union에서만 하고, find에서는 rank 관리 X -> 완벽하게 rank 관리하기 쉽지 않음
		// union에서 rank 관리하면, "보완"할 수 있다

	}

}
