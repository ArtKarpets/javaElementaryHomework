
import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(client);
    }
}
