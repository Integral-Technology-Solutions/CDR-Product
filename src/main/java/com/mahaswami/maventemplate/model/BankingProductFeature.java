package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class BankingProductFeature {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String featureId;

    /**
     * The type of feature described
     */
    private FeatureType featureType;

    /**
     * Generic field containing additional information relevant to
     * the featureType specified. Whether mandatory or not is
     * dependent on the value of featureType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the feature.
     * Mandatory if the feature type is set to OTHER
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this feature
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "features")
    private Collection<BankingProductDetail> productDetail;

    public Collection<BankingProductDetail> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Collection<BankingProductDetail> productDetail) {
        this.productDetail = productDetail;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
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
        BankingProductFeature that = (BankingProductFeature) o;
        return Objects.equals(featureId, that.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId);
    }

    @Override
    public String toString() {
        return "BankingProductFeature{" +
            "featureId='" + featureId + '\'' +
            ", featureType=" + featureType +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
                ", productDetail=" + productDetail +
            '}';
    }

    public enum FeatureType {
        CARD_ACCESS,
        ADDITIONAL_CARDS,
        UNLIMITED_TXNS,
        FREE_TXNS,
        FREE_TXNS_ALLOWANCE,
        LOYALTY_PROGRAM,
        OFFSET,
        OVERDRAFT,
        REDRAW,
        INSURANCE,
        BALANCE_TRANSFERS,
        INTEREST_FREE,
        INTEREST_FREE_TRANSFERS,
        DIGITAL_WALLET,
        DIGITAL_BANKING,
        NPP_PAYID,
        NPP_ENABLED,
        DONATE_INTEREST,
        BILL_PAYMENT,
        COMPLEMENTARY_PRODUCT_DISCOUNTS,
        BONUS_REWARDS,
        NOTIFICATIONS,
        OTHER
    }
}
