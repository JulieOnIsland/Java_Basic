package com.practice.makes.perfect;

import java.util.Scanner;

/**
 * 정수의 배열이 있을 때 0으로 만드는 경우 구하기 &
 * 자연수의 배열이 있을 때 TARGET을 합으로 갖는 경우 구하기 (No pruning)
 */

public class SubsetSumTest {
	
	static int N, SUM, TARGET;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
//		SUM = sc.nextInt();
		TARGET = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
//		generateSubset(0);
		generateSubset2(0, 0, 0);
		
		
	}
	
	// 구성 요소를 print 하는 메서드 
	public static void generateSubset(int cnt) { // cnt: 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스 
		
		if (cnt == N) {  // 부분집합 완성 
			
			// 부분집합의 구성원소의 합을 구하고, SUM과 비교해야 함 
			int temp = 0, tCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					temp += input[i];
					tCnt++;
				}
			}
			
			if (tCnt > 0 && temp == SUM) { // tCnt를 주지 않으면, 공집합도 출력된다 
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			}
			return;
		
		}
		
		isSelected[cnt] = true;  // 이 원소를 부분집합에 넣을 꺼에요 
		generateSubset(cnt + 1);
		isSelected[cnt] = false; // 이 원소를 부분집합에 넣지 않을 꺼에요 
		generateSubset(cnt + 1);
		
	}
	
	// 목표합이 되는 경우가 몇 번이나 있었나요? (더하는 걸 나중에 더하지 말고, 선택할 때 더해주자)  
	public static void generateSubset2(int cnt, int sum, int selectedCount) {  // sum: 직전까지 선택된 원소들의 합 
		
		if (cnt == N) {  // 부분집합 완성 
			
			if (selectedCount > 0 && sum == TARGET) { // tCnt를 주지 않으면, 공집합도 출력된다 
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				} // 경우의 수를 세는 거라면, 전역변수 위치에 답이 되는 경우의 카운팅 변수를 올려놓고,
				// 답이 될 때 ++를 해주면 된다.
				System.out.println();
			}
			return;
		
		}
		
		isSelected[cnt] = true;  // 경우의 수를 구하는 거면, 사실상 isSelected 배열은 필요 없음  
		generateSubset2(cnt + 1, sum + input[cnt], selectedCount + 1);
		isSelected[cnt] = false; 
		generateSubset2(cnt + 1, sum, selectedCount);
		
	}

}

// pruning 할 때 현재의 상태가 매개변수로 오면, 그 매개변수를 가지고 계속 진행해나갈 것인지
// 혹은 여기서 멈출 것인지를 판단하는 것이 가능하므로, 선택된 상황의 내용을 매개변수로 전달해주자! 
