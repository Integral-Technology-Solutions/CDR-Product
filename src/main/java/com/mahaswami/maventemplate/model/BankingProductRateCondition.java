package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Defines a condition for the applicability of a tiered rate
 */
@Entity
public class BankingProductRateCondition {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String rateConditionId;

    /**
     * // Display text providing more information on the condition
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this condition
     */
    @Column(length = 64)
    private String additionalInfoUri;

    public String getRateConditionId() {
        return rateConditionId;
    }

    public void setRateConditionId(String rateConditionId) {
        this.rateConditionId = rateConditionId;
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
        BankingProductRateCondition that = (BankingProductRateCondition) o;
        return Objects.equals(rateConditionId, that.rateConditionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateConditionId);
    }

    @Override
    public String toString() {
        return "BankingProductRateCondition{" +
            "rateConditionId='" + rateConditionId + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            '}';
    }
}
