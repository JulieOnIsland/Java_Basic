package live.algorithm.basic;

import java.util.Scanner;

// 같은 행에는 퀸을 놓지 않는 버전.
// 놓인 퀸의 열 번호를 기록하는 버전
public class NQueensTest {

	static int N, col[], ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1];  // 1행부터 사용
		ans = 0;  // 가능한 경우의 수
		
		setQueen(1);
		System.out.println(ans);

	}
	
	// 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) {   // 퀸을 놓는 행이 바뀌므로 행을 매개변수로. row: 퀸을 놓으려는 행
		
		// 가지치기: 직전까지 놓아진 상태로 (row - 1)
		if (!isPromising(row - 1)) return;
		
		// 기저 조건
		if (row > N) {  // 유망했을 때 밑으로 내려오는데, 모든 퀸을 다 놓았다면 성공! 
			ans++;      // ans 1 증가
			return;
		}
		
		// 유도파트
		for (int c = 1; c <= N; c++) {    // 1열부터 N열까지 시도
			col[row] = c;
			setQueen(row + 1);
		}
		

	}
	
	private static boolean isPromising(int row) {  // row: 마지막으로 놓아진 퀸의 행
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row] || row-i == Math.abs(col[row]-col[i])) {
				// 대각선은 행의 차이와 열의 차이의 절댓값이 같다.
				return false;
			}
		} 
		return true;
		

	}

}
