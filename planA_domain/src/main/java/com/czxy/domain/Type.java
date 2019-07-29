package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@Table(name = "type")
public class Type {
    @Id
    private Integer typeId;
    private String typeName;

    public Type() {
    }

    public Type(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
