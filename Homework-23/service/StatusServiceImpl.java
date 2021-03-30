package service;

import dao.StatusDao;
import dao.StatusDaoImpl;
import model.Status;

public class StatusServiceImpl implements StatusService {

    @Override
    public void save(Status status) {
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.save(status);
    }

    @Override
    public void delete(Status status) {
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.delete(status);
    }

    @Override
    public void update(Status status) {
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.update(status);
    }

    @Override
    public Status getById(int id) {
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.getById(id);
    }
}
