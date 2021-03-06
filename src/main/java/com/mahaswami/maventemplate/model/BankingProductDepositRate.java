package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductDepositRate {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String depositRateId;

    /**
     * The type of rate (base, bonus, etc). See the next section
     * for an overview of valid values and their meaning
     */
    private DepositRateType depositRateType;

    /**
     * The rate to be applied
     */
    private BigDecimal rate;

    /**
     * The period after which the rate is applied to the balance to
     * calculate the amount due for the period. Calculation of the
     * amount is often daily (as balances may change) but
     * accumulated until the total amount is 'applied' to the
     * account (see applicationFrequency). Formatted according to
     * [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String calculationFrequency;

    /**
     * The period after which the calculated amount(s) (see
     * calculationFrequency) are 'applied' (i.e. debited or
     * credited) to the account. Formatted according to [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String applicationFrequency;

    /**
     * Rate tiers applicable for this rate
     */
    @OneToMany(mappedBy = "depositRate")
    @Valid
    private List<BankingProductRateTier> tiers;

    /**
     * Generic field containing additional information relevant to
     * the depositRateType specified. Whether mandatory or not is
     * dependent on the value of depositRateType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the rate
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this rate
     */
    @Column(length=64)
    private String additionalInfoUri;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "bundles")
    private Collection<BankingProductDetail> productDetail;

    public String getDepositRateId() {
        return depositRateId;
    }

    public void setDepositRateId(String depositRateId) {
        this.depositRateId = depositRateId;
    }

    public DepositRateType getDepositRateType() {
        return depositRateType;
    }

    public void setDepositRateType(DepositRateType depositRateType) {
        this.depositRateType = depositRateType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCalculationFrequency() {
        return calculationFrequency;
    }

    public void setCalculationFrequency(String calculationFrequency) {
        this.calculationFrequency = calculationFrequency;
    }

    public String getApplicationFrequency() {
        return applicationFrequency;
    }

    public void setApplicationFrequency(String applicationFrequency) {
        this.applicationFrequency = applicationFrequency;
    }

    public List<BankingProductRateTier> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTier> tiers) {
        this.tiers = tiers;
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
        BankingProductDepositRate that = (BankingProductDepositRate) o;
        return Objects.equals(depositRateId, that.depositRateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depositRateId);
    }

    @Override
    public String toString() {
        return "BankingProductDepositRate{" +
                "depositRateId='" + depositRateId + '\'' +
                ", depositRateType=" + depositRateType +
                ", rate=" + rate +
                ", calculationFrequency='" + calculationFrequency + '\'' +
                ", applicationFrequency='" + applicationFrequency + '\'' +
                ", tiers=" + tiers +
                ", additionalValue='" + additionalValue + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", additionalInfoUri=" + additionalInfoUri +
                ", productDetail=" + productDetail +
                '}';
    }

    public enum DepositRateType {
        FIXED,
        BONUS,
        BUNDLE_BONUS,
        VARIABLE,
        INTRODUCTORY,
        FLOATING,
        MARKET_LINKED
    }
}
