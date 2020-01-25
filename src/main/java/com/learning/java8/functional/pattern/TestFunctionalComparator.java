package com.learning.java8.functional.pattern;

import java.util.function.Function;

public class TestFunctionalComparator {
	
	public static void main(String[] args) {
		
		Person vijay = new Person("Vijay",34);
		Person ajay = new Person("Ajay",35);
		Person jay = new Person("jay",36);
		
		Function<Person, String> pNameFunc= p->p.getName();
		
		MyComparator<Person> comparator = comparing(pNameFunc);
		
		System.out.println(comparator.comparing(vijay, jay)>0);
		System.out.println(comparator.comparing(vijay, ajay)>0);
	}

	private static MyComparator<Person> comparing(Function<Person, String> pNameFunc) {
		return (p1, p2) -> {
			String s1 = pNameFunc.apply(p1);
			String s2 = pNameFunc.apply(p2);
			return s1.compareTo(s2);
		};
	}

}



class Person {
	
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
