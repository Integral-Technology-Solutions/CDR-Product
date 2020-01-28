package com.mahaswami.maventemplate.model;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import java.sql.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "BankingProduct")
public class BankingProduct {

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
    
    public Timestamp  getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Timestamp  effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Timestamp  getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(Timestamp  effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

	public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BankingProduct additionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public BankingProductAdditionalInformation getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getApplicationUri() {
        return applicationUri;
    }

    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    public Boolean getIsTailored() {
        return isTailored;
    }

    public void setIsTailored(Boolean isTailored) {
        this.isTailored = isTailored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProduct that = (BankingProduct) o;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "BankingProduct{" +
            "productId='" + productId + '\'' +
            ", additionalInformation=" + additionalInformation +
            ", productCategory=" + productCategory +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", brand='" + brand + '\'' +
            ", brandName='" + brandName + '\'' +
            ", applicationUri='" + applicationUri + '\'' +
            ", isTailored=" + isTailored +
            ", effectiveFrom=" + effectiveFrom +
            ", effectiveTo=" + effectiveTo +
            '}';
    }
}
