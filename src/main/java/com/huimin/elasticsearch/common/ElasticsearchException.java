package com.huimin.elasticsearch.common;

public class ElasticsearchException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ElasticsearchException() {
	}
	public ElasticsearchException(String message) {
		super(message);
	}
	public ElasticsearchException(Exception exception) {
		super(exception);
	}
}
