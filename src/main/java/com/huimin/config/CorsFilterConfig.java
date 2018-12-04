package com.huimin.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * 跨域配置
 * @author zhuliang
 *
 * @Date 2018年10月17日下午2:45:05
 */
//@Configuration
public class CorsFilterConfig {
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(source);
	}
	@Bean
	public FilterRegistrationBean<Filter> corsfilterRegistration() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(corsFilter());
		registrationBean.setOrder(1);
		return registrationBean;
	}
}
