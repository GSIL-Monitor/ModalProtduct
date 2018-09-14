package com.huimin.distributedlock;

/** 
 * Redis分布式锁接口 
 * @author zhuliang on 2018/5/17. 
 */  
public interface DistributionLock {  
    /** 
     * 加锁成功，返回true
     * @param lockKey 锁标识
     * @return 
     */
    public boolean lock(String lockKey);  
  
    /** 
     * 解锁， 判断是否有权限 
     * @param lockKey 锁标识
     */  
    public void unlock(String lockKey);  
  
    /** 
     * 多服务器集群，使用下面的方法，代替System.currentTimeMillis()，获取redis时间，避免多服务的时间不一致问题！！！ 
     * @return 
     */  
//    public default long currtTimeForRedis() {
//    	throw new UnsupportedOperationException();
//    };  
}  