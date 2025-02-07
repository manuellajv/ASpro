package com.aspro.aspro.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cpf_cnpj", nullable = false, length = 18)
    private String cpfCnpj;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "email", length = 50)
    private String email;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCpfCnpj(){
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }

    public Long getPhone(){
        return phone;
    }

    public void setPhone(Long phone){
        this.phone = phone;
    }

    public  String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}

