package com.huimin.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;
import com.baomidou.mybatisplus.spring.boot.starter.SpringBootVFS;
import com.huimin.config.MydatasourceProperyity.DatasourceCon;
import com.huimin.config.routingdatasource.DynamicDataSource;
import com.huimin.config.routingdatasource.DynamicDataSourceContextHolder;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
@MapperScan(basePackages = "com.huimin.mapper")
public class MybatisPlusConfig {

	@Autowired
	private MybatisPlusProperties properties;
	private ResourceLoader resourceLoader = new DefaultResourceLoader();
	@Autowired(required = false)
	private Interceptor[] interceptors;
	@Autowired(required = false)
	private DatabaseIdProvider databaseIdProvider;

	@Autowired
	private MydatasourceProperyity mydatasourceProperyity;
	
	@Bean
	public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
		MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
		mybatisPlus.setDataSource(dynamicDataSource());
		mybatisPlus.setVfs(SpringBootVFS.class);
		if (StringUtils.hasText(this.properties.getConfigLocation())) {
			mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
		}
		if (!ObjectUtils.isEmpty(this.interceptors)) {
			mybatisPlus.setPlugins(this.interceptors);
		}
		// MP 全局配置，更多内容进入类看注释
		GlobalConfiguration globalConfig = new GlobalConfiguration();
		globalConfig.setDbType(DBType.MYSQL.name());
		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID")
		// UUID->`3`("全局唯一ID")
		globalConfig.setIdType(0);
		mybatisPlus.setGlobalConfig(globalConfig);
		MybatisConfiguration mc = new MybatisConfiguration();
		mc.setMapUnderscoreToCamelCase(true);
		mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		mybatisPlus.setConfiguration(mc);
		if (this.databaseIdProvider != null) {
			mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
		}
		if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
			mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
		}
		if (StringUtils.hasLength(this.properties.getTypeEnumsPackage())) {
			mybatisPlus.setTypeEnumsPackage(this.properties.getTypeEnumsPackage());
		}
		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
			mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
		}
		if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
			mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
		}
		mybatisPlus.setConfiguration(this.properties.getConfiguration());
		return mybatisPlus;
	}

	@Bean
	public DataSource dynamicDataSource() {
		List<DatasourceCon> mydatasource = mydatasourceProperyity.getMydatasource();
		Map<Object, Object> targetDataSources = new HashMap<>();
		List<String> dataSourceIds = DynamicDataSourceContextHolder.dataSourceIds;
		String defaultTargetDataSource = "default";
		HikariConfig hikariConfig = mydatasourceProperyity.getHikari();
		mydatasource.forEach(datasourceCon -> {
			hikariConfig.setDriverClassName(datasourceCon.getDriverClassName());
			hikariConfig.setJdbcUrl(datasourceCon.getUrl());
			hikariConfig.setUsername(datasourceCon.getUsername());
			hikariConfig.setPassword(datasourceCon.getPassword());
//			HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder.create().driverClassName(datasourceCon.getDriverClassName()).url(
//					datasourceCon.getUrl())
//					.username(datasourceCon.getUsername()).password(datasourceCon.getPassword())
//					.type(HikariDataSource.class)
//					.build();
			HikariDataSource dataSource = new HikariDataSource(hikariConfig);
			String name = datasourceCon.getName();
			dataSourceIds.add(name);
			targetDataSources.put(name, dataSource);
		});
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setDefaultTargetDataSource(targetDataSources.get(defaultTargetDataSource));
		targetDataSources.remove(defaultTargetDataSource);
		dynamicDataSource.setTargetDataSources(targetDataSources);
		return dynamicDataSource;
	}
	@Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
