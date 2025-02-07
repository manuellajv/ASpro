package com.aspro.aspro.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orders_materials")
public class OrderMaterial {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order orderIdFK;

    @Id
    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    private Material materialIdFK;

    public Order getOrderIdFK() {
        return orderIdFK;
    }

    public void setOrderIdFK(Order orderIdFK) {
        this.orderIdFK = orderIdFK;
    }

    public Material getMaterialIdFK() {
        return materialIdFK;
    }

    public void setMaterialIdFK(Material materialIdFK) {
        this.materialIdFK = materialIdFK;
    }
}
