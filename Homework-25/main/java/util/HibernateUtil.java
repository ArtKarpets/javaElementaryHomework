package util;

import model.Account;
import model.Client;
import model.Group;
import model.Status;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import service.ClientServiceImpl;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static Logger logger = Logger.getLogger(ClientServiceImpl.class);

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Status.class);
                configuration.addAnnotatedClass(Group.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                logger.error("HibernateUtil.getSessionFactory : ", e);
                System.out.println("Look at the logs " + e);
            }
        }
        return sessionFactory;
    }
}

