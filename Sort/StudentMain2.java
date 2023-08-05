package com.practice.makes.perfect;

import java.util.Arrays;
import java.util.Comparator;

public class StudentMain2 {

	public static void main(String[] args) {
		
		Student2[] array = new Student2[5];
		array[0] = new Student2("홍길동", 20170301, 4.5);
		array[1] = new Student2("강감찬", 20200301, 3.5);
		array[2] = new Student2("이순신", 20180301, 2.5);
		array[3] = new Student2("김유신", 20210301, 4.5);
		array[4] = new Student2("유관순", 20200302, 3.5);
		
		// --- (Anonymous inner class)
		// (1) 학점이 높은순서(내림차순)대로 정렬 조회
		
		Arrays.sort(array, new Comparator<Student2>() { // 이름이 없는 inner class
			@Override
			public int compare(Student2 o1, Student2 o2) {
				// 인자1이 앞에 오면 올림, 인자1이 뒤에가면 내림.
				return Double.compare(o2.score, o1.score);
				//return (int)(o2.score - o1.score);		
			} 
		});
		print("(1) 학점이 높은순서(내림차순)", array);

		
		// (2) 학점이 높은순서(내림차순)대로 정렬 조회. 만약, 학점이 같으면 학번으로 오름차순 정렬
		Arrays.sort(array, new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				if (o1.score == o2.score) {  // 학점이 같으면
					return Integer.compare(o1.num, o2.num); // 학번으로 오름차순 정렬
				}
				return Double.compare(o2.score, o1.score);
			}
		});
		print("(2)학점이 내림차순, 동점이면 학번 오름차순", array);
		
		
		// (3) 이름으로 오름차순
		Arrays.sort(array, new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		print("(3)이름 오름차순", array);
		
		
		// --- (람다식)
		// (4) 이름으로 오름차순
		Arrays.sort(array, (o1, o2) -> o1.name.compareTo(o2.name));
		print("(4)람다식: 이름으로 오름차순", array);
		
		
		// (5) 점수가 낮은순서(올림차순)
		Arrays.sort(array, (o1, o2) -> (int)(o1.score - o2.score));          // 1
		Arrays.sort(array, (o1, o2) -> Double.compare(o1.score, o2.score));  // 2
		Arrays.sort(array, (o1, o2) -> {
			return Double.compare(o1.score, o2.score);                       // 3
			});
		print("(5)람다식: 점수 낮은순서(올림차순)", array);
		
		
		// (6) 람다식: 점수가 높은순서대로(내림차순), 단, 점수가 같으면 이름 올림차순
		Arrays.sort(array, (o1, o2) -> (int)(o2.score - o1.score));          // 1
		Arrays.sort(array, (o1, o2) -> Double.compare(o2.score, o1.score));  // 2
		Arrays.sort(array, (o1, o2) -> {
			if (o1.score == o2.score) {
				return o1.name.compareTo(o2.name);                           // 3
			} 
			return Double.compare(o2.score, o1.score);
			});
		print("(6)람다식: 점수 높은순서(내림차순), 동점이면 이름 올림)", array);
		
	}
	
	// print method
	public static void print(String title, Student2[] array) {
		System.out.println("\n--- " + title + " 정렬 후 조회");
		for (Student2 s: array) {
			System.out.println(s);
		}
	}

}

/* 수행결과

--- (1) 학점이 높은순서(내림차순) 정렬 후 조회
홍길동	| 20170301	| 4.5
김유신	| 20210301	| 4.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5

--- (2)학점이 내림차순, 동점이면 학번 오름차순 정렬 후 조회
홍길동	| 20170301	| 4.5
김유신	| 20210301	| 4.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5

--- (3)이름 오름차순 정렬 후 조회
강감찬	| 20200301	| 3.5
김유신	| 20210301	| 4.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5
홍길동	| 20170301	| 4.5

--- (4)람다식: 이름으로 오름차순 정렬 후 조회
강감찬	| 20200301	| 3.5
김유신	| 20210301	| 4.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5
홍길동	| 20170301	| 4.5

--- (5)람다식: 점수 낮은순서(올림차순) 정렬 후 조회
이순신	| 20180301	| 2.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
김유신	| 20210301	| 4.5
홍길동	| 20170301	| 4.5

--- (6)람다식: 점수 높은순서, 동점이면 이름 올림) 정렬 후 조회
김유신	| 20210301	| 4.5
홍길동	| 20170301	| 4.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5
*/


