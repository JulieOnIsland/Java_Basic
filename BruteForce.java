package com.obsession;

public class BruteForce {

	// Brute Force
	// 해당 패턴이 본문 안에 들어있는지 체크 / 들어있다면 몇번째 인덱스부터 시작하는지 
	public static void main(String[] args) {
		String t = "This iss a book";
		String p = "iss";
		System.out.println(bruteForceFor(t, p));
		System.out.println(bruteForceWhile(t, p));
		System.out.println(t.contains(p));

	}
	
	public static int bruteForceFor(String t, String p) {
		int N = t.length(); // 본문의 길이 
		int M = p.length(); // 패턴의 길이 
		
		for (int i = 0; i <= N-M; i++) { // 패턴 검사의 시작점 위치 
			boolean flag = true;
			for (int j = 0; j < M; j++) { // 패턴 매칭 수행하는 for문 
				if (p.charAt(j) != t.charAt(i+j)) {
					flag = false;
					break;
				}
			}
			
			if (flag) return i;
			
		}
		
		return -1; // 못 찾았을 경우 (없을 경우) 
	}
	
	private static int bruteForceWhile(String t, String p) {
		int N = t.length(); 
		int M = p.length();
		
		int i = 0; // 본문의 인덱스 
		int j = 0; // 패턴의 인덱스 
		
		while (j < M && i<N) {
			if (t.charAt(i) != p.charAt(j)) {
				i -= j;
				j = -1;
			}
			i++; // i와 j를 한칸씩 증가시키기 
			j++;
		}
		if (j == M) return i-M;
		return -1;

	}

}
