package org.apicode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final Session session;

    static {
        try {
            session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class).buildSessionFactory().openSession();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return session;
    }
}
