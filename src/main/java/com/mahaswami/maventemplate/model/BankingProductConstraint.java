package com.mahaswami.maventemplate.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

@Entity
public class BankingProductConstraint {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String constraintId;

    /**
     * The type of constraint described. See the next section for
     * an overview of valid values and their meaning
     */
    private ConstraintType constraintType;

    /**
     * Generic field containing additional information relevant to
     * the constraintType specified. Whether mandatory or not is
     * dependent on the value of constraintType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information the constraint
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on the constraint
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "constraints")
    private Collection<BankingProductDetail> productDetail;
    
    public String getConstraintId() {
		return constraintId;
	}

	public void setConstraintId(String constraintId) {
		this.constraintId = constraintId;
	}

    public Collection<BankingProductDetail> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Collection<BankingProductDetail> productDetail) {
        this.productDetail = productDetail;
    }

    public ConstraintType getConstraintType() {
        return constraintType;
    }

    public void setConstraintType(ConstraintType constraintType) {
        this.constraintType = constraintType;
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
        BankingProductConstraint that = (BankingProductConstraint) o;
        return Objects.equals(constraintId, that.constraintId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constraintId);
    }

    @Override
    public String toString() {
        return "BankingProductConstraint{" +
                "productConstraintId='" + constraintId + '\'' +
                ", constraintType=" + constraintType +
                ", additionalValue='" + additionalValue + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", additionalInfoUri=" + additionalInfoUri +
                ", productDetail=" + productDetail +
                '}';
    }

    public enum ConstraintType {
        MIN_BALANCE,
        MAX_BALANCE,
        OPENING_BALANCE,
        MAX_LIMIT,
        MIN_LIMIT
    }
}
