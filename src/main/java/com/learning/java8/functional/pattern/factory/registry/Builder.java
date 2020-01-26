package com.learning.java8.functional.pattern.factory.registry;

import com.learning.java8.functional.pattern.factory.Factory;


// Consider as Key Value Holder like MAP; Factory is nothing but supplier;

public interface Builder<T> {
	
	void register(String key, Factory<T> factory);

}
