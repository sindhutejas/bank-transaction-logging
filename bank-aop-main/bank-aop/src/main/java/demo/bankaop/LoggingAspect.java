
package demo.bankaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.bankaop.BankService.*(..))")
    public void beforeTransaction(JoinPoint joinPoint) {

        System.out.println(
            "[AOP] Transaction started: "
            + joinPoint.getSignature().getName()
        );
    }

    @AfterReturning(
        "execution(* demo.bankaop.BankService.*(..))"
    )
    public void afterSuccess(JoinPoint joinPoint) {

        System.out.println(
            "[AOP] Transaction completed: "
            + joinPoint.getSignature().getName()
        );
    }

    @AfterThrowing(
        pointcut = "execution(* demo.bankaop.BankService.*(..))",
        throwing = "error"
    )
    public void afterFailure(
            JoinPoint joinPoint, Throwable error) {

        System.out.println(
            "[AOP] Transaction failed: "
            + joinPoint.getSignature().getName()
            + " - " + error.getMessage()
        );
    }
}

