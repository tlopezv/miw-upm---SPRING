package com.miw.upm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {

    @Pointcut("execution(* * (..))")
    public void allMethods() {
    }

    @Pointcut("execution(public * * (..))")
    public void allMethodsPublic() {
    }

    @Pointcut("execution(* com.miw.upm.aspectTarget.*.* (..))")
    public void allMethodsPackage() {
    }

    @Pointcut("within(com.miw.upm.aspectTarget.*)")
    public void allMethodsInPackage() {
    }

    @Pointcut("within(com.miw.upm.aspectTarget.*)")
    public void allMethodsInPackageAndSubPackage() {
    }

    @Before("allMethodsPackage()")
    public void adviceA(JoinPoint jp) {
        System.out.println("=== Consejo Antes de ejecutar a métodos de un paquete:" + jp.getSignature().getName());
    }

    @Before("execution(* me*(..))")
    public void adviceB(JoinPoint jp) {
        System.out
                .println("=== Consejo Antes de ejecutar a métodos que empiezan por me*:" + jp.getSignature().getName());
    }

    @Before("args(arg)")
    public void adviceC(JoinPoint jp, String arg) {
        System.out.println("=== Consejo Antes de ejecutar métodos con un argumento de tipo String:"
                + jp.getSignature().getName() + "(arg):" + arg);
    }

    @Before("@target(com.miw.upm.aspect.GenericAnnotation)")
    public void adviceD(JoinPoint jp) {
        System.out.println("=== Consejo Antes de ejcutar métodos de una clase con GenericAnnotation:"
                + jp.getSignature().getName());
    }

    @Before("@annotation(com.miw.upm.aspect.MethodAnnotation)")
    public void adviceE(JoinPoint jp) {
        System.out.println(
                "=== Consejo Antes de ejecutar métodos con el MethodAnnotation:" + jp.getSignature().getName());
    }

    @AfterReturning(pointcut = "allMethods()", returning = "result")
    public void adviceF(JoinPoint jp, int result) {
        System.out.println("=== Consejo Después de ejecutar métodos que devuelven un int:" + jp.getSignature().getName()
                + " return:" + result);
    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "exception")
    public void adviceG(JoinPoint jp, Exception exception) {
        System.out.println("=== Consejo Después de ejecutar métodos que provocan una Exception:"
                + jp.getSignature().getName() + " return:" + exception);
    }

    @After("execution(* com.miw.upm.aspectTarget.ServiceOne.exception())")
    public void adviceH(JoinPoint jp) {
        System.out.println("=== Consejo Después de ejecutar métodos (finally):" + jp.getSignature().getName());
    }

    @Around("execution(* com.miw.upm.aspectTarget.ServiceOne.method())")
    public Object adviceI(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=== antes......");
        Object obj = pjp.proceed();
        System.out.println("=== ......después");
        return obj;
    }
}
