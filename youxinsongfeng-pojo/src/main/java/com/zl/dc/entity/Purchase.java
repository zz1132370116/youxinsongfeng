package com.zl.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/16 10:05
 * @Description:
 */
@Table(name = "purchase")
public class Purchase {
    @Id
    @Column(name = "PurchaseId")
    private String purchaseId;
    @Column(name = "Purchase_Title")
    private String purchaseTitle;
    @Column(name="product_name")
    private String productName;
    @Column(name = "Origin_requirements")
    private String originRequirements;
    @Column(name = "Specification_type")
    private String specificationType;
    @Column(name = "LEVEL")
    private String level;
    @Column(name = "Warehouse")
    private String warehouse;
    @Column(name = "Goods_in_stock")
    private String purchaseSport;
    @Column(name = "Price")
    private String purchasePrice;
    @Column(name = "Procurement_Notes")
    private String procurementNotes;
    @Column(name = "Payment_method")
    private String paymentMethod;
    @Column(name = "Invoice_type")
    private String invoiceType;
    @Column(name = "Receiving_address")
    private String receivingAddress;
    @Column(name = "Purchasing_deadline")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date procurementDeadline;
    @Column(name = "state")
    private Integer state;
    @Column(name = "contact_people")
    private String contactPeople;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;

    public Purchase() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Purchase purchase = (Purchase) o;
        return Objects.equals(purchaseId, purchase.purchaseId) &&
                Objects.equals(purchaseTitle, purchase.purchaseTitle) &&
                Objects.equals(productName, purchase.productName) &&
                Objects.equals(originRequirements, purchase.originRequirements) &&
                Objects.equals(specificationType, purchase.specificationType) &&
                Objects.equals(level, purchase.level) &&
                Objects.equals(warehouse, purchase.warehouse) &&
                Objects.equals(purchaseSport, purchase.purchaseSport) &&
                Objects.equals(purchasePrice, purchase.purchasePrice) &&
                Objects.equals(procurementNotes, purchase.procurementNotes) &&
                Objects.equals(paymentMethod, purchase.paymentMethod) &&
                Objects.equals(invoiceType, purchase.invoiceType) &&
                Objects.equals(receivingAddress, purchase.receivingAddress) &&
                Objects.equals(procurementDeadline, purchase.procurementDeadline) &&
                Objects.equals(state, purchase.state) &&
                Objects.equals(contactPeople, purchase.contactPeople) &&
                Objects.equals(companyName, purchase.companyName) &&
                Objects.equals(phone, purchase.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, purchaseTitle, productName, originRequirements, specificationType, level, warehouse, purchaseSport, purchasePrice, procurementNotes, paymentMethod, invoiceType, receivingAddress, procurementDeadline, state, contactPeople, companyName, phone);
    }

    @Override
    public String toString() {
        return "purchase{" +
                "purchaseId='" + purchaseId + '\'' +
                ", purchaseTitle='" + purchaseTitle + '\'' +
                ", productName='" + productName + '\'' +
                ", originRequirements='" + originRequirements + '\'' +
                ", specificationType='" + specificationType + '\'' +
                ", level='" + level + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", purchaseSport='" + purchaseSport + '\'' +
                ", purchasePrice='" + purchasePrice + '\'' +
                ", procurementNotes='" + procurementNotes + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", receivingAddress='" + receivingAddress + '\'' +
                ", procurementDeadline=" + procurementDeadline +
                ", state=" + state +
                ", contactPeople='" + contactPeople + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseTitle() {
        return purchaseTitle;
    }

    public void setPurchaseTitle(String purchaseTitle) {
        this.purchaseTitle = purchaseTitle;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOriginRequirements() {
        return originRequirements;
    }

    public void setOriginRequirements(String originRequirements) {
        this.originRequirements = originRequirements;
    }

    public String getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(String specificationType) {
        this.specificationType = specificationType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getPurchaseSport() {
        return purchaseSport;
    }

    public void setPurchaseSport(String purchaseSport) {
        this.purchaseSport = purchaseSport;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getProcurementNotes() {
        return procurementNotes;
    }

    public void setProcurementNotes(String procurementNotes) {
        this.procurementNotes = procurementNotes;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public Date getProcurementDeadline() {
        return procurementDeadline;
    }

    public void setProcurementDeadline(Date procurementDeadline) {
        this.procurementDeadline = procurementDeadline;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Purchase(String purchaseId, String purchaseTitle, String productName, String originRequirements, String specificationType, String level, String warehouse, String purchaseSport, String purchasePrice, String procurementNotes, String paymentMethod, String invoiceType, String receivingAddress, Timestamp procurementDeadline, Integer state, String contactPeople, String companyName, String phone) {
        this.purchaseId = purchaseId;
        this.purchaseTitle = purchaseTitle;
        this.productName = productName;
        this.originRequirements = originRequirements;
        this.specificationType = specificationType;
        this.level = level;
        this.warehouse = warehouse;
        this.purchaseSport = purchaseSport;
        this.purchasePrice = purchasePrice;
        this.procurementNotes = procurementNotes;
        this.paymentMethod = paymentMethod;
        this.invoiceType = invoiceType;
        this.receivingAddress = receivingAddress;
        this.procurementDeadline = procurementDeadline;
        this.state = state;
        this.contactPeople = contactPeople;
        this.companyName = companyName;
        this.phone = phone;
    }
}
