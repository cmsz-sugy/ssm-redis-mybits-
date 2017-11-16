package com.fei.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fei.app.service.impl.RedisSaveManagerServiceImpl;

@Controller
@RequestMapping("/su/redis/")
public class redisController{
	
	 private final Logger logger = LoggerFactory.getLogger(redisController.class);
	 
//	 
//	 @Value("${redis.key.prefix}")
//	 private String redisPrefixKey;
//	 
	 @RequestMapping(value = "test")
	 @ResponseBody
	 public String getRedisKeyAccountName(String accountName) {
		 return " ";
//	        return redisPrefixKey + "_board_" + accountName;
	    }

	 
	 

}
