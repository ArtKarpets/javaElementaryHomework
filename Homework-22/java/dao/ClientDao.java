package dao;

import model.Client;


public interface ClientDao {

    void save(Client cliet);

    void delete(Client client);

    void update(Client client);

    Client getById(int id);

    Client getByPhone(String phone);
}
