package com.aspro.aspro.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("asproPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }
}
