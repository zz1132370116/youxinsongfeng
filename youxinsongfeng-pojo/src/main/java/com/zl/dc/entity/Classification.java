package com.zl.dc.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/8 19:42
 * @Description:
 */
@Entity
@ToString
@Data
public class Classification {
    @Id
    @Column(name = "classification_id")
    private int classificationId;
    @Column(name = "Classification_name")
    private String classificationName;
    @Column(name = "classification_parent")
    private String classificationParent;

    @Transient
    private List<Classification> classification;

    @Id
    @Column(name = "classification_id", nullable = false)
    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    @Basic
    @Column(name = "Classification_name", nullable = false, length = 100)
    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    @Basic
    @Column(name = "classification_parent", nullable = true, length = 100)
    public String getClassificationParent() {
        return classificationParent;
    }

    public void setClassificationParent(String classificationParent) {
        this.classificationParent = classificationParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Classification that = (Classification) o;
        return classificationId == that.classificationId &&
                Objects.equals(classificationName, that.classificationName) &&
                Objects.equals(classificationParent, that.classificationParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classificationId, classificationName, classificationParent);
    }
}
