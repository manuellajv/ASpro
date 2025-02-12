package com.aspro.aspro.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JpaUtil {
    private static EntityManagerFactory emf;


    public static EntityManagerFactory createEmf(){
        var dbProps = loadConnectionProperties();
        emf = Persistence.createEntityManagerFactory("asproPU", dbProps);
        return emf;
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
            emf.close();
    }

    private static Map<String, String> loadConnectionProperties(){
        try(FileInputStream fs = new FileInputStream("src/main/resources/config/db.properties")){
            var props = new Properties();
            props.load(fs);

            Map<String, String> dbSettings = new HashMap<>();
            dbSettings.put(props.getProperty("urlProp"), props.getProperty("dburl"));
            dbSettings.put(props.getProperty("userProp"), props.getProperty("dbuser"));
            dbSettings.put(props.getProperty("passwProp"), props.getProperty("dbpassw"));

            return dbSettings;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
