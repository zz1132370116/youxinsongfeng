package com.zl.dc.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/11 16:11
 * @Description:
 */
@Entity
@Data
@ToString
@Table(name = "commodity")
public class Commodity {
    @Id
    @Column(name = "commodityId", nullable = false, length = 100)
    private String commodityId;
    @Column(name = "commodity_name", nullable = false, length = 100)
    private String commodityName;
    @Column(name = "commodity_place")
    private String commodityPlace;
    @Column(name = "commodity_specification", nullable = false, length = 100)
    private String commoditySpecification;
    @Column(name = "commodity_level", nullable = false, length = 100)
    private String commodityLevel;
    @Column(name = "commodity_quantity", nullable = false, length = 100)
    private String commodityQuantity;
    @Column(name = "warehouse_requiements", nullable = false, length = 100)
    private String warehouseRequiements;
    @Column(name = "commodity_price", nullable = false)
    private int commodityPrice;
    @Column(name = "commodity_warehouse", nullable = false, length = 100)
    private String commodityWarehouse;
    @Column(name = "commodity_sport", nullable = false, length = 100)
    private String commoditySport;
    @Column(name = "commodity_supplier", nullable = false, length = 100)
    private String commoditySupplier;
    @Column(name = "supplier_phone", nullable = false, length = 100)
    private String supplierPhone;
    @Column(name = "commodity_image", nullable = true, length = 100)
    private String commodityImage;
    @Transient
    private Company company;


    @Override
    public boolean equals(Object o) {
        if (this == o){return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Commodity commodity = (Commodity) o;
        return commodityPrice == commodity.commodityPrice &&
                Objects.equals(commodityId, commodity.commodityId) &&
                Objects.equals(commodityName, commodity.commodityName) &&
                Objects.equals(commoditySpecification, commodity.commoditySpecification) &&
                Objects.equals(commodityLevel, commodity.commodityLevel) &&
                Objects.equals(commodityQuantity, commodity.commodityQuantity) &&
                Objects.equals(warehouseRequiements, commodity.warehouseRequiements) &&
                Objects.equals(commodityWarehouse, commodity.commodityWarehouse) &&
                Objects.equals(commoditySport, commodity.commoditySport) &&
                Objects.equals(commoditySupplier, commodity.commoditySupplier) &&
                Objects.equals(supplierPhone, commodity.supplierPhone) &&
                Objects.equals(commodityImage, commodity.commodityImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commodityId, commodityName, commoditySpecification, commodityLevel, commodityQuantity, warehouseRequiements, commodityPrice, commodityWarehouse, commoditySport, commoditySupplier, supplierPhone, commodityImage);
    }
}
