package com.kingshuk.spring.aspectpractice.aop.aroundadvice.beans;

/**A simple to store the benefit information
 * Created by CO21321 on 2/12/2018.
 */
public class ClaimBenefits {

    private Integer claimEventId;

    private Double benefitAmount;

    private String benefitStatus;

    public Integer getClaimEventId() {
        return claimEventId;
    }

    public void setClaimEventId(Integer claimEventId) {
        this.claimEventId = claimEventId;
    }

    public Double getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(Double benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getBenefitStatus() {
        return benefitStatus;
    }

    public void setBenefitStatus(String benefitStatus) {
        this.benefitStatus = benefitStatus;
    }
}
