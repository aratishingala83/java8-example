package com.learning.java8.functional.pattern.factory;

import java.util.function.Supplier;

public interface Factory<T> extends Supplier<T>{
	
	default  Factory<T> newInstance(){
		return ()->get();
	}

}
