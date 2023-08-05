package com.practice.makes.perfect;

import java.util.Arrays;

/**
 * 고정 정렬 
 * @author leejuhyun
 * 
 * Student 객체 속성기반 고정 정렬 클래스 구현
 * 고정 정렬: implements Comparable<Student> 
 * 특정 속성에 고정. 주로 Domain (DTO)
 * 
 * ----- 정렬 규칙 -----
 * 1. 올림차순: 매개인자1이 앞에 오면, this가 앞에 오면
 * 2. 내림차순: 매개인자1이 뒤에 가면, this가 뒤에 가면
 * 
 */

public class Student implements Comparable<Student>{

	String name;
	int num;
	double score;
	
	public Student() {} // 기본 생성자 
	
	public Student(String name, int num, double score) { // 생성자 중복 정의 
		this.name = name;
		this.num = num;
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("\t| ");
		builder.append(num);
		builder.append("\t| ");
		builder.append(score);
		return builder.toString();
	}
	
	@Override
	public int compareTo(Student o) {
		// String은 compareTo() 
		// 이름 비교
//		return this.name.compareTo(o.name);    // this가 앞에오면 오름차순 정렬 
//		return o.name.compareTo(this.name);    // 이름 내림
		
		// 점수 비교 
//		return Double.compare(this.score, o.score);  // 점수 올림 
		return Double.compare(o.score, this.score);  // 점수 내림 
	}

}










