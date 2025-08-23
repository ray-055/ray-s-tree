package com.zyd.blog.business.aspect;

import com.zyd.blog.business.annotation.BusinessLog;
import com.zyd.blog.business.enums.PlatformEnum;
import com.zyd.blog.business.service.SysLogService;
import com.zyd.blog.util.AspectUtil;
import com.zyd.blog.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class BusinessLogAspect {
    @Autowired
    private SysLogService logService;

    @Pointcut("@annotation(com.zyd.blog.business.annotation.BusinessLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object writelog(ProceedingJoinPoint point) throws Throwable{
        Object result = point.proceed();
        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错", e);
        }
        return result;
    }



    private void handle(ProceedingJoinPoint point) throws Exception {
        Method currentMethod = AspectUtil.INSTANCE.getMethod(point);
        //获取操作名称
        BusinessLog annotation = currentMethod.getAnnotation(BusinessLog.class);
        boolean save = annotation.save();
        PlatformEnum platform = annotation.platform();
        String bussinessName = AspectUtil.INSTANCE.parseParams(point.getArgs(), annotation.value());
        String ua = com.zyd.blog.util.RequestUtil.getUa();

        log.info("{} | {} - {} {} - {}", bussinessName, com.zyd.blog.util.RequestUtil.getIp(), com.zyd.blog.util.RequestUtil.getMethod(), RequestUtil.getRequestUrl(), ua);
        if (!save) {
            return;
        }

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        logService.asyncSaveSystemLog(platform, bussinessName, servletRequestAttributes);
    }

}