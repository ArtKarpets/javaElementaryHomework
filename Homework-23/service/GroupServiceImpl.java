package service;

import dao.GroupDao;
import dao.GroupDaoImpl;
import model.Group;

public class GroupServiceImpl implements GroupService {

    @Override
    public void save(Group group) {
        GroupDao clientDao = new GroupDaoImpl();
        clientDao.save(group);
    }
}
