package com.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Repeatable(Logs.class)
//@Retention(RetentionPolicy.SOURCE)
//@Target(ElementType.METHOD)
public @interface Log {
	String author();
	String version() default "1.0";
}
// container for the Log annotation
@interface Logs{
	Log[] value();
}