package com.zyd.blog.business.aspect;

import com.zyd.blog.business.annotation.RedisCache;
import com.zyd.blog.business.service.RedisService;
import com.zyd.blog.framework.property.AppProperties;
import com.zyd.blog.util.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class RedisCacheAspect {
    private static final String REDIS_CACHE_KEY_PREFIX = "biz_cache";

    @Autowired
    private RedisService redisService;
    @Autowired
    private AppProperties appProperties;

    @Pointcut(value = "@annotation(com.zyd.blog.business.annotation.RedisCache)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handle (ProceedingJoinPoint point) throws Throwable{
        //全局缓存开关检查
        if (!appProperties.isEnableRedisCache()) {
            return point.proceed();
        }

        //方法级缓存开关检查
        Method method = AspectUtil.INSTANCE.getMethod(point);
        RedisCache cache = method.getAnnotation(RedisCache.class);
        boolean isenable = cache.enable();
        if (!isenable) {
            return point.proceed();
        }

        //缓存刷新处理
        if (cache.flush()) {
            String class_prefix = AspectUtil.INSTANCE.getKey(point, REDIS_CACHE_KEY_PREFIX);
            log.info("清空缓存 - {}*", class_prefix);
            redisService.delBatch(class_prefix);
            return point.proceed();
        }
        //缓存读取数据
        String key = AspectUtil.INSTANCE.getKey(point, cache.key(), REDIS_CACHE_KEY_PREFIX);
        boolean haskey = redisService.hasKey(key);
        if (haskey) {
            try {
                log.info("{}从缓存读取数据", key);
                return redisService.get(key);
            } catch (Exception e) {
                log.error("缓存读取数据异常", e);
            }
        }

        //缓存未命中处理
        Object result = point.proceed();
        //log.info("{}写入缓存", key);
        redisService.set(key, result, cache.expire(), cache.unit());
        log.info("{}从数据库中获取数据", key);
        return result;



    }


}
