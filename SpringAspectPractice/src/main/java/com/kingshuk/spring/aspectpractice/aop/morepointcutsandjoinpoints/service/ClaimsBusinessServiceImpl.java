package com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.beans.ClaimBenefits;
import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.beans.ClaimEvent;
import com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.beans.Insured;

/** A class where the claims aspect will be applied
 * Created by CO21321 on 2/12/2018.
 */
@Component
public class ClaimsBusinessServiceImpl implements ClaimsBusinessService{
    @Override
    public void createANewClaim(Insured insured, ClaimEvent event) {
        System.out.println("<<createANewClaim>> Just trying to add a new claim for the insured");
    }

    @Override
    public List<ClaimEvent> getAllInsuredClaims(Insured insured) {
        System.out.println("<<getAllInsuredClaims>> Just trying to get all claims for the insured");
        return null;
    }

    @Override
    public ClaimEvent viewOneClaim(Integer claimEventId) {
        System.out.println("<<viewOneClaim>> Just trying to print a claim");
        return null;
    }

    @Override
    public Insured viewOneInsured(Integer insuredId) {
        System.out.println("<<viewOneInsured>> Just trying to get details of one the insured");
        return null;
    }

    @Override
    public List<Insured> viewAllInsured() {
        System.out.println("<<viewAllInsured>> Just trying to get all insured information in this system");
        return null;
    }

    @Override
    public ClaimBenefits getBenefitDetailsForClaim(Integer claimEventId) {
        System.out.println("<<getBenefitDetailsForClaim>> Just trying to get benefit information for a claim");
        return null;
    }

    @Override
    public List<ClaimBenefits> getAllBenefitAmountsForInsured(Integer insuredId) {
        System.out.println("<<getAllBenefitAmountsForInsured>> Just trying to get benefit information for all claims belonging to one insured");
        return null;
    }
}
