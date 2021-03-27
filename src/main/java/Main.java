import service.AccountService;
import service.ClientService;
import service.StatusService;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        StatusService statusService = new StatusService();
        ClientService clientService = new ClientService();

        System.out.println(clientService.getAll());
        System.out.println(clientService.getByPhone("380958089090"));
        System.out.println(clientService.getClientJoinAccount());
        System.out.println(clientService.getClientJoinStatus());
        System.out.println(accountService.getNumberByValue(1000));

    }
}
