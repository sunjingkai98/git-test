package com.intouch.aop;

import com.intouch.util.PropertiesUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class ServiceTrace {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SSS");

    @Pointcut("within(com.intouch.service..*)")
    private void servicePointcut() {
    }

    @Around("servicePointcut()")
    public Object traceLog(ProceedingJoinPoint jpoint) throws Throwable {

        String className = jpoint.getTarget().getClass().getName();
        String method = jpoint.getSignature().getName();
        String key = className + "." + method;
        String methodInfo = PropertiesUtil.getPropertyValue(key);

        long start = System.currentTimeMillis();
        System.out.println("AOP环绕通知:" + dateFormat.format(new Date(start)) +" "+ methodInfo + "开始执行...");
        ////////////////////////////////
        Object obj = jpoint.proceed();//
        ////////////////////////////////
        long end = System.currentTimeMillis();
        System.out.println("AOP环绕通知:" + dateFormat.format(new Date(end)) + methodInfo + "执行完毕...共耗时" + (end - start) + "毫秒！");

        return obj;
    }

}
