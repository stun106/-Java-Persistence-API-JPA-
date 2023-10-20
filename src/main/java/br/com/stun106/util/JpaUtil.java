package br.com.stun106.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("db_projects");
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }


}
