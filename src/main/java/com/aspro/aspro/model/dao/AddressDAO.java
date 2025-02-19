package com.aspro.aspro.model.dao;

import com.aspro.aspro.model.entities.Address;
import jakarta.persistence.EntityManager;

public class AddressDAO {

    private EntityManager em;

    public AddressDAO(EntityManager em){
        this.em = em;
    }

    public void save(Address address){
        var tx = em.getTransaction();
    }
}
