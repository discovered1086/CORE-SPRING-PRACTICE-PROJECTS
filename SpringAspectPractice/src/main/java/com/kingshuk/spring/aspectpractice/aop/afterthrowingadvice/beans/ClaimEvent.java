package com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.beans;

import java.util.Date;

/** Just a bean to hold the claims information
 * Created by CO21321 on 2/12/2018.
 */
public class ClaimEvent {

    private Integer claimEventId;

    private Insured insured;

    private String claimType;

    private Date claimRaisedDate;

    private String claimStatus;

    private ClaimBenefits benefits;

    public Integer getClaimEventId() {
        return claimEventId;
    }

    public void setClaimEventId(Integer claimEventId) {
        this.claimEventId = claimEventId;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public Date getClaimRaisedDate() {
        return claimRaisedDate;
    }

    public void setClaimRaisedDate(Date claimRaisedDate) {
        this.claimRaisedDate = claimRaisedDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public ClaimBenefits getBenefits() {
        return benefits;
    }

    public void setBenefits(ClaimBenefits benefits) {
        this.benefits = benefits;
    }

    @Override
    public String toString() {
        return "ClaimEvent{" +
                "claimEventId=" + claimEventId +
                ", insured=" + insured +
                ", claimType='" + claimType + '\'' +
                ", claimRaisedDate=" + claimRaisedDate +
                ", claimStatus='" + claimStatus + '\'' +
                '}';
    }
}
