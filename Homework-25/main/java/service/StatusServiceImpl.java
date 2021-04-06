package service;

import dao.StatusDao;
import dao.StatusDaoImpl;
import model.Status;
import org.apache.log4j.Logger;

public class StatusServiceImpl implements StatusService {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public void save(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.save(status);
    }

    @Override
    public void delete(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.delete(status);
    }

    @Override
    public void update(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.update(status);
    }

    @Override
    public Status getById(int id) {
        logger.debug(String.format("StatusServiceImpl.getById : ", id));
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.getById(id);
    }
}
