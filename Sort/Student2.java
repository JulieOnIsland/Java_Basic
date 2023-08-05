package com.practice.makes.perfect;

/**
 * 동적 정렬 
 * @author leejuhyun
 * 
 * 동적 정렬: 정렬이 필요할 때마다 (일회성으로) 익명의 클래스를 정의하거나 람다식 사용
 * Comparator<E>
 * @Override Compare()
 * 
 */

public class Student2 {

	String name;
	int num;
	double score;
	
	public Student2() {}
	
	public Student2(String name, int num, double score) {
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
	
}
