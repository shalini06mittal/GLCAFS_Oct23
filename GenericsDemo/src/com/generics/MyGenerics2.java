package com.generics;

public class MyGenerics2<T, V, A> {

	T object;
	V v;
	A a;
	

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	
	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "MyGenerics [object=" + object + "]";
	}
	
	
}
