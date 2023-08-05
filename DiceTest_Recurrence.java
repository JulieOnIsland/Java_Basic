package com.practice.makes.perfect;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열, 중복순열, 조합, 중복조합을 재귀로 표현해보자 
 * @author leejuhyun
 * 
 * 재귀함수 작성 시 고려해야 할 요소 3가지 
 * 1. 함수를 명확히 정의할 것!
 * 2. 함수 실행 시 실행을 결정하는 변화 요인을 매개변수로 설계할 것!
 * 3. 기저 조건, 즉 끝을 찾을 것! 
 */

public class DiceTest_Recurrence {
	
	static int N;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();    // 주사위 던지는 횟수 (0 < N < 7)
		int M = sc.nextInt();    // 주사위 던지기 모드 (1 ~ 4) 
		numbers = new int[N];    // 던져진 주사위 수들을 저장하는 배열 
	
		switch (M) {
		case 1:  // 중복순열 
			dice1(0);
			break;
			
		case 2:  // 순열 
			isSelected = new boolean[7];
			dice2(0);
			break; 
			
		case 3:  // 중복조합 
			dice3(0, 1);
			break;
			
		case 4:  // 조합 
			dice4(0, 1);
			break;
		}
	}
	
	private static void dice1(int cnt) { // cnt: 기존까지 던져진 주사위 횟수 (=몇 개 뽑았는지 나타내는 수) 
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int diceNum = 1; diceNum <= 6; diceNum++) {
			numbers[cnt] = diceNum;
			dice1(cnt+1);
		}
		
	}

	private static void dice2(int cnt) { // cnt: 기존까지 던져진 주사위 횟수 
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int diceNum = 1; diceNum <= 6; diceNum++) {
			if (isSelected[diceNum]) {  // 기존 주사위 눈과 중복되는지 체크 
				continue;
			}
			numbers[cnt] = diceNum;
			isSelected[diceNum] = true;
			// 현 주사위의 눈이 i로 결정된 상태로 다음 주사위 던지러 가기 
			dice2(cnt+1);
			// 현 주사위 눈을 i로 고정한 채로 뒤에 나올 수 있는 모든 상황을 고려하고 온 것. 
			// 그러므로 이제 현 주사위의 눈을 다른 선택지로 시도하기 위해서 
			isSelected[diceNum] = false; // false로 돌려놔야 함 
			
		}
		
	}
	
	private static void dice3(int cnt, int start) { 
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int diceNum = start; diceNum <= 6; diceNum++) {
			numbers[cnt] = diceNum;
			dice3(cnt+1, diceNum);
		}
	}
	
	private static void dice4(int cnt, int start) { 
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int diceNum = start; diceNum <= 6; diceNum++) {
			numbers[cnt] = diceNum;
			dice4(cnt+1, diceNum+1);
		}
		
	}
}












