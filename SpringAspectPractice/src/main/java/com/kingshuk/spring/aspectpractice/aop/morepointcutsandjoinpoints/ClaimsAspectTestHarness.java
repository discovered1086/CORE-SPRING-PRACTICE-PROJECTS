package com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.beans.ClaimBenefits;
import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.beans.ClaimEvent;
import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.beans.Insured;
import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.service.ClaimsBusinessService;
import com.kingshuk.spring.aspectpractice.config.AOPImplementationConfigForPointcut;

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
                new AnnotationConfigApplicationContext(AOPImplementationConfigForPointcut.class);

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
        businessService.createANewClaim(insured, event);

        businessService.getAllInsuredClaims(insured);

        businessService.getAllBenefitAmountsForInsured(insured.getInsuredId());

        businessService.getBenefitDetailsForClaim(event.getClaimEventId());

        businessService.viewAllInsured();

        businessService.viewOneClaim(event.getClaimEventId());

        businessService.viewOneInsured(insured.getInsuredId());

        /**
         * Step 4: Finally closing the application context/container
         */
        annotationConfigApplicationContext.close();
    }


}
