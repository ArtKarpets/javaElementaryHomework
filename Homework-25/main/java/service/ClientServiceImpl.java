package service;


import dao.ClientDao;
import dao.ClientDaoImpl;

import model.Client;
import org.apache.log4j.Logger;

public class ClientServiceImpl implements ClientService {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public void save(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void delete(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void update(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public Client getById(int id) {
        logger.debug(id);
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getById(id);
    }

    @Override
    public Client getByPhone(String phone) {
        logger.debug(String.format("ClientServiceImpl.getByPhone : ", phone));
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getByPhone(phone);
    }
}



