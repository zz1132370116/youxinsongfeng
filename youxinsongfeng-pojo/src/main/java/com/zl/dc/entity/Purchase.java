package com.zl.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private String ProductName;
    @Column(name = "Origin_requirements")
    private String OriginRequirements;
    @Column(name = "Specification_type")
    private String SpecificationType;
    @Column(name = "LEVEL")
    private String level;
    @Column(name = "Warehouse")
    private String Warehouse;
    @Column(name = "Goods_in_stock")
    private String purchaseSport;
    @Column(name = "Price")
    private String purchasePrice;
    @Column(name = "Procurement_Notes")
    private String ProcurementNotes;
    @Column(name = "Payment_method")
    private String paymentMethod;
    @Column(name = "Invoice_type")
    private String invoiceType;
    @Column(name = "Receiving_address")
    private String ReceivingAddress;
    @Column(name = "Purchasing_deadline")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp procurementDeadline;
    @Column(name = "state")
    private Integer state;
    @Column(name = "contact_people")
    private String ContactPeople;
    @Column(name = "company_name")
    private String CompanyName;
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
                Objects.equals(ProductName, purchase.ProductName) &&
                Objects.equals(OriginRequirements, purchase.OriginRequirements) &&
                Objects.equals(SpecificationType, purchase.SpecificationType) &&
                Objects.equals(level, purchase.level) &&
                Objects.equals(Warehouse, purchase.Warehouse) &&
                Objects.equals(purchaseSport, purchase.purchaseSport) &&
                Objects.equals(purchasePrice, purchase.purchasePrice) &&
                Objects.equals(ProcurementNotes, purchase.ProcurementNotes) &&
                Objects.equals(paymentMethod, purchase.paymentMethod) &&
                Objects.equals(invoiceType, purchase.invoiceType) &&
                Objects.equals(ReceivingAddress, purchase.ReceivingAddress) &&
                Objects.equals(procurementDeadline, purchase.procurementDeadline) &&
                Objects.equals(state, purchase.state) &&
                Objects.equals(ContactPeople, purchase.ContactPeople) &&
                Objects.equals(CompanyName, purchase.CompanyName) &&
                Objects.equals(phone, purchase.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, purchaseTitle, ProductName, OriginRequirements, SpecificationType, level, Warehouse, purchaseSport, purchasePrice, ProcurementNotes, paymentMethod, invoiceType, ReceivingAddress, procurementDeadline, state, ContactPeople, CompanyName, phone);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId='" + purchaseId + '\'' +
                ", purchaseTitle='" + purchaseTitle + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", OriginRequirements='" + OriginRequirements + '\'' +
                ", SpecificationType='" + SpecificationType + '\'' +
                ", level='" + level + '\'' +
                ", Warehouse='" + Warehouse + '\'' +
                ", purchaseSport='" + purchaseSport + '\'' +
                ", purchasePrice='" + purchasePrice + '\'' +
                ", ProcurementNotes='" + ProcurementNotes + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", ReceivingAddress='" + ReceivingAddress + '\'' +
                ", procurementDeadline=" + procurementDeadline +
                ", state=" + state +
                ", ContactPeople='" + ContactPeople + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
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
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getOriginRequirements() {
        return OriginRequirements;
    }

    public void setOriginRequirements(String originRequirements) {
        OriginRequirements = originRequirements;
    }

    public String getSpecificationType() {
        return SpecificationType;
    }

    public void setSpecificationType(String specificationType) {
        SpecificationType = specificationType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(String warehouse) {
        Warehouse = warehouse;
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
        return ProcurementNotes;
    }

    public void setProcurementNotes(String procurementNotes) {
        ProcurementNotes = procurementNotes;
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
        return ReceivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        ReceivingAddress = receivingAddress;
    }

    public Timestamp getProcurementDeadline() {
        return procurementDeadline;
    }

    public void setProcurementDeadline(Timestamp procurementDeadline) {
        this.procurementDeadline = procurementDeadline;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContactPeople() {
        return ContactPeople;
    }

    public void setContactPeople(String contactPeople) {
        ContactPeople = contactPeople;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
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
        ProductName = productName;
        OriginRequirements = originRequirements;
        SpecificationType = specificationType;
        this.level = level;
        Warehouse = warehouse;
        this.purchaseSport = purchaseSport;
        this.purchasePrice = purchasePrice;
        ProcurementNotes = procurementNotes;
        this.paymentMethod = paymentMethod;
        this.invoiceType = invoiceType;
        ReceivingAddress = receivingAddress;
        this.procurementDeadline = procurementDeadline;
        this.state = state;
        ContactPeople = contactPeople;
        CompanyName = companyName;
        this.phone = phone;
    }
}
