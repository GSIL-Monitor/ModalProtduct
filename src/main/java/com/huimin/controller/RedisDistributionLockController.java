package com.huimin.controller;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.distributedlock.DistributionLock;

@RestController
@RequestMapping("/redis")
public class RedisDistributionLockController {

    private static int i = 0;  
  
    private ExecutorService service =  Executors.newFixedThreadPool(20);  
  
    @Autowired  
    private DistributionLock redisDistributionLock;  
   
  //  @Autowired  
    private DistributionLock mysqlDistributionLockImpl;  
  
    @Autowired
    private StringRedisTemplate redisTemplate;
    /** 
     * 模拟1000个线程同时执行业务，修改资源 
     * 
     * 使用线程池定义了20个线程 
     * 
     */  
    @GetMapping("lock1")  
    public void testRedisDistributionLock1(){  
        for (int i=0;i<20;i++){  
            service.execute(() -> {
            	 task("redis", redisDistributionLock);
            });  
        }  
  
    }  
    @GetMapping("lock2")  
    public void testMysqlDistributionLock1(){  
    	for (int i=0;i<20;i++){  
    		 service.execute(() -> {
            	 task("redis", mysqlDistributionLockImpl);
            });   
    	}  
    	
    }  
  
    @GetMapping("/{key}")  
    public String getValue(@PathVariable("key") String key){  
        Serializable result = redisTemplate.opsForValue().get(key);  
        return result.toString();  
    }  
  
    private void task(String name, DistributionLock distributionLock) {  
//        System.out.println(name + "任务执行中"+(i++));  
  
        //创建一个redis分布式锁  
        //加锁时间  
        if (distributionLock.lock(name)){  
            //开始执行任务  
            System.out.println(Thread.currentThread().getName() + "任务执行中"+(i++));  
            //任务执行完毕 关闭锁  
           // distributionLock.unlock(name);  
        }  
  
    }  
}
