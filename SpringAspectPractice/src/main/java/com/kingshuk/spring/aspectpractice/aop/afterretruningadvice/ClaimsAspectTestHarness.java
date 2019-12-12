package com.kingshuk.spring.aspectpractice.aop.afterretruningadvice;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.beans.ClaimBenefits;
import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.beans.ClaimEvent;
import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.beans.Insured;
import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.service.ClaimsBusinessService;
import com.kingshuk.spring.aspectpractice.config.AOPConfigForAfterReturningAdvice;

/**
 * A test harness to practice the aspect created for claims
 * Created by CO21321 on 2/12/2018.
 */

public class ClaimsAspectTestHarness {


    public static void main(String[] args) {

        /**
         * Step 1:  Getting the configuration from the java config file to create the container
         */

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AOPConfigForAfterReturningAdvice.class);

        /**
         * Step 2: Getting the bean from the container
         */

        ClaimsBusinessService businessService = annotationConfigApplicationContext.getBean("ClaimsBusinessService", ClaimsBusinessService.class);


        Insured insured = new Insured();
        insured.setFirstName("Kingshuk");
        insured.setLastName("Mukherjee");
        insured.setEmployeeId(232649);
        insured.setInsuredId(232649);
        insured.setDob("10/16/1986");

        ClaimEvent event = new ClaimEvent();
        event.setClaimEventId(11564654);
        event.setInsured(insured);
        event.setClaimType("STD");
        event.setClaimRaisedDate(new Date());
        event.setClaimStatus("APPROVED");

        ClaimBenefits claimBenefits=new ClaimBenefits();
        claimBenefits.setClaimEventId(11564654);
        claimBenefits.setBenefitStatus("APPROVED");
        claimBenefits.setBenefitAmount(780.00);

        /**
         * Step 3: Calling the methods on the bean
         */
        businessService.addANewInsured(insured);

        businessService.createANewClaim(event);

        //businessService.getAllInsuredClaims(insured);

        //businessService.getAllBenefitAmountsForInsured(insured.getInsuredId());

        //businessService.getBenefitDetailsForClaim(event.getClaimEventId());

        //businessService.viewAllInsured();

        ClaimEvent claimEvent = businessService.viewOneClaim(event.getClaimEventId());

        System.out.println("\n_____________________________________________________________________\n"+
        "<<ClaimsAspectTestHarness>> The claimant name is "+claimEvent.getInsured().getFirstName()+" "+claimEvent.getInsured().getLastName());

        //businessService.viewOneInsured(insured.getInsuredId());

        /**
         * Step 4: Finally closing the application context/container
         */
        annotationConfigApplicationContext.close();
    }


}
