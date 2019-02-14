package com.huimin.elasticsearch.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Document {

	/**
	 * es中的索引
	 * @return
	 */
	String indexName();
	
	/**
	 * es中的类型
	 * @return
	 */
	String type();
}
