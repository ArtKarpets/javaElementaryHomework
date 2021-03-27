package dao;

import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class ClientDaoImpl implements ClientDao {

    @Override
    public void save(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    public void delete(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client.getId());
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client.getId());
        transaction.commit();
        session.close();
    }

    @Override
    public Client getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Client.class).getReference(id);
    }

    @Override
    public Client getByPhone(String phone) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM model.Client WHERE phone = :phone");
        query.setParameter("phone", phone);
        Client client = (Client) query.uniqueResult();

        return client;
    }
}



