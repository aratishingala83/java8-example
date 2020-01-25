package com.learning.java8.functional.pattern.factory2;

import java.util.function.Function;
import java.util.function.Supplier;


@FunctionalInterface
public interface CarFactory2<T> extends Supplier<T> {
	
	//Supplier Interface already have 'get' method so can not declare one more abstract method here 
	//because this interface extends Supplier
	
	default  T newInstance(){
		return get(); 
	}
	
	
	static <T> CarFactory2<T> createFactory(Supplier<T> supplier){
		return ()->supplier.get();
	}
	
	static <P,T> CarFactory2<T> createFactory(Function<P,T> function,P color){
		//Supplier<Car> supplier = ()->new Car(color); // This can be Function which accept color return Car
		//Function<String,Car> function = clr -> new Car(clr); 
		//function.apply(color);
		return ()->function.apply(color);
	}

}
