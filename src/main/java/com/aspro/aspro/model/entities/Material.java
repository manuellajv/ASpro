package com.aspro.aspro.model.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Integer materialId;

    @Column(name = "material_desc", nullable = false, length = 150)
    private String material_desc;

    @Column(name = "material_type", nullable = false)
    private Character type;

    @Column(name = "unit", nullable = false)
    private Character unit;

    @Column(name = "purchase_price", nullable = false)
    private BigDecimal purchasePrice;

    @Column(name = "sale_price", nullable = false)
    private BigDecimal salePrice;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterial_desc() {
        return material_desc;
    }

    public void setMaterial_desc(String material_desc) {
        this.material_desc = material_desc;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Character getUnit() {
        return unit;
    }

    public void setUnit(Character unit) {
        this.unit = unit;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
