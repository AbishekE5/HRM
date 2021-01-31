package com.ideas2it.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;

public class Datasource {

        private static StandardServiceRegistry standardServiceRegistry;
        private static SessionFactory sessionFactory;

    private Datasource() {
    }
    public static SessionFactory getInstance() {
            try {
                if (sessionFactory == null) {
                    Configuration configuration = new Configuration();
                    configuration.configure("resources/properties/hibernate.cfg.xml");
                    sessionFactory = configuration.buildSessionFactory();
                }
            } catch (Exception exception) {
                System.out.println("Could not load connection" + exception.getMessage());
                exception.printStackTrace();
            }
            return sessionFactory;
        }
}
