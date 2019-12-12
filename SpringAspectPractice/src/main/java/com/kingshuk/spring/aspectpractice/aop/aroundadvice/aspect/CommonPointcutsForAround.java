package com.kingshuk.spring.aspectpractice.aop.aroundadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**A common class for storing all point cut declarations
 * Created by CO21321 on 2/13/2018.
 */
public class CommonPointcutsForAround {

    @Pointcut("execution(* com.kingshuk.spring.aop.aroundadvice.service.*.*OneClaim*(..))")
    public void forAllClaims(){}

    /*@Pointcut("execution(* com.kingshuk.spring.aop.afterretruningadvice.service.*.*OneClaim*(..))")
    public void forLoggingTimeTaken(){}*/

    @Pointcut("execution(* com.kingshuk.spring.aop.aroundadvice.service.*.*Insured*(..))")
    public void allInsuredActivities(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.aroundadvice.service.*.*NewInsured(..))")
    public void addInsuredActivity(){}

    @Pointcut("allInsuredActivities() && !addInsuredActivity()")
    public void allInsuredActivitiesExceptAddingInsured(){}
}
