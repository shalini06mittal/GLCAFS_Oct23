package com.generics;

public class MyGenerics<T> {

	T object;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "MyGenerics [object=" + object + "]";
	}
	
	
}
