package com.zl.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author pds
 */
@Entity
@Table(name="quotation")
public class Quotation {
    @Id
    @Column(name = "quotationId")
    private Integer quotationId;
    @Column(name = "quote_people")
    private String quotePeople;
    @Column(name = "classification_name")
    private String classificationName;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "place")
    private String place;
    @Column(name = "specification_type")
    private String specificationType;
    @Column(name = "level")
    private String level;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private float price;
    @Column(name = "currency")
    private String currency;
    @Column(name = "sport")
    private String sport;
    @Column(name = "warehouse")
    private String warehouse;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    public Quotation() {
    }

    public Quotation(Integer quotationId, String quotePeople, String classificationName, String productName, String place, String specificationType, String level, Integer quantity, float price, String currency, String sport, String warehouse, String remarks, String address, String phone) {
        this.quotationId = quotationId;
        this.quotePeople = quotePeople;
        this.classificationName = classificationName;
        this.productName = productName;
        this.place = place;
        this.specificationType = specificationType;
        this.level = level;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.sport = sport;
        this.warehouse = warehouse;
        this.remarks = remarks;
        this.address = address;
        this.phone = phone;
    }

    public Integer getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Integer quotationId) {
        this.quotationId = quotationId;
    }

    public String getQuotePeople() {
        return quotePeople;
    }

    public void setQuotePeople(String quotePeople) {
        this.quotePeople = quotePeople;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quotation quotation = (Quotation) o;
        return Float.compare(quotation.price, price) == 0 &&
                Objects.equals(quotationId, quotation.quotationId) &&
                Objects.equals(quotePeople, quotation.quotePeople) &&
                Objects.equals(classificationName, quotation.classificationName) &&
                Objects.equals(productName, quotation.productName) &&
                Objects.equals(place, quotation.place) &&
                Objects.equals(specificationType, quotation.specificationType) &&
                Objects.equals(level, quotation.level) &&
                Objects.equals(quantity, quotation.quantity) &&
                Objects.equals(currency, quotation.currency) &&
                Objects.equals(sport, quotation.sport) &&
                Objects.equals(warehouse, quotation.warehouse) &&
                Objects.equals(remarks, quotation.remarks) &&
                Objects.equals(address, quotation.address) &&
                Objects.equals(phone, quotation.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quotationId, quotePeople, classificationName, productName, place, specificationType, level, quantity, price, currency, sport, warehouse, remarks, address, phone);
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "quotationId=" + quotationId +
                ", quotePeople='" + quotePeople + '\'' +
                ", classificationName='" + classificationName + '\'' +
                ", productName='" + productName + '\'' +
                ", place='" + place + '\'' +
                ", specificationType='" + specificationType + '\'' +
                ", level='" + level + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", sport='" + sport + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", remarks='" + remarks + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
