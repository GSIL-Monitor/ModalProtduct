package com.huimin.elasticsearch.common;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;

public interface ElasticsearchRepository<T> {

	/**
	 * 根据id查询
	 * @param t
	 * @return
	 */
	T getById(T t);
	
	/**
	 * 根据type查询
	 * @param t
	 * @return
	 */
	List<T> getByType(T t);
	
	/**
	 * 新增
	 * @param t
	 * @return
	 */
	boolean insert(T t);
	
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	boolean update(T t);
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	boolean delete(T t);
	
	/**
	 * 根据条件查询
	 * @param t
	 * @return
	 */
	List<T> search(T t, QueryBuilder queryBuilder);
	
	void deleteIndex(String ... Indexs);
	
	void deleteType(T t);
}
