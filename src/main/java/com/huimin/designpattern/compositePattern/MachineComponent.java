package com.huimin.designpattern.compositePattern;

import java.util.List;

/**
 * 测试组合模式
 * 一个工厂 是由多个车间组成的 每个车间又是由多条生产线组成的 每天生产线由多台机器组成
 * 故以机器为最小单位 去组合整个工厂
 * 此接口主要为获取机器数量的  
 * @author zhuliang
 *
 * @Date 2018年4月28日上午11:21:54
 */
public interface MachineComponent {

	/**
	 * 
	 * @return
	 */
	int getMachineComponent();
	
	boolean isCOmpletelyUp();
	
	void stopAll();
	 
	List<String> getOwners();
	
}
