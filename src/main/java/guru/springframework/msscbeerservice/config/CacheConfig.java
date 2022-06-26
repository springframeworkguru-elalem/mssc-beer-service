package guru.springframework.msscbeerservice.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


//@Configuration
//@EnableCaching
public class CacheConfig {
//    @Bean
//    public CacheManager ehCacheManager() {
//        EhcacheManager ehcacheManager = new EhcacheManager();
//
//        return ehcacheManager;
//    }
//@Bean
//public CacheManager cacheManager() {
//    SimpleCacheManager cacheManager = new SimpleCacheManager();
//    List<CaffeineCache> caffeineCaches = new ArrayList<>();
//
//    caffeineCaches.add(new CaffeineCache("beerCache", CaffeineCache.))
//    for (CacheConstant cacheType : CacheConstant.values()) {
//        caffeineCaches.add(new CaffeineCache(cacheType.toString(),
//                Caffeine.newBuilder()
//                        .expireAfterWrite(cacheType.getExpires(), TimeUnit.SECONDS)
//                        .maximumSize(cacheType.getMaximumSize())
//                        .build()));
//    }
//    cacheManager.setCaches(caffeineCaches);
//    return cacheManager;
//}

}
