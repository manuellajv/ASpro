package com.aspro.aspro.model.dao;

import com.aspro.aspro.model.entities.Address;
import com.aspro.aspro.model.entities.Customer;
import jakarta.persistence.EntityManager;

public class AddressDAO {

    private EntityManager em;

    public AddressDAO(EntityManager em){
        this.em = em;
    }

    public void save(Address address){
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(address);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
    }

    public void update(Address address){
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(address);
            tx.commit();
        } catch(RuntimeException e){
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
