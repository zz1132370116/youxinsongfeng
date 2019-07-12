package com.zl.dc.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/10 13:37
 * @Description:
 */
@Entity
@Data
@ToString
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "companyId", nullable = false)
    private int companyId;
    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;
    @Column(name = "company_address", nullable = false, length = 100)
    private String companyAddress;
    @Column(name = "company_document", nullable = false, length = 100)
    private String companyDocument;
    @Column(name = "other_documents", nullable = false, length = 100)
    private String otherDocuments;
    @Column(name = "corporate", nullable = false, length = 100)
    private String corporate;
    @Column(name = "operator_name", nullable = false, length = 100)
    private String operatorName;
    @Column(name = "operator_position", nullable = false, length = 100)
    private String operatorPosition;
    @Column(name = "operator_phone", nullable = false, length = 100)
    private String operatorPhone;
    @Column(name = "authorization", nullable = false, length = 100)
    private String authorization;
    @Transient
    private List<Commodity> commodities;





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
        return Objects.hash(companyId, companyName, companyAddress, companyDocument, otherDocuments, corporate, operatorName, operatorPosition, operatorPhone, authorization);
    }
}
