package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import java.util.*;

import javax.persistence.*;

@Entity
public class BankingProductDiscountEligibility {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String discountEligibilityId;

    /**
     * The type of the specific eligibility constraint for a
     * discount
     */
    private DiscountEligibilityType discountEligibilityType;

    /**
     * Generic field containing additional information relevant to
     * the discountEligibilityType specified. Whether mandatory or
     * not is dependent on the value of discountEligibilityType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on this eligibility
     * constraint
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this eligibility
     * constraint
     */
    @Column(length = 64)
    private String additionalInfoUri;
    
    @ManyToMany(mappedBy = "eligibility")
    private Collection<BankingProductDiscount> discount;
    
    public Collection<BankingProductDiscount> getDiscount() {
		return discount;
	}

	public void setDiscount(Collection<BankingProductDiscount> discount) {
		this.discount = discount;
	}

	public String getDiscountEligibilityId() {
        return discountEligibilityId;
    }

    public void setDiscountEligibilityId(String discountEligibilityId) {
        this.discountEligibilityId = discountEligibilityId;
    }

    public DiscountEligibilityType getDiscountEligibilityType() {
        return discountEligibilityType;
    }

    public void setDiscountEligibilityType(DiscountEligibilityType discountEligibilityType) {
        this.discountEligibilityType = discountEligibilityType;
    }

    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductDiscountEligibility that = (BankingProductDiscountEligibility) o;
        return Objects.equals(discountEligibilityId, that.discountEligibilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountEligibilityId);
    }

    @Override
    public String toString() {
        return "BankingProductDiscountEligibility{" +
            "discountEligibilityId='" + discountEligibilityId + '\'' +
            ", discountEligibilityType=" + discountEligibilityType +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            '}';
    }


    public enum DiscountEligibilityType {
        BUSINESS,
        PENSION_RECIPIENT,
        MIN_AGE,
        MAX_AGE,
        MIN_INCOME,
        MIN_TURNOVER,
        STAFF,
        STUDENT,
        EMPLOYMENT_STATUS,
        RESIDENCY_STATUS,
        NATURAL_PERSON,
        INTRODUCTORY,
        OTHER
    }
}
