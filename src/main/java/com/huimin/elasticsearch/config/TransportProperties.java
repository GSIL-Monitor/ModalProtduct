package com.huimin.elasticsearch.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.elasticsearch.transport")
public class TransportProperties {

	private String username;
	private String password;
	private List<String> uris;
	private String clusterName;
	private boolean transportSniff;
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
	public List<String> getUris() {
		return uris;
	}
	public void setUris(List<String> uris) {
		this.uris = uris;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public boolean isTransportSniff() {
		return transportSniff;
	}
	public void setTransportSniff(boolean transportSniff) {
		this.transportSniff = transportSniff;
	}
}
