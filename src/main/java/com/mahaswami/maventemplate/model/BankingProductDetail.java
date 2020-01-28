package com.mahaswami.maventemplate.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import java.sql.*;
import java.util.*;

@Entity
@Table(name = "BankingProduct")
public class BankingProductDetail {

    /**
     * A provider specific unique identifier for this product. This
     * identifier must be unique to a product but does not
     * otherwise need to adhere to ID permanence guidelines.
     */
    @Id
    private String productId;

    @OneToOne(cascade = CascadeType.ALL)
    private BankingProductAdditionalInformation additionalInformation;

    private BankingProductCategory productCategory;

    /**
     * The display name of the product
     */
    @Column(length = 64)
    private String name;

    /**
     * A description of the product
     */
    @Column(length = 2048)
    private String description;

    /**
     * A label of the brand for the product. Able to be used for
     * filtering. For data providers with single brands this value
     * is still required
     */
    @Column(length = 64)
    private String brand;

    /**
     * An optional display name of the brand
     */
    @Column(length = 64)
    private String brandName;

    /**
     * A link to an application web page where this product can be
     * applied for.
     */
    @Column(length = 64)
    private String applicationUri;
    
    @DefaultValueCalculator(CurrentTimestampCalculator.class)
    private Timestamp  effectiveFrom;
    
    @DefaultValueCalculator(CurrentTimestampCalculator.class)
    private Timestamp  effectiveTo;

    /**
     * Indicates whether the product is specifically tailored to a
     * circumstance.  In this case fees and prices are
     * significantly negotiated depending on context. While all
     * products are open to a degree of tailoring this flag
     * indicates that tailoring is expected and thus that the
     * provision of specific fees and rates is not applicable
     */

    private Boolean isTailored;

    @DefaultValueCalculator(CurrentTimestampCalculator.class)
    @Hidden
    private Timestamp lastUpdated;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_bundles",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "bundle_id"))
    @ManyToMany
    private Collection<BankingProductBundle> bundles;

    @ManyToMany
    private Collection<BankingProductFeature> features;

    @ManyToMany
    private Collection<BankingProductConstraint> constraints;

    @ManyToMany
    private Collection<BankingProductFee> fees;

    @ManyToMany
    private Collection<BankingProductEligibility> eligibility;

    @ManyToMany
    private Collection<BankingProductDepositRate> depositRates;

    @ManyToMany
    private Collection<BankingProductLendingRate> lendingRates;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_constraints",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "constraint_id"))
//    @ManyToMany
//    private Collection<BankingProductConstraint> constraints = null;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_deposit_rates",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "deposit_rate_id"))
//    @Valid
//    private List<BankingProductDepositRate> depositRates = null;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_eligibility",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "eligibility_id"))
//    @Valid
//    private List<BankingProductEligibility> eligibility = null;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_features",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "feature_id"))
//    @Valid
//    private List<BankingProductFeature> features = null;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_fees",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "fee_id"))
//    @Valid
//    private List<BankingProductFee> fees = null;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "product_lending_rates",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "lending_rate_id"))
//    @Valid
//    private List<BankingProductLendingRate> lendingRates = null;

    public BankingProductDetail additionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @Valid
    public BankingProductAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public BankingProductDetail applicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
        return this;
    }

    /**
     * A link to the an application web page where this product can be applied for.
     *
     * @return applicationUri
     */
    public String getApplicationUri() {
        return applicationUri;
    }

    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    public BankingProductDetail brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required
     *
     * @return brand
     */
    @NotNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BankingProductDetail brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    /**
     * An optional display name of the brand
     *
     * @return brandName
     */
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BankingProductDetail description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the product
     *
     * @return description
     */
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankingProductDetail effectiveFrom(Timestamp effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    /**
     * The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    @Valid
    public Timestamp getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Timestamp effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public BankingProductDetail effectiveTo(Timestamp effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
    }

    /**
     * The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products
     *
     * @return effectiveTo
     */
    @Valid
    public Timestamp getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(Timestamp effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public BankingProductDetail isTailored(Boolean isTailored) {
        this.isTailored = isTailored;
        return this;
    }

    /**
     * Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable
     *
     * @return isTailored
     */
    @NotNull
    public Boolean getIsTailored() {
        return isTailored;
    }

    public void setIsTailored(Boolean isTailored) {
        this.isTailored = isTailored;
    }

    public BankingProductDetail lastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)
     *
     * @return lastUpdated
     */
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BankingProductDetail name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name of the product
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankingProductDetail productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    /**
     * Get productCategory
     *
     * @return productCategory
     */
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public BankingProductDetail productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.
     *
     * @return productId
     */
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    /**
     * An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also
     *
     * @return bundles
     */
//    @Valid
    public Collection<BankingProductBundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
    }

    public Collection<BankingProductFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<BankingProductFeature> features) {
        this.features = features;
    }

    public Collection<BankingProductConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(Collection<BankingProductConstraint> constraints) {
        this.constraints = constraints;
    }

    public Collection<BankingProductFee> getFees() {
        return fees;
    }

    public void setFees(Collection<BankingProductFee> fees) {
        this.fees = fees;
    }

    public Collection<BankingProductEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(Collection<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    public Collection<BankingProductDepositRate> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(Collection<BankingProductDepositRate> depositRates) {
        this.depositRates = depositRates;
    }

    public Collection<BankingProductLendingRate> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(Collection<BankingProductLendingRate> lendingRates) {
        this.lendingRates = lendingRates;
    }

    //    public BankingProductDetail constraints(List<BankingProductConstraint> constraints) {
//        this.constraints = constraints;
//        return this;
//    }

//    public BankingProductDetail addConstraintsItem(BankingProductConstraint constraintsItem) {
//        if (this.constraints == null) {
//            this.constraints = new ArrayList<>();
//        }
//        this.constraints.add(constraintsItem);
//        return this;
//    }

    /**
     * Constraints on the application for or operation of the product such as minimum balances or limit thresholds
     *
     * @return constraints
     */
//    @Valid
//    public List<BankingProductConstraint> getConstraints() {
//        return constraints;
//    }
//
//    public void setConstraints(List<BankingProductConstraint> constraints) {
//        this.constraints = constraints;
//    }

//    public BankingProductDetail depositRates(List<BankingProductDepositRate> depositRates) {
//        this.depositRates = depositRates;
//        return this;
//    }
//
//    public BankingProductDetail addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
//        if (this.depositRates == null) {
//            this.depositRates = new ArrayList<>();
//        }
//        this.depositRates.add(depositRatesItem);
//        return this;
//    }

//    /**
//     * Interest rates available for deposits
//     *
//     * @return depositRates
//     */
//    @Valid
//    public List<BankingProductDepositRate> getDepositRates() {
//        return depositRates;
//    }
//
//    public void setDepositRates(List<BankingProductDepositRate> depositRates) {
//        this.depositRates = depositRates;
//    }
//
//    public BankingProductDetail eligibility(List<BankingProductEligibility> eligibility) {
//        this.eligibility = eligibility;
//        return this;
//    }
//
//    public BankingProductDetail addEligibilityItem(BankingProductEligibility eligibilityItem) {
//        if (this.eligibility == null) {
//            this.eligibility = new ArrayList<>();
//        }
//        this.eligibility.add(eligibilityItem);
//        return this;
//    }
//
//    /**
//     * Eligibility criteria for the product
//     *
//     * @return eligibility
//     */
//    @Valid
//    public List<BankingProductEligibility> getEligibility() {
//        return eligibility;
//    }
//
//    public void setEligibility(List<BankingProductEligibility> eligibility) {
//        this.eligibility = eligibility;
//    }
//
//    public BankingProductDetail features(List<BankingProductFeature> features) {
//        this.features = features;
//        return this;
//    }
//
//    public BankingProductDetail addFeaturesItem(BankingProductFeature featuresItem) {
//        if (this.features == null) {
//            this.features = new ArrayList<>();
//        }
//        this.features.add(featuresItem);
//        return this;
//    }
//
//    /**
//     * Array of features available for the product
//     *
//     * @return features
//     */
//    @Valid
//    public List<BankingProductFeature> getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(List<BankingProductFeature> features) {
//        this.features = features;
//    }
//
//    public BankingProductDetail fees(List<BankingProductFee> fees) {
//        this.fees = fees;
//        return this;
//    }
//
//    public BankingProductDetail addFeesItem(BankingProductFee feesItem) {
//        if (this.fees == null) {
//            this.fees = new ArrayList<>();
//        }
//        this.fees.add(feesItem);
//        return this;
//    }
//
//    /**
//     * Fees applicable for the product
//     *
//     * @return fees
//     */
//    @Valid
//    public List<BankingProductFee> getFees() {
//        return fees;
//    }
//
//    public void setFees(List<BankingProductFee> fees) {
//        this.fees = fees;
//    }

//    public BankingProductDetail lendingRates(List<BankingProductLendingRate> lendingRates) {
//        this.lendingRates = lendingRates;
//        return this;
//    }
//
//    public BankingProductDetail addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
//        if (this.lendingRates == null) {
//            this.lendingRates = new ArrayList<>();
//        }
//        this.lendingRates.add(lendingRatesItem);
//        return this;
//    }

//    /**
//     * Interest rates charged against lending balances
//     *
//     * @return lendingRates
//     */
//    @Valid
//    public List<BankingProductLendingRate> getLendingRates() {
//        return lendingRates;
//    }
//
//    public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
//        this.lendingRates = lendingRates;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductDetail that = (BankingProductDetail) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "BankingProductDetail{" +
            "productId='" + productId + '\'' +
            ", additionalInformation=" + additionalInformation +
            ", applicationUri='" + applicationUri + '\'' +
            ", brand='" + brand + '\'' +
            ", brandName='" + brandName + '\'' +
            ", description='" + description + '\'' +
            ", effectiveFrom=" + effectiveFrom +
            ", effectiveTo=" + effectiveTo +
            ", isTailored=" + isTailored +
            ", lastUpdated=" + lastUpdated +
            ", name='" + name + '\'' +
            ", productCategory=" + productCategory +
            ", bundles=" + bundles +
            ", constraints=" + constraints +
            ", depositRates=" + depositRates +
            ", eligibility=" + eligibility +
            ", features=" + features +
            ", fees=" + fees +
            ", lendingRates=" + lendingRates +
            '}';
    }
}

