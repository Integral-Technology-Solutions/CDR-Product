package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import java.util.Objects;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Object that contains links to additional information on
 * specific topics
 */
@Entity
@Table(name = "BankingProductAdditionalInformation")
public class BankingProductAdditionalInformation {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String additionalInformationId;

    /**
     * General overview of the product
     */
	@Column(length=64)
    private String overviewUri;

    /**
     * Terms and conditions for the product
     */
	@Column(length=64)
    private String termsUri;

    /**
     * Eligibility rules and criteria for the product
     */
	@Column(length=64)
    private String eligibilityUri;

    /**
     * Description of fees, pricing, discounts, exemptions and
     * bonuses for the product
     */
	@Column(length=64)
    private String feesAndPricingUri;

    /**
     * Description of a bundle that this product can be part of
     */
	@Column(length=64)
    private String bundleUri;

    public String getAdditionalInformationId() {
        return additionalInformationId;
    }

    public void setAdditionalInformationId(String additionalInformationId) {
        this.additionalInformationId = additionalInformationId;
    }

    public String getOverviewUri() {
        return overviewUri;
    }

    public void setOverviewUri(String overviewUri) {
        this.overviewUri = overviewUri;
    }

    public String getTermsUri() {
        return termsUri;
    }

    public void setTermsUri(String termsUri) {
        this.termsUri = termsUri;
    }

    public String getEligibilityUri() {
        return eligibilityUri;
    }

    public void setEligibilityUri(String eligibilityUri) {
        this.eligibilityUri = eligibilityUri;
    }

    public String getFeesAndPricingUri() {
        return feesAndPricingUri;
    }

    public void setFeesAndPricingUri(String feesAndPricingUri) {
        this.feesAndPricingUri = feesAndPricingUri;
    }

    public String getBundleUri() {
        return bundleUri;
    }

    public void setBundleUri(String bundleUri) {
        this.bundleUri = bundleUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductAdditionalInformation that = (BankingProductAdditionalInformation) o;
        return Objects.equals(additionalInformationId, that.additionalInformationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInformationId);
    }

    @Override
    public String toString() {
        return "BankingProductAdditionalInformation{" +
            "additionalInformationId='" + additionalInformationId + '\'' +
            ", overviewUri=" + overviewUri +
            ", termsUri=" + termsUri +
            ", eligibilityUri=" + eligibilityUri +
            ", feesAndPricingUri=" + feesAndPricingUri +
            ", bundleUri=" + bundleUri +
            '}';
    }
}
