package com.kingshuk.spring.aspectpractice.aop.afterreturningadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**A common class for storing all point cut declarations
 * Created by CO21321 on 2/13/2018.
 */
public class CommonPointcutsForAfterReturning {

    @Pointcut("execution(* com.kingshuk.spring.aop.afterreturningadvice.service.*.*OneClaim*(..))")
    public void forAllClaims(){}

    /*@Pointcut("execution(* com.kingshuk.spring.aop.afterretruningadvice.service.*.*OneClaim*(..))")
    public void forLoggingTimeTaken(){}*/
}
