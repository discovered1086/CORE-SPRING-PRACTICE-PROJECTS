package com.kingshuk.spring.aspectpractice.aop.aroundadvice.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingshuk.spring.aspectpractice.aop.aroundadvice.beans.ClaimBenefits;
import com.kingshuk.spring.aspectpractice.aop.aroundadvice.beans.ClaimEvent;
import com.kingshuk.spring.aspectpractice.aop.aroundadvice.beans.Insured;

/**
 * An utility class for the dummy data stores and stuff
 * Created by CO21321 on 2/13/2018.
 */
public class ApplicationUtil {
    private static final Map<Integer, ClaimEvent> claimsMap = new HashMap<>();
    private static final Map<Integer, Insured> insuredMap = new HashMap<>();

    public static synchronized void addClaimsToMap(ClaimEvent claimEvent) {
        claimsMap.put(claimEvent.getClaimEventId(), claimEvent);
    }

    public static synchronized ClaimEvent getOneClaim(Integer claimEventId) {
        return claimsMap.get(claimEventId);
    }

    public static synchronized List<ClaimEvent> getAllTheClaims() {
        List<ClaimEvent> claimsList = new ArrayList<>();

        for (ClaimEvent claimEvent : claimsMap.values()) {
            claimsList.add(claimEvent);
        }

        return claimsList;
    }


    public static synchronized List<ClaimEvent> getAllClaimsForInsured(Integer insuredId) {
        List<ClaimEvent> claimsList = new ArrayList<>();

        for (ClaimEvent claimEvent : claimsMap.values()) {
            if (insuredId.equals(claimEvent.getInsured().getInsuredId()))
                claimsList.add(claimEvent);
        }

        return claimsList;
    }

    public static synchronized void addInsuredToMap(Insured insured) {
        insuredMap.put(insured.getInsuredId(), insured);
    }

    public static synchronized Insured getOneInsured(Integer insuredId) {
        return insuredMap.get(insuredId);
    }

    public static synchronized List<Insured> getAllTheInsured() {
        List<Insured> insuredList = new ArrayList<>();

        for (Insured insured : insuredMap.values()) {
            insuredList.add(insured);
        }

        return insuredList;
    }

    public static synchronized ClaimBenefits getBenefitDetailsForClaim(Integer claimEventId) {
        return claimsMap.get(claimEventId).getBenefits();
    }
}
