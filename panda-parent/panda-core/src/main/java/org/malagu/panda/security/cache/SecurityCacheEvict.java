package org.malagu.panda.security.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.malagu.panda.security.Constants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

/**
 * @author Kevin Yang (mailto:kevin.yang@bstek.com)
 * @since 2016年8月14日
 */
@Target({ElementType.METHOD, ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Inherited 
@Caching(evict = {
		@CacheEvict(cacheNames = {
				Constants.URL_TREE_CACHE_KEY, 
				Constants.REQUEST_MAP_CACHE_KEY,
				Constants.COMPONENT_MAP_CACHE_KEY,
				Constants.COMPONENT_ATTRIBUTE_MAP_CACHE_KEY,
		}, keyGenerator = Constants.KEY_GENERATOR_BEAN_NAME)
})
public @interface SecurityCacheEvict {

}
