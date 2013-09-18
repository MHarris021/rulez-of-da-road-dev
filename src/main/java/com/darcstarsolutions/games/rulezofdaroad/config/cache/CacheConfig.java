package com.darcstarsolutions.games.rulezofdaroad.config.cache;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.spring.MemcachedClientFactoryBean;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

//	@Bean
//	public CacheManager cacheManager() {
//		MemcachedClientFactoryBean memcachedClientFactoryBean = new MemcachedClientFactoryBean();
//		MemcachedClient memcachedClient =  (MemcachedClient) memcachedClientFactoryBean.getObject();
//	}
	
}
