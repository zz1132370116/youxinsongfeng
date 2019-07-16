package com.zl.dc.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/12 15:59
 * @Description:
 */
@Entity
@Data
@ToString
@Table(name = "com")
public class Com {
    @Id
    @Column(name = "comId", nullable = false)
    private Integer comId;
    @Column(name = "commodityId", nullable = false, length = 100)
    private String commodityId;
    @Transient
    private List<Commodity> commoditys;
    @Column(name = "companyId", nullable = false)
    private Integer companyId;
    @Transient
    private List<Company> Companys;


    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Com com = (Com) o;
        return comId == com.comId &&
                companyId == com.companyId &&
                Objects.equals(commodityId, com.commodityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comId, commodityId, companyId);
    }
}
