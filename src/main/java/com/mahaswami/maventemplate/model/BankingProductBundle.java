package com.mahaswami.maventemplate.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import java.util.*;

import javax.persistence.*;

@Entity
public class BankingProductBundle {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String bundleId;

    /**
     * Name of the bundle
     */
	@Column(length = 64)
    private String name;

    /**
     * Description of the bundle
     */
    @Column(length = 2048)
    private String description;

    /**
     * Display text providing more information on the bundle
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on the bundle
     * criteria and benefits
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "bundles")
    private Collection<BankingProductDetail> productDetail;

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

    public String getBundleId() {
		return bundleId;
	}

	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
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
        BankingProductBundle that = (BankingProductBundle) o;
        return Objects.equals(bundleId, that.bundleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bundleId);
    }

    @Override
    public String toString() {
        return "BankingProductBundle{" +
            "bundleId='" + bundleId + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            ", productDetail=" + productDetail +
            '}';
    }
}
