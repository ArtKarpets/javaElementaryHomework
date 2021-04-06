package dao;

import model.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.ClientServiceImpl;
import util.HibernateUtil;

public class ClientDaoImpl implements ClientDao {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public void save(Client client) {
        logger.debug(client.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    public void delete(Client client) {
        logger.debug(client.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        logger.debug(client.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client getById(int id) {
        logger.debug(String.format("ClientDaoImpl.getById : ", id));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Client.class).getReference(id);
    }

    @Override
    public Client getByPhone(String phone) {
        logger.debug(String.format("ClientDaoImpl.getByPhone", phone));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM model.Client WHERE phone = :phone");
        query.setParameter("phone", phone);
        Client client = (Client) query.uniqueResult();

        return client;
    }
}



