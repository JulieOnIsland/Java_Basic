package com.practice.makes.perfect;

import java.util.Arrays;

public class StudentMain {

	public static void main(String[] args) {
		Student[] s=new Student[5];
		s[0]=new Student("홍길동", 20170301, 4.5);
		s[1]=new Student("강감찬", 20200301, 3.5);
		s[2]=new Student("이순신", 20180301, 2.5);
		s[3]=new Student("김유신", 20230301, 4.5);
		s[4]=new Student("유관순", 20200302, 3.5);
		 
		// Student에서 재정의한 compareTo() 기반 정렬
		
		Arrays.sort(s);      // Arrays.sort(s)나 Collections.sort(s)는 원본을 바꿔버린다! 
				
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);   
		}

	}

}
//implements Comparable#compareTo() 는 고정 정렬이므로 매번 소스코드를 변경해야함(불편!) -> 동적 정렬 활용 