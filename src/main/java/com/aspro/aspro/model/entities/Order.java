package com.aspro.aspro.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "status", nullable = false)
    private Character status;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id_FK", nullable = false)
    private Vehicle vehicleIdFK;

    @ManyToOne
    @JoinColumn(name = "customer_id_fk", nullable = false)
    private Customer customerIdFK;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Vehicle getVehicleIdFK() {
        return vehicleIdFK;
    }

    public void setVehicleIdFK(Vehicle vehicleIdFK) {
        this.vehicleIdFK = vehicleIdFK;
    }

    public Customer getCustomerIdFK() {
        return customerIdFK;
    }

    public void setCustomerIdFK(Customer customerIdFK) {
        this.customerIdFK = customerIdFK;
    }
}
