package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Defines the criteria and conditions for which a rate applies
 */
@Entity
public class BankingProductRateTier {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String rateTierId;

    /**
     * A display name for the tier
     */
    private String name;

    /**
     * The unit of measure that applies to the tierValueMinimum and
     * tierValueMaximum values e.g. 'DOLLAR', 'MONTH' (in the case
     * of term deposit tiers), 'PERCENT' (in the case of
     * loan-to-value ratio or LVR)
     */
    private UnitOfMeasure unitOfMeasure;

    /**
     * The number of tierUnitOfMeasure units that form the lower
     * bound of the tier. The tier should be inclusive of this
     * value
     */
    private BigDecimal minimumValue;

    /**
     * The number of tierUnitOfMeasure units that form the upper
     * bound of the tier or band. For a tier with a discrete value
     * (as opposed to a range of values e.g. 1 month) this must be
     * the same as tierValueMinimum. Where this is the same as the
     * tierValueMinimum value of the next-higher tier the
     * referenced tier should be exclusive of this value. For
     * example a term deposit of 2 months falls into the upper tier
     * of the following tiers: (1 – 2 months, 2 – 3 months). If
     * absent the tier's range has no upper bound.
     */
    private BigDecimal maximumValue;

    /**
     * The method used to calculate the amount to be applied using
     * one or more tiers. A single rate may be applied to the
     * entire balance or each applicable tier rate is applied to
     * the portion of the balance that falls into that tier
     * (referred to as 'bands' or 'steps')
     */
    private RateApplicationMethod rateApplicationMethod;

    @ManyToOne(cascade = CascadeType.ALL)
    private BankingProductRateCondition applicabilityConditions;

    @ManyToOne(cascade = CascadeType.ALL)
    private BankingProductRateTierSubTier subTier;

    @ManyToOne
    private BankingProductDepositRate depositRate;

    @ManyToOne
    private BankingProductLendingRate lendingRate;

    public String getRateTierId() {
        return rateTierId;
    }

    public BankingProductDepositRate getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(BankingProductDepositRate depositRate) {
        this.depositRate = depositRate;
    }

    public BankingProductLendingRate getLendingRate() {
        return lendingRate;
    }

    public void setLendingRate(BankingProductLendingRate lendingRate) {
        this.lendingRate = lendingRate;
    }

    public void setRateTierId(String rateTierId) {
        this.rateTierId = rateTierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(BigDecimal minimumValue) {
        this.minimumValue = minimumValue;
    }

    public BigDecimal getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(BigDecimal maximumValue) {
        this.maximumValue = maximumValue;
    }

    public RateApplicationMethod getRateApplicationMethod() {
        return rateApplicationMethod;
    }

    public void setRateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
        this.rateApplicationMethod = rateApplicationMethod;
    }

    public BankingProductRateCondition getApplicabilityConditions() {
        return applicabilityConditions;
    }

    public void setApplicabilityConditions(BankingProductRateCondition applicabilityConditions) {
        this.applicabilityConditions = applicabilityConditions;
    }

    public BankingProductRateTierSubTier getSubTier() {
        return subTier;
    }

    public void setSubTier(BankingProductRateTierSubTier subTier) {
        this.subTier = subTier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductRateTier that = (BankingProductRateTier) o;
        return Objects.equals(rateTierId, that.rateTierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateTierId);
    }

    @Override
    public String toString() {
        return "BankingProductRateTier{" +
            "rateTierId='" + rateTierId + '\'' +
            ", name='" + name + '\'' +
            ", unitOfMeasure=" + unitOfMeasure +
            ", minimumValue=" + minimumValue +
            ", maximumValue=" + maximumValue +
            ", rateApplicationMethod=" + rateApplicationMethod +
            ", applicabilityConditions=" + applicabilityConditions +
            ", subTier=" + subTier +
            ", depositRate=" + depositRate +
            ", lendingRate=" + lendingRate +
            '}';
    }

    public enum RateApplicationMethod {
        WHOLE_BALANCE,
        PER_TIER
    }

    public enum UnitOfMeasure {
        DOLLAR,
        PERCENT,
        MONTH,
        DAY;
    }
}
