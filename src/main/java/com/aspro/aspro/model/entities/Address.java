package com.aspro.aspro.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "zip_code", nullable = false)
    private Long zipCode;

    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @Column(name = "addrNumber")
    private Short addrNumber;

    @Column(name = "district", nullable = false, length = 45)
    private String district;

    @Column(name = "city", nullable = false, length = 25)
    private String city;

    @Column(name = "complement", length = 45)
    private String complement;

    @ManyToOne
    @JoinColumn(name = "customer_id_FK", nullable = false)
    private Customer customerIdFk;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Customer getCustomerIdFk() {
        return customerIdFk;
    }

    public void setCustomerIdFk(Customer customerIdFk) {
        this.customerIdFk = customerIdFk;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Short getAddrNumber() {
        return addrNumber;
    }

    public void setAddrNumber(Short addrNumber) {
        this.addrNumber = addrNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
}
