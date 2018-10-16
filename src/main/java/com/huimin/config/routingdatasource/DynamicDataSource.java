package com.huimin.config.routingdatasource;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends  AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.get();
	}

	@Override
	public DataSource determineTargetDataSource() {
		return super.determineTargetDataSource();
	}
	

}
