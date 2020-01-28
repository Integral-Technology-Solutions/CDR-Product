package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class BankingProductEligibility {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String eligibilityId;

    /**
     * The type of eligibility criteria described. See the next
     * section for an overview of valid values and their meaning
     */
    private EligibilityType eligibilityType;

    /**
     * Generic field containing additional information relevant to
     * the eligibilityType specified. Whether mandatory or not is
     * dependent on the value of eligibilityType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the eligibility
     * criteria. Mandatory if the eligibilityType field is set to
     * OTHER
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this eligibility
     * criteria
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "eligibility")
    private Collection<BankingProductDetail> productDetail;

    public String getEligibilityId() {
        return eligibilityId;
    }

    public void setEligibilityId(String eligibilityId) {
        this.eligibilityId = eligibilityId;
    }

    public EligibilityType getEligibilityType() {
        return eligibilityType;
    }

    public void setEligibilityType(EligibilityType eligibilityType) {
        this.eligibilityType = eligibilityType;
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

    public Collection<BankingProductDetail> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Collection<BankingProductDetail> productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductEligibility that = (BankingProductEligibility) o;
        return Objects.equals(eligibilityId, that.eligibilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligibilityId);
    }

    @Override
    public String toString() {
        return "BankingProductEligibility{" +
            "eligibilityId='" + eligibilityId + '\'' +
            ", eligibilityType=" + eligibilityType +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
                ", productDetail=" + productDetail +
            '}';
    }

    public enum EligibilityType {
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
        OTHER
    }
}
