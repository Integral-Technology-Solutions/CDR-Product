package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class BankingProductFee {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String feeId;

    /**
     * Name of the fee
     */
    private String name;

    /**
     * The type of fee
     */
    private FeeType feeType;

    /**
     * The amount charged for the fee. One of amount, balanceRate,
     * transactionRate and accruedRate is mandatory
     */
    private BigDecimal amount;

    /**
     * A fee rate calculated based on a proportion of the balance.
     * One of amount, balanceRate, transactionRate and accruedRate
     * is mandatory
     */
    private BigDecimal balanceRate;

    /**
     * A fee rate calculated based on a proportion of a
     * transaction. One of amount, balanceRate, transactionRate and
     * accruedRate is mandatory
     */
    private BigDecimal transactionRate;

    /**
     * A fee rate calculated based on a proportion of the
     * calculated interest accrued on the account. One of amount,
     * balanceRate, transactionRate and accruedRate is mandatory
     */
    private BigDecimal accruedRate;

    /**
     * The indicative frequency with which the fee is calculated on
     * the account. Only applies if balanceRate or accruedRate is
     * also present. Formatted according to [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String accrualFrequency;

    /**
     * The currency the fee will be charged in. Assumes AUD if
     * absent
     */
    private String currency;

    /**
     * Generic field containing additional information relevant to
     * the feeType specified. Whether mandatory or not is dependent
     * on the value of feeType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the fee
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this fee
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * An optional list of discounts to this fee that may be
     * available
     */
    @ManyToMany
    private Collection<BankingProductDiscount> discount;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "bundles")
    private Collection<BankingProductDetail> productDetail;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
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

    public String getAccrualFrequency() {
        return accrualFrequency;
    }

    public void setAccrualFrequency(String accrualFrequency) {
        this.accrualFrequency = accrualFrequency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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



    public Collection<BankingProductDiscount> getDiscount() {
		return discount;
	}

	public void setDiscount(Collection<BankingProductDiscount> discount) {
		this.discount = discount;
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
        BankingProductFee that = (BankingProductFee) o;
        return Objects.equals(feeId, that.feeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feeId);
    }

    @Override
    public String toString() {
        return "BankingProductFee{" +
            "feeId='" + feeId + '\'' +
            ", name='" + name + '\'' +
            ", feeType=" + feeType +
            ", amount=" + amount +
            ", balanceRate=" + balanceRate +
            ", transactionRate=" + transactionRate +
            ", accruedRate=" + accruedRate +
            ", accrualFrequency='" + accrualFrequency + '\'' +
            ", currency='" + currency + '\'' +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            ", discount=" + discount +
                ", productDetail=" + productDetail +
            '}';
    }

    public enum FeeType {
        PERIODIC,
        TRANSACTION, WITHDRAWAL,
        DEPOSIT,
        PAYMENT,
        PURCHASE,
        EVENT,
        UPFRONT,
        EXIT
    }
}
