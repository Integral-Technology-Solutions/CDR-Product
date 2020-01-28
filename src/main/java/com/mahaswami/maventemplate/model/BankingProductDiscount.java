package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class BankingProductDiscount {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String discountId;

    /**
     * Description of the discount
     */
    @Column(length = 2048)
    private String description;

    /**
     * The type of discount. See the next section for an overview
     * of valid values and their meaning
     */
    private DiscountType discountType;

    /**
     * Value of the discount
     */
    private BigDecimal amount;

    /**
     * A discount rate calculated based on a proportion of the
     * balance. Note that the currency of the fee discount is
     * expected to be the same as the currency of the fee itself.
     * One of amount, balanceRate, transactionRate, accruedRate and
     * feeRate is mandatory. Unless noted in additionalInfo,
     * assumes the application and calculation frequency are the
     * same as the corresponding fee
     */
    private BigDecimal balanceRate;

    /**
     * A discount rate calculated based on a proportion of a
     * transaction. Note that the currency of the fee discount is
     * expected to be the same as the currency of the fee itself.
     * One of amount, balanceRate, transactionRate, accruedRate and
     * feeRate is mandatory
     */
    private BigDecimal transactionRate;

    /**
     * A discount rate calculated based on a proportion of the
     * calculated interest accrued on the account. Note that the
     * currency of the fee discount is expected to be the same as
     * the currency of the fee itself. One of amount, balanceRate,
     * transactionRate, accruedRate and feeRate is mandatory.
     * Unless noted in additionalInfo, assumes the application and
     * calculation frequency are the same as the corresponding fee
     */
    private BigDecimal accruedRate;

    /**
     * A discount rate calculated based on a proportion of the fee
     * to which this discount is attached. Note that the currency
     * of the fee discount is expected to be the same as the
     * currency of the fee itself. One of amount, balanceRate,
     * transactionRate, accruedRate and feeRate is mandatory.
     * Unless noted in additionalInfo, assumes the application and
     * calculation frequency are the same as the corresponding fee
     */
    private BigDecimal feeRate;

    /**
     * Generic field containing additional information relevant to
     * the discountType specified. Whether mandatory or not is
     * dependent on the value of discountType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the discount
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this discount
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * Eligibility constraints that apply to this discount
     */
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_discount_eligibility",
//        joinColumns = @JoinColumn(name = "product_discount_id"),
//        inverseJoinColumns = @JoinColumn(name = "discount_eligibility_id"))
    @ManyToMany
    private Collection<BankingProductDiscountEligibility> eligibility;
    
    @ManyToMany(mappedBy = "discount")
    private Collection<BankingProductFee> fee;

    
    
    public Collection<BankingProductFee> getFee() {
		return fee;
	}

	public void setFee(Collection<BankingProductFee> fee) {
		this.fee = fee;
	}

	public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceRate() {
        return balanceRate;
    }

    public void setBalanceRate(BigDecimal balanceRate) {
        this.balanceRate = balanceRate;
    }

    public BigDecimal getTransactionRate() {
        return transactionRate;
    }

    public void setTransactionRate(BigDecimal transactionRate) {
        this.transactionRate = transactionRate;
    }

    public BigDecimal getAccruedRate() {
        return accruedRate;
    }

    public void setAccruedRate(BigDecimal accruedRate) {
        this.accruedRate = accruedRate;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
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

    public Collection<BankingProductDiscountEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(Collection<BankingProductDiscountEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductDiscount that = (BankingProductDiscount) o;
        return Objects.equals(discountId, that.discountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId);
    }

    @Override
    public String toString() {
        return "BankingProductDiscount{" +
            "discountId='" + discountId + '\'' +
            ", description='" + description + '\'' +
            ", discountType=" + discountType +
            ", amount=" + amount +
            ", balanceRate=" + balanceRate +
            ", transactionRate=" + transactionRate +
            ", accruedRate=" + accruedRate +
            ", feeRate=" + feeRate +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            ", eligibility=" + eligibility +
            '}';
    }

    public enum DiscountType {
        BALANCE,
        DEPOSITS,
        PAYMENTS,
        FEE_CAP,
        ELIGIBILITY_ONLY
    }
}
