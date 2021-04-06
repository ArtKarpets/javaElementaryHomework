
import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.ClientService;
import service.ClientServiceImpl;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ClientService clientService = new ClientServiceImpl();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(client);
        clientService.getById(3);
    }
}
