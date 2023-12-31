package com.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestNativeMethods {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = NativeMethods.class.getMethod("m1", null);
		System.out.println(method.getName());
		System.out.println(method.getModifiers());
		System.out.println(method.getParameterCount());
		OSystem anno = method.getAnnotation(OSystem.class);
		System.out.println(anno.ostype());
		System.out.println(System.getProperty("os.name"));
	}
}
