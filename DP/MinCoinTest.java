import java.util.Scanner;

public class MinCoinTest {  // 거스름돈으로 줄 최소 동전의 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();  // 교환 금액 
		
		int[] D = new int[money+1];  // 금액 n에 대한 최소 동전 수
		
		D[0] = 0;  // 점화식으로 채워질 수 없는 동적테이블의 값 초기화!
		
		for (int i = 1; i <= money; i++) {
			// 1원 시도
			D[i] = D[i-1]+1;  // 1원을 사용한 경우의 최적해. (가장 큰) 임시 최적해. 4원, 6원 쓸 경우와 비교 후 최소값 갱신할 준비 작업. 
			
			// 4원 시도
			if (i>=4 && D[i-4]+1 < D[i]) 
				// 우리가 시도할 값이 4이상이고, 4원을 사용했을 때의 최적이 더 작다면 
				D[i] = D[i-4]+1; // 갱신
			
			// 6원 시도
			if (i>=6 && D[i-6]+1 < D[i]) 
				// 우리가 시도할 값이 6이상이고, 6원을 사용했을 때의 최적이 더 작다면 (1원 시도, 4원 시도했을 때 모두와 비교한 것) 
				D[i] = D[i-6]+1; // 갱신
		}

		System.out.println(D[money]);
	}

}
