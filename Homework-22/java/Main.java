
import service.ClientService;
import service.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        System.out.println(clientService.getByPhone("380958089090"));
        System.out.println(clientService.getById(1));
    }
}
