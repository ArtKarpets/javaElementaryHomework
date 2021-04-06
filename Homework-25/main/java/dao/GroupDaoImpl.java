package dao;


import model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.ClientServiceImpl;
import util.HibernateUtil;

public class GroupDaoImpl implements GroupDao {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public void save(Group group) {
        logger.debug(group.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(group);
        transaction.commit();
        session.close();
    }
}
