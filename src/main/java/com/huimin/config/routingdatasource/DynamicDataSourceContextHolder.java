package com.huimin.config.routingdatasource;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder {
    
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static List<String> dataSourceIds = new ArrayList<>();

    public static String get() {
    	return contextHolder.get();
    }
    
    public static void set(String value) {
    	contextHolder.set(value);
    }
    
    public static void remove() {
    	contextHolder.remove();
    }
    
    /**
     * 判断指定DataSrouce当前是否存在
     *
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
