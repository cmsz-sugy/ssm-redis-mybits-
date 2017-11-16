package com.fei.app.model;

import java.io.Serializable;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
public class MybatisRedisCache implements Cache{
	    private Jedis jedis;//非切片额客户端连接
	    private JedisPool jedisPool;//非切片连接池
	    private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);  
	    private Jedis redisClient=initialPool();  
	     /** The ReadWriteLock. */    
	    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();   
	      
	    private String id;  
	      
	    public MybatisRedisCache(final String id) {    
	        if (id == null) {  
	            throw new IllegalArgumentException("Cache instances require an ID");  
	        }  
	        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);  
	        this.id = id;  
	    }    
	    @Override  
	    public String getId() {  
	        return this.id;  
	    }  
	  
	    @Override  
	    public int getSize() {  
	     
	        return Integer.valueOf(redisClient.dbSize().toString());  
	    }  
	  
	    @Override  
	    public void putObject(Object key, Object value) {  
	        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value); 
	        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));  
	    }  
	  
	    @Override  
	    public Object getObject(Object key) {  
	        Object value = SerializeUtil.deserialize(redisClient.get(SerializeUtil.serialize(key.toString())));  
	        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"="+value);  
	        return value;  
	    }  
	  
	    @Override  
	    public Object removeObject(Object key) { 
	    	 SerializeUtil serialize = null;
	        return redisClient.expire(serialize.serialize(key.toString()),0);  
	    }  
	  
	    @Override  
	    public void clear() {  
	          redisClient.flushDB();  
	    }  
	    @Override  
	    public ReadWriteLock getReadWriteLock() {  
	        return readWriteLock;  
	    } 
	    private Jedis initialPool() 
	    { 
	    	try {
	        // 池基本配置 
	        JedisPoolConfig config = new JedisPoolConfig(); 
	        config.setMaxTotal(8);
	        config.setMaxIdle(5); 
	        config.setMinEvictableIdleTimeMillis(1800000);
	        config.setTestOnBorrow(false); 
	        jedisPool = new JedisPool(config,"127.0.0.1",6379);

	    	}catch(Exception e) {
	    		
	    		e.printStackTrace();
	    		
	    	}
	        return jedisPool.getResource();
	    	
	    }
 
	    /**
	     * 初始化非切片池
	     */

}
