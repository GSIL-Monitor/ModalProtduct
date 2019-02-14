package com.huimin.elasticsearch.common;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TypeQueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.huimin.util.LogUtil;

public abstract class AbstractElasticsearchRepository<T> implements ElasticsearchRepository<T> {

	protected final LogUtil logger = LogUtil.logger(this);
	@Autowired
	protected RestHighLevelClient restHighLevelClient;

	@Override
	public T getById(T t) {
		try {
			GetRequest getRequest = new GetRequest(getIndexName(t), ElasticsearchUtil.getType(t), ElasticsearchUtil.getId(t));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			String sourceAsString = response.getSourceAsString();
			return ElasticsearchUtil.covert(sourceAsString, t);
		} catch (IOException e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
	}

	@Override
	public List<T> getByType(T t) {
		try {
			TypeQueryBuilder typeQuery = QueryBuilders.typeQuery(ElasticsearchUtil.getType(t));
			SearchRequest searchRequest = new SearchRequest(getIndexName(t))
					.source(new SearchSourceBuilder()
							.query(typeQuery));
			SearchHits hits = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT)
			.getHits();
			return ElasticsearchUtil.handleHits(hits, t);
		} catch (IOException e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
	}

	@Override
	public boolean insert(T t) {
		IndexRequest indexRequest = new IndexRequest(getIndexName(t), ElasticsearchUtil.getType(t), ElasticsearchUtil.getId(t))
		.source(ElasticsearchUtil.getSource(t), XContentType.JSON);
		try {
			restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
			return true;
		} catch (IOException e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
	}

	@Override
	public boolean update(T t) {
		UpdateRequest updateRequest = new UpdateRequest(getIndexName(t), ElasticsearchUtil.getType(t), ElasticsearchUtil.getId(t))
		.doc(ElasticsearchUtil.getSource(t), XContentType.JSON);
		try {
			restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
			return true;
		} catch (IOException e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
	}

	@Override
	public boolean delete(T t) {
		DeleteRequest deleteRequest = new DeleteRequest(getIndexName(t), ElasticsearchUtil.getType(t), ElasticsearchUtil.getId(t));
		try {
			restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
		return true;
	}

	@Override
	public void deleteIndex(String... Indexs) {
		try {
			DeleteIndexRequest request = new DeleteIndexRequest(Indexs);
		    restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
	}
	
	@Override
	public void deleteType(T t) {
		try {
			DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest(getIndexName(t))
					                                         .types(ElasticsearchUtil.getType(t));
			restHighLevelClient.deleteByQuery(deleteByQueryRequest , RequestOptions.DEFAULT);
		} catch (Exception e) {
			logger.error(e);
			throw new ElasticsearchException(e);
		}
		
	}
	@Override
	public List<T> search(T t, QueryBuilder queryBuilder) {
		try {
			SearchRequest searchRequest = new SearchRequest(getIndexName(t))
			.types(ElasticsearchUtil.getType(t))
			.source(new SearchSourceBuilder().query(queryBuilder));
			SearchHits hits = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT).getHits();
			return ElasticsearchUtil.handleHits(hits, t);
		} catch (Exception e) {
			throw new ElasticsearchException(e);
		}
	}
	
	
	private String getIndexName(T t) {
		String idexName = ElasticsearchUtil.getIndexName(t);
		return idexName;
	}
}
