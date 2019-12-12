package com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.beans.ClaimBenefits;
import com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.beans.ClaimEvent;
import com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.beans.Insured;

/** An interface to simulate the claims inquiry scenario
 * Created by CO21321 on 2/12/2018.
 */
@Component
public interface ClaimsBusinessService {

    void createANewClaim(ClaimEvent event);

    List<ClaimEvent> getAllInsuredClaims(Insured insured);

    ClaimEvent viewOneClaim(Integer claimEventId);

    Insured viewOneInsured(Integer insuredId);

    List<Insured> viewAllInsured();

    ClaimBenefits getBenefitDetailsForClaim(Integer claimEventId);

    List<ClaimBenefits> getAllBenefitAmountsForInsured(Integer insuredId);

    void addANewInsured(Insured insured);
}
