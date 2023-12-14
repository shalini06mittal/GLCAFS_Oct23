package com.generics;
// upper bound
public class BoundedGenerics<T extends Number> {
	
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
