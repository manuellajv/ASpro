package com.aspro.aspro.model.dao;

import com.aspro.aspro.model.entities.Customer;
import jakarta.persistence.EntityManager;


public class CustomerDAO {

    private EntityManager em;

    public CustomerDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Customer customer){
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(customer);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public void update(Customer customer){
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(customer);
            tx.commit();
        } catch(RuntimeException e){
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public void delete(Long customerId){
        var tx = em.getTransaction();
        try{
            tx.begin();
            Customer customer = em.find(Customer.class, customerId);
            if(customer != null){
                em.remove(customer);
            }
            tx.commit();
        }catch (RuntimeException e){
            tx.rollback();
            throw new RuntimeException(e);
        }
    }

}
