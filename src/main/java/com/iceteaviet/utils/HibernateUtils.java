package com.iceteaviet.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;

/**
 * Created by Genius Doan on 6/6/2017.
 */
public class HibernateUtils {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("main/java/hibernate.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex.toString());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws PersistenceException {
        return ourSessionFactory.openSession();
    }
}
