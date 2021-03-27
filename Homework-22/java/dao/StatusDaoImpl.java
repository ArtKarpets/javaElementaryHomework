package dao;

import model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StatusDaoImpl implements StatusDao {
    @Override
    public void save(Status status) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(status);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Status status) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(status.getId());
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Status status) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(status.getId());
        transaction.commit();
        session.close();
    }

    @Override
    public Status getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Status.class).getReference(id);
    }
}
