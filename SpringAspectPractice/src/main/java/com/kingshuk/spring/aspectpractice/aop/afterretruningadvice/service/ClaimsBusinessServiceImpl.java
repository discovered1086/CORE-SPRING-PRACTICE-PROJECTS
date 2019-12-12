package com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.beans.ClaimBenefits;
import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.beans.ClaimEvent;
import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.beans.Insured;
import com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.utility.ApplicationUtil;

/** A class where the claims aspect will be applied
 * Created by CO21321 on 2/12/2018.
 */
@Component
public class ClaimsBusinessServiceImpl implements ClaimsBusinessService {
    @Override
    public void createANewClaim(ClaimEvent event) {
        System.out.println("<<createANewClaim>> Just trying to add a new claim for the insured");
        ApplicationUtil.addClaimsToMap(event);
    }

    @Override
    public List<ClaimEvent> getAllInsuredClaims(Insured insured) {
        System.out.println("<<getAllInsuredClaims>> Just trying to get all claims for the insured");
        return ApplicationUtil.getAllClaimsForInsured(insured.getInsuredId());
    }

    @Override
    public ClaimEvent viewOneClaim(Integer claimEventId) {
        System.out.println("<<viewOneClaim>> Just trying to print a claim");
        return ApplicationUtil.getOneClaim(claimEventId);
    }

    @Override
    public Insured viewOneInsured(Integer insuredId) {
        System.out.println("<<viewOneInsured>> Just trying to get details of one the insured");
        return ApplicationUtil.getOneInsured(insuredId);
    }

    @Override
    public List<Insured> viewAllInsured() {
        System.out.println("<<viewAllInsured>> Just trying to get all insured information in this system");
        return ApplicationUtil.getAllTheInsured();
    }

    @Override
    public ClaimBenefits getBenefitDetailsForClaim(Integer claimEventId) {
        System.out.println("<<getBenefitDetailsForClaim>> Just trying to get benefit information for a claim");
        return ApplicationUtil.getBenefitDetailsForClaim(claimEventId);
    }

    @Override
    public List<ClaimBenefits> getAllBenefitAmountsForInsured(Integer insuredId) {
        System.out.println("<<getAllBenefitAmountsForInsured>> Just trying to get benefit information for all claims belonging to one insured");
        return null;
    }

    @Override
    public void addANewInsured(Insured insured) {
        System.out.println("<<addANewInsured>> Just trying to add a new insured in the system");
        ApplicationUtil.addInsuredToMap(insured);
    }
}
