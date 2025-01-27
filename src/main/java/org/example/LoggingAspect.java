package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    //@Around("execution(* org.example.services.*.*(..))")
    // нужно перехватывать вызовы всех методов из пакета services,
    // независимо оn типа возвращаемого значения, класса, к которому метод принадлежит,
    // имени метода или принимаемых им параметров

    @Around("@annotation(ToLog)")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");
        joinPoint.proceed(arguments);
        logger.info("Method executed ");
    }
}
