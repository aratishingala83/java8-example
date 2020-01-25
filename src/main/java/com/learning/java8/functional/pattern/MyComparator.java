package com.learning.java8.functional.pattern;

import java.util.function.Function;

public interface MyComparator<T> {
	
	int comparing(T t1, T t2);
	
	default <T, U extends Comparable<U>> MyComparator<T> comparing(Function<T, U> pNameFunc) {
		return (p1, p2) -> {
			U s1 = pNameFunc.apply(p1);
			U s2 = pNameFunc.apply(p2);
			return  s1.compareTo( s2);
		};
	}

}
