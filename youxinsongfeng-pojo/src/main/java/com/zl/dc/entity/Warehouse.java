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
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @Column(name = "warehouseId")
    private Integer warehouseId;
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

    public Warehouse() {
    }

    public Warehouse(Integer warehouseId, String quotePeople, String classificationName, String productName, String place, String specificationType, String level, Integer quantity, float price, String currency, String sport, String warehouse, String remarks, String address, String phone) {
        this.warehouseId = warehouseId;
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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
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
        Warehouse warehouse1 = (Warehouse) o;
        return Float.compare(warehouse1.price, price) == 0 &&
                Objects.equals(warehouseId, warehouse1.warehouseId) &&
                Objects.equals(quotePeople, warehouse1.quotePeople) &&
                Objects.equals(classificationName, warehouse1.classificationName) &&
                Objects.equals(productName, warehouse1.productName) &&
                Objects.equals(place, warehouse1.place) &&
                Objects.equals(specificationType, warehouse1.specificationType) &&
                Objects.equals(level, warehouse1.level) &&
                Objects.equals(quantity, warehouse1.quantity) &&
                Objects.equals(currency, warehouse1.currency) &&
                Objects.equals(sport, warehouse1.sport) &&
                Objects.equals(warehouse, warehouse1.warehouse) &&
                Objects.equals(remarks, warehouse1.remarks) &&
                Objects.equals(address, warehouse1.address) &&
                Objects.equals(phone, warehouse1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, quotePeople, classificationName, productName, place, specificationType, level, quantity, price, currency, sport, warehouse, remarks, address, phone);
    }
}
