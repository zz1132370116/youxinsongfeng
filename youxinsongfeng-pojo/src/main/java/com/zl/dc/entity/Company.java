package com.zl.dc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/10 13:37
 * @Description:
 */
@Entity
@Data
@Table(name = "company")
public class Company {
    @Id
    private int companyId;
    private String companyName;
    private int cityId;
    private String companyAddress;
    private String companyDocument;
    private String otherDocuments;
    private String corporate;
    private String operatorName;
    private String operatorPosition;
    private String operatorPhone;
    private String authorization;

    @Id
    @Column(name = "companyId", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name", nullable = false, length = 100)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "cityId", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "company_address", nullable = false, length = 100)
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Basic
    @Column(name = "company_document", nullable = false, length = 100)
    public String getCompanyDocument() {
        return companyDocument;
    }

    public void setCompanyDocument(String companyDocument) {
        this.companyDocument = companyDocument;
    }

    @Basic
    @Column(name = "other_documents", nullable = false, length = 100)
    public String getOtherDocuments() {
        return otherDocuments;
    }

    public void setOtherDocuments(String otherDocuments) {
        this.otherDocuments = otherDocuments;
    }

    @Basic
    @Column(name = "corporate", nullable = false, length = 100)
    public String getCorporate() {
        return corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate;
    }

    @Basic
    @Column(name = "operator_name", nullable = false, length = 100)
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Basic
    @Column(name = "operator_position", nullable = false, length = 100)
    public String getOperatorPosition() {
        return operatorPosition;
    }

    public void setOperatorPosition(String operatorPosition) {
        this.operatorPosition = operatorPosition;
    }

    @Basic
    @Column(name = "operator_phone", nullable = false, length = 100)
    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    @Basic
    @Column(name = "authorization", nullable = false, length = 100)
    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Company company = (Company) o;
        return companyId == company.companyId &&
                cityId == company.cityId &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(companyAddress, company.companyAddress) &&
                Objects.equals(companyDocument, company.companyDocument) &&
                Objects.equals(otherDocuments, company.otherDocuments) &&
                Objects.equals(corporate, company.corporate) &&
                Objects.equals(operatorName, company.operatorName) &&
                Objects.equals(operatorPosition, company.operatorPosition) &&
                Objects.equals(operatorPhone, company.operatorPhone) &&
                Objects.equals(authorization, company.authorization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, cityId, companyAddress, companyDocument, otherDocuments, corporate, operatorName, operatorPosition, operatorPhone, authorization);
    }
}
