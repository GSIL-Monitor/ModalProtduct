package com.huimin.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;

@ConfigurationProperties(prefix = "test")
@Component
public class MydatasourceProperyity {

	private  List<DatasourceCon> mydatasource;
	
	private HikariConfig hikari;
	
	
	public List<DatasourceCon> getMydatasource() {
		return mydatasource;
	}


	public void setMydatasource(List<DatasourceCon> mydatasource) {
		this.mydatasource = mydatasource;
	}

	

	public HikariConfig getHikari() {
		return hikari;
	}


	public void setHikari(HikariConfig hikari) {
		this.hikari = hikari;
	}



	public static  class DatasourceCon{
		private String name;
		private String username;
		private String password;
		private String url;
		private String driverClassName;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		
	}
}
