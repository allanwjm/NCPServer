package edu.sysu.ncpserver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by mura on 4/1/16
 */
public class HibernateFactory {

    // Hibernate session factory. Singleton.
    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    // Get a session from session factory
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // Close the session factory
    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
