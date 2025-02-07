package com.aspro.aspro.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdMutability;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "type", nullable = false)
    private Character type;

    @Column(name = "material_quantity", nullable = false)
    private BigDecimal materialQuantity;

    @ManyToOne
    @JoinColumn(name = "material_id_FK", nullable = false)
    private Material materialIdFK;

    @ManyToOne
    @JoinColumn(name = "order_id_FK")
    private Order orderIdFK;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public BigDecimal getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(BigDecimal materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public Material getMaterialIdFK() {
        return materialIdFK;
    }

    public void setMaterialIdFK(Material materialIdFK) {
        this.materialIdFK = materialIdFK;
    }

    public Order getOrderIdFK() {
        return orderIdFK;
    }

    public void setOrderIdFK(Order orderIdFK) {
        this.orderIdFK = orderIdFK;
    }
}
