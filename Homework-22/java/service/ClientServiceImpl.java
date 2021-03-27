package service;


import dao.ClientDao;
import dao.ClientDaoImpl;

import model.Client;

public class ClientServiceImpl implements ClientService {

    @Override
    public void save(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void delete(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void update(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public Client getById(int id) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getById(id);
    }

    @Override
    public Client getByPhone(String phone) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getByPhone(phone);
    }
}



