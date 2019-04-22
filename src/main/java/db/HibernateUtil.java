package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        if (sessionFactory == null) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 }
 