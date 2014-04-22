package com.iris.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseBodyAdvice {
    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    private void responseBoyPointcut() {
    }

    @Around("responseBoyPointcut()")
    public Object wrapResponseObject(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object ret = pjp.proceed();
            return new ResponseBodyVO(ret);
        } catch (Exception ex) {
            return new ResponseBodyVO(ex);
        }
    }
}
